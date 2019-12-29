package com.example.ssp.mingrigson.activity.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.ssp.mingrigson.R;
import com.example.ssp.mingrigson.activity.app.MineApplication;

/**
 * Created by ${宋少鹏} on 2019/12/27.
 * 基类
 * 邮箱:4646224@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity{
    protected RequestQueue requestQueue;//请求队列
    private RelativeLayout titleBar;//标题栏
    private ImageButton backBtn;//返回按钮
    private TextView titleName;//标题的名字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue= MineApplication.getRequestQueue();//获取请求队列 对象
        addContentView();//设置界面布局
        if(initTetleBar()){
            titleBar=(RelativeLayout)findViewById(R.id.title_bar);
            backBtn=(ImageButton)findViewById(R.id.back_btn);
            titleName=(TextView)findViewById(R.id.title_name);
            setTitleBarShowType();
            addListener();
        }
        initContentView();//初始化界面
    }



    protected  void addListener(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * 标题栏显示效果
     */
    protected  void setTitleBarShowType(){
        if(showBackBtn()){
            backBtn.setVisibility(View.VISIBLE);
        }else {
            backBtn.setVisibility(View.GONE);
        }

    }
    //返回按钮默认没有   无abs不抽象不用重写
    protected  boolean showBackBtn(){
     return false;
    }

    protected abstract void addContentView();
    protected abstract void initContentView();

    protected abstract boolean initTetleBar();//默认false

    /**
     *设置标题栏背景
     * @param color
     */
    protected final void setTitleBackgroundColor(@ColorInt int color){
        titleBar.setBackgroundColor(color);
    }

    /**
     *  //标题显示内容@NonNullI限制
     * @param name
     */

    protected final void setTitleName(@NonNull String name){
        titleName.setText(name);
    }

    /**
     * 字体颜色
     * @param color
     */
    protected  final void setTitleNameColor(@ColorInt int color){
        titleName.setTextColor(color);
    }

    @Override
    protected void onDestroy() {
        requestQueue.stop();//页面销毁 停止
        super.onDestroy();
    }
}
