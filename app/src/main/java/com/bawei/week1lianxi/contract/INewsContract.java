package com.bawei.week1lianxi.contract;

import com.bawei.week1lianxi.model.entity.ProductEntity;
import com.bawei.week1lianxi.utils.NetUtil;

public interface INewsContract {

    interface IModel{

        void getProductListData(String Url,ModelCallback modelCallback);

        interface ModelCallback{
            void success(ProductEntity productEntity);
        }
    }
    interface IView{
        void success(ProductEntity productEntity);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void getProductListData(String Url);
    }
}
