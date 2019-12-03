package com.bawei.peitongtong20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.peitongtong20191203.model.Bean;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    class ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
    }
}
