package com.bawei.week1lianxi.model;

import com.bawei.week1lianxi.contract.INewsContract;
import com.bawei.week1lianxi.model.entity.ProductEntity;
import com.bawei.week1lianxi.utils.NetUtil;
import com.google.gson.Gson;

import java.util.GregorianCalendar;

public class NewsModel implements INewsContract.IModel {


    @Override
    public void getProductListData(String Url, final ModelCallback modelCallback) {
        NetUtil.getNetUtil().doGet(Url, new NetUtil.MyCallBack() {
            @Override
            public void getJson(String json) {
                ProductEntity productEntity = new Gson().fromJson(json,ProductEntity.class);
                modelCallback.success(productEntity);
            }
        });
    }
}
