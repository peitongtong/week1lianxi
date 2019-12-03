package com.bawei.peitongtong20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.peitongtong20191203.R;
import com.bawei.peitongtong20191203.model.Bean;
import com.bawei.peitongtong20191203.utils.NetUtil;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Bean.ShopGridDataBean> list;

    public MyAdapter(List<Bean.ShopGridDataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            view = View.inflate(parent.getContext(), R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.image_view);
            holder.textView1 = view.findViewById(R.id.text_view1);
            holder.textView2 = view.findViewById(R.id.text_view2);
            view.setTag(holder);
        }else {
            holder  = (ViewHolder) view.getTag();
        }
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getPrice());
        String Url = list.get(position).getImageurl();
        NetUtil.getNetUtil().doGetPhoto(Url,holder.imageView);
        return view;
    }
    class ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
    }
}
