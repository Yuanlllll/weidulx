package com.example.weidu.login.model;

import com.example.weidu.bean.ShowBean;

public interface ILoginModel {
    void GetData( LoginCallBack loginCallBack);
    interface LoginCallBack{
        void succ(ShowBean oj);
    }
}
