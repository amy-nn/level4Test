package com.example.level4.login;

import android.util.Log;
import com.example.core.mvp.ui.IModel;
import com.example.level4.Result;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * M层：真正的实现数据访问逻辑
 */
public class APPLoginModel implements LoginConstract.LoginModel {

    @Override
    public void getData(final String url, final Result result) {
//        if(url != null){
            new Thread(){
                @Override
                public void run() {
                    try {
                        URL url1 = new URL("http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html?tdsourcetag=s_pctim_aiomsghttp://litchiapi.jstv.com/api/GetFeeds?column=5&PageSize=30&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41");
                        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                        InputStream inputStream = null;
                        if(connection.getResponseCode() == 200){
                            inputStream = connection.getInputStream();
                            int len = 0;
                            byte[] bytes = new byte[1024];
                            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                            while ((len = inputStream.read(bytes)) != -1){
                                outputStream.write(bytes,0,len);
                            }
                            result.success(outputStream.toString());
//                            Log.d("amy", "run: something"+outputStream.toString());
                        }
                        else {
                            result.success("sorry network is error");
//                            Log.d("amy", "run: sorry network is error");
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
//        }
    }

//    @Override
//    public void getData(final String url, final Result result) {
//        result.success("sorry network is error");
//    }
}
