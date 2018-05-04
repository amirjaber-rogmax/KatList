package amirjaber.rogmax.katlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<GoodsModel> mList;
    private ArrayList<GoodsModel> mListChecked = new ArrayList<>();
    private OnChangeListener onChangeListener;

    GoodsAdapter(Context context, ArrayList<GoodsModel> list, OnChangeListener onChangeListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mList = list;
        this.onChangeListener = onChangeListener;
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
            convertView = layoutInflater.inflate(R.layout.listview_item, null);
        }

        GoodsModel goodsModel = mList.get(position);

        TextView tvNum = convertView.findViewById(R.id.id);
        TextView tvGoods = convertView.findViewById(R.id.good);
        CheckBox checkBox = convertView.findViewById(R.id.check);

        tvNum.setText(Integer.toString(goodsModel.getId()));
        tvGoods.setText(goodsModel.getName());
        checkBox.setTag(position);
        checkBox.setChecked(goodsModel.isCheck());
        checkBox.setOnCheckedChangeListener(onCheckedChangeListener);

        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.parseColor("#D2C1E3"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#B0C1D2"));
        }

        return convertView;
    }

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.isShown()) {
                int i = (int) buttonView.getTag();
                mList.get(i).setCheck(isChecked);
                notifyDataSetChanged();

                if (isChecked) {
                    mListChecked.add(mList.get(i));
                } else {
                    mListChecked.remove(mList.get(i));
                }
                onChangeListener.onDataChanged();
            }
        }
    };

    public ArrayList<GoodsModel> getmListChecked() {
        return mListChecked;
    }
}

