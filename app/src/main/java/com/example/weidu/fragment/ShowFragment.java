package com.example.weidu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.weidu.R;
import com.example.weidu.adapter.MyAdapter;
import com.example.weidu.bean.ShowBean;
import com.example.weidu.login.presenter.LoginPresenter;
import com.example.weidu.login.view.LoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ShowFragment extends Fragment  implements LoginView {
 @BindView(R.id.shouye_recy)
 RecyclerView shouye_recy;
 Unbinder unbinder;
    private LoginPresenter loginPresenter;
    List<ShowBean.ProductItemBean> list = new ArrayList<>();
    private MyAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        //绑定P层
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getData();
        return view;
    }

    @Override
    public void succ(ShowBean showBean) {
        if (list==null){
            list=new ArrayList<>();
        }
        list.addAll(showBean.result.rxxp);//添加集合数据到当前集合内
        list.addAll(showBean.result.mlss);
        list.addAll(showBean.result.pzsh);
        myAdapter = new MyAdapter(getActivity(),list);
        shouye_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        shouye_recy.setAdapter(myAdapter);

    }

    @Override
    public void fail() {

    }
}

