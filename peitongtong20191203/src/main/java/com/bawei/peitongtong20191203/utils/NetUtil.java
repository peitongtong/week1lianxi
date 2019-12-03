package com.bawei.peitongtong20191203.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
}
