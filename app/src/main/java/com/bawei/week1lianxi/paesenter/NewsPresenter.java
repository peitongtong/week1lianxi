package com.bawei.week1lianxi.paesenter;

import com.bawei.week1lianxi.contract.INewsContract;
import com.bawei.week1lianxi.model.NewsModel;
import com.bawei.week1lianxi.model.entity.ProductEntity;

public class NewsPresenter implements INewsContract.IPresenter {

    private NewsModel newsModel;

    @Override
    public void getProductListData(String Url) {
        newsModel = new NewsModel();
        newsModel.getProductListData(Url, new INewsContract.IModel.ModelCallback() {
            @Override
            public void success(ProductEntity productEntity) {
                
            }
        });
    }

}
