package com.bawei.peitongtong20191203.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {
    private static NetUtil netUtil = new NetUtil();
    private NetUtil(){}

    public static NetUtil getNetUtil() {
        return netUtil;
    }
    public interface MyCallBack{
        void getJson(String json);
    }
    public String io2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }
    @SuppressLint("StaticFieldLeak")
    public String doGet(final String Url, final MyCallBack myCallBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                myCallBack.getJson(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                InputStream inputStream = null;
                String json = "";
                try {
                    URL url = new URL(Url);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    if (connection.getResponseCode()==200){
                        Log.i("TAG", "数据请求成功");
                        inputStream = connection.getInputStream();
                        json = io2String(inputStream);
                    }else {
                        Log.i("TAG", "数据请求失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }
        }.execute();
        return null;
    }
    public Bitmap io2Bitmap (InputStream inputStream){
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }
    @SuppressLint("StaticFieldLeak")
    public Bitmap doGetPhoto(final String Url, final ImageView imageView){
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(String... strings) {
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    URL url = new URL(Url);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("GET");
                    connection.connect();
                    if (connection.getResponseCode()==200){
                        Log.i("TAG", "数据请求成功");
                        inputStream = connection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }else {
                        Log.i("TAG", "数据请求失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }
        }.execute();
        return null;
    }
    public boolean hasNet(Context context){
        return true;
    }
}
