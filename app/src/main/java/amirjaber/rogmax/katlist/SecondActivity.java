package amirjaber.rogmax.katlist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.listView2);
        TextView tvNum = findViewById(R.id.num);

        ArrayList<GoodsModel> arrayList = getIntent().getParcelableArrayListExtra("My List");
        arrayList.size();
        tvNum.setText("Your cart has " + arrayList.size() + " good(s): ");

        GoodsCheckedAdapter goodsCheckedAdapter = new GoodsCheckedAdapter(this, arrayList);
        listView.setAdapter(goodsCheckedAdapter);


        Toast.makeText(this, "The number of goods is " + arrayList.size(), Toast.LENGTH_SHORT).show();
    }
}
