package amirjaber.rogmax.katlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodsCheckedAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<GoodsModel> mList;

    public GoodsCheckedAdapter(Context context, ArrayList<GoodsModel> mList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview2_item, null);
        }

        GoodsModel goodsModel = mList.get(position);

        TextView tvNum = convertView.findViewById(R.id.id);
        TextView tvGoods = convertView.findViewById(R.id.good);

        tvNum.setText(Integer.toString(goodsModel.getId()));
        tvGoods.setText(goodsModel.getName());

        return convertView;
    }
}
