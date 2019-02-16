package com.example.weidu.app;

import android.app.Application;

import com.example.weidu.api.ApiService;
import com.example.weidu.api.UserApiService;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Myapp extends Application {
    public static UserApiService userApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //创建retrofit实例
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //实现接口
         userApiService = retrofit.create(UserApiService.class);
    }
}
