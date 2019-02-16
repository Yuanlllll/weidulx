package com.example.weidu.login.model;


import com.example.weidu.app.Myapp;
import com.example.weidu.bean.ShowBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements ILoginModel{


    @Override
    public void GetData(final LoginCallBack loginCallBack) {
        Myapp.userApiService.get().enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                ShowBean showBean=response.body();
                loginCallBack.succ(showBean);

            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

            }
        });
    }
}
