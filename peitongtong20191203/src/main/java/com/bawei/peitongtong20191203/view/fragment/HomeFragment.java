package com.bawei.peitongtong20191203.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.peitongtong20191203.R;
import com.bawei.peitongtong20191203.base.BaseFragment;
import com.bawei.peitongtong20191203.utils.NetUtil;

public class HomeFragment extends BaseFragment {

    private TextView text_view;
    private ImageView image_view;
    private TextView text2;

    @Override
    protected void initView(View view) {
        text_view = view.findViewById(R.id.text_view);
        image_view = view.findViewById(R.id.image_view);
        text2 = view.findViewById(R.id.text2);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        if (NetUtil.getNetUtil().hasNet(getActivity())){
            text_view.setVisibility(View.VISIBLE);
            image_view.setVisibility(View.GONE);
            text2.setVisibility(View.GONE);
        }else {
            text_view.setVisibility(View.GONE);
            image_view.setVisibility(View.VISIBLE);
            text2.setVisibility(View.VISIBLE);
        }
    }
}
