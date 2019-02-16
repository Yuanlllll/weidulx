package com.example.weidu.xiang.model;


import com.example.weidu.app.Myapp;
import com.example.weidu.bean.XiangBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XiangModel implements Imodel {
    @Override
    public void getMdata(final ListCallBack listCallBack) {
        Myapp.userApiService.xq("commodityId").enqueue(new Callback<XiangBean>() {
            @Override
            public void onResponse(Call<XiangBean> call, Response<XiangBean> response) {
                XiangBean xiangBean = response.body();
                listCallBack.getSuccess(xiangBean);
            }


            @Override
            public void onFailure(Call<XiangBean> call, Throwable t) {

            }
        });

    }
}
