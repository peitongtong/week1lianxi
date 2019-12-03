package com.bawei.peitongtong20191203.model;

import java.util.List;

public class Bean {



    private String code;
    private List<ShopGridDataBean> shopGridData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ShopGridDataBean> getShopGridData() {
        return shopGridData;
    }

    public void setShopGridData(List<ShopGridDataBean> shopGridData) {
        this.shopGridData = shopGridData;
    }

    public static class ShopGridDataBean {


        private String title;
        private String price;
        private String imageurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
