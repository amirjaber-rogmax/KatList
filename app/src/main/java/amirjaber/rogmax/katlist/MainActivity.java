package amirjaber.rogmax.katlist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChangeListener {

    private ListView listView;
    private ArrayList<GoodsModel> arrayList = new ArrayList<>();
    private ArrayList<GoodsModel> checkedArrayList = new ArrayList<>();
    private GoodsAdapter goodsAdapter;
    private LayoutInflater layoutInflater;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        createMyListView();
    }

    private void init() {
        listView = findViewById(R.id.listView);
        Button button = findViewById(R.id.btn_show);
        tvCount = findViewById(R.id.count);
        layoutInflater = LayoutInflater.from(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedArrayList = goodsAdapter.getmListChecked();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putParcelableArrayListExtra("My List", checkedArrayList);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("InflateParams")
    private void createMyListView() {
        fillData();
        goodsAdapter = new GoodsAdapter(this, arrayList, this);
        View viewHeader = layoutInflater.inflate(R.layout.listview_header, null);
        listView.addHeaderView(viewHeader);
        listView.setAdapter(goodsAdapter);

    }

    private void fillData() {
        int i = 0;
        int SIZE_OFF_ARRAY = 25;
        while (i < SIZE_OFF_ARRAY) {
            i++;
            arrayList.add(new GoodsModel(i, " " + "My good №" + i, false));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDataChanged() {
        int size = goodsAdapter.getmListChecked().size();
        tvCount.setText("Count of goods = " + size + "");
    }
}
