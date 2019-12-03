package com.bawei.peitongtong20191203.view.fragment;

import android.mtp.MtpConstants;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.bawei.peitongtong20191203.R;
import com.bawei.peitongtong20191203.base.BaseFragment;
import com.bawei.peitongtong20191203.model.Bean;
import com.bawei.peitongtong20191203.utils.NetUtil;
import com.bawei.peitongtong20191203.view.activity.MainActivity;
import com.bawei.peitongtong20191203.view.adapter.MyAdapter;
import com.google.gson.Gson;

import java.util.List;


public class GouwuFragment extends BaseFragment {

    private GridView gv;
    private Button button;
    private String Url = "http://blog.zhaoliang5156.cn/api/mall/mall.json";
    @Override
    protected void initView(View view) {
        gv = view.findViewById(R.id.gv);
        button = view.findViewById(R.id.button);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_gou;
    }

    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.jump();
            }
        });
        NetUtil.getNetUtil().doGet(Url, new NetUtil.MyCallBack() {
            @Override
            public void getJson(String json) {
                Bean bean = new Gson().fromJson(json,Bean.class);
                List<Bean.ShopGridDataBean> list = bean.getShopGridData();
                gv.setAdapter(new MyAdapter(list));
            }
        });
    }
}
