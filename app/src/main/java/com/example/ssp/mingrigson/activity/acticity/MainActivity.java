package com.example.ssp.mingrigson.activity.acticity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.ssp.mingrigson.R;
import com.example.ssp.mingrigson.activity.adapter.ClazxxAdapter;
import com.example.ssp.mingrigson.activity.base.BaseActivity;
import com.example.ssp.mingrigson.activity.bean.Clazz;
import com.example.ssp.mingrigson.activity.listener.Service;
import com.google.gson.Gson;

import java.io.StringReader;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ListView classList;
    private List<Clazz.ResultBean> list;



    @Override
    protected void addContentView() {
        setContentView(R.layout.activity_main);

    }

    /**
     * 初始化界面
     */
    @Override
    protected void initContentView() {
        setTitleName("课程分类");
        setTitleBackgroundColor(0xffffffff);//白色背景
        setTitleNameColor(0xff000000);//黑色标题
        classList=(ListView)findViewById(R.id.class_list);
        //创建网络数据的请求
        //http://v.juhe.cn/sms/send
        StringRequest request=new StringRequest("http://4646224a.12host.top/API/index.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("请求结果",response);
               //数据成功此方法
             /*   Clazz clazz=new Gson().fromJson(response,Clazz.class);//解析数据
                 list= clazz.getResult();//获取数据集合
                ClazxxAdapter adapter=new ClazxxAdapter(list,MainActivity.this);
                classList.setAdapter(adapter);//绑定适配器*/
            }
        },new Response.ErrorListener() {//必须有失败方法
            @Override
            public void onErrorResponse(VolleyError error) {
                //请求数据失败调用此方法

            }
        });
        requestQueue.add(request);//添加进去
  }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
        return super.onTouchEvent(event);
    }

    /**
     * 使用标题栏
     * @return
     */
    @Override
    protected boolean initTetleBar() {
        return true;
    }
}
