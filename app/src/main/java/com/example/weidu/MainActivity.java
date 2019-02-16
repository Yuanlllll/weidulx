package com.example.weidu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weidu.fragment.ErFragment;
import com.example.weidu.fragment.SanFragment;
import com.example.weidu.fragment.ShowFragment;
import com.example.weidu.fragment.SiFragment;
import com.example.weidu.fragment.WoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fragment)
    BottomTabBar fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragment.init(getSupportFragmentManager())
                .setFontSize(18)
                .setTabPadding(4,6,10)
                .setImgSize(50,50)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.ufos, ShowFragment.class)
                .addTabItem("分类", R.drawable.fangs, ErFragment.class)
                .addTabItem("发现", R.drawable.my, SanFragment.class)
                .addTabItem("购物车", R.drawable.ufos, SiFragment.class)
                .addTabItem("我的", R.drawable.my, WoFragment.class)
                .isShowDivider(false);
    }
}
