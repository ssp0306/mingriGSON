package com.example.ssp.mingrigson.activity.acticity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ssp.mingrigson.R;
import com.example.ssp.mingrigson.activity.base.BaseActivity;

public class SecondActivity extends BaseActivity {



    @Override
    protected void addContentView() {
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void initContentView() {
        setTitleName("ssp");
        setTitleNameColor(Color.WHITE);//TRent默认补全为透明

    }

    @Override
    protected boolean initTetleBar() {
        return true;
    }

    @Override
    protected boolean showBackBtn() {
        return true;
    }
}
