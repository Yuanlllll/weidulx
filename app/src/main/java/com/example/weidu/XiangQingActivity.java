package com.example.weidu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weidu.bean.XiangBean;
import com.example.weidu.xiang.view.Iview;

public class XiangQingActivity extends AppCompatActivity implements Iview {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
    }

    @Override
    public void getVdata(XiangBean xiangBean)
    {


    }
}
