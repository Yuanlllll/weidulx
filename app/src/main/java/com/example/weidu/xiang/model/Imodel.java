package com.example.weidu.xiang.model;


import com.example.weidu.bean.XiangBean;

public interface Imodel
{
    void getMdata(ListCallBack listCallBack);
    interface ListCallBack
    {
        void getSuccess(XiangBean xiangBean);
        void getFailed();
    }
}
