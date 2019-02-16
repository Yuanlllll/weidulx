package com.example.weidu.api;

import com.example.weidu.bean.HomeBean;
import com.example.weidu.bean.ShowBean;
import com.example.weidu.bean.XiangBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApiService {

    //首页
    @GET("small/commodity/v1/commodityList")
    Call<ShowBean> get();
    //详情
    @GET("small/commodity/v1/findCommodityDetailsById")
    Call<XiangBean> xq(@Query("commodityid")String xid);


}
