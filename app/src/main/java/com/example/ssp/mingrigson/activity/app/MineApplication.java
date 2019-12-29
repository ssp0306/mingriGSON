package com.example.ssp.mingrigson.activity.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ${宋少鹏} on 2019/12/27.
 * 邮箱:4646224@qq.com
 */
public class MineApplication extends Application{
    private  static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue= Volley.newRequestQueue(this);

    }
    public  static  RequestQueue getRequestQueue(){
            return requestQueue;
    }
}
