package com.example.user.model.api;

import entity.UserBean;
import entity.UserResultBean;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 获取网络数据，编写网络接口
 */
public interface UserAPIService {

    @POST("/videouser/register")
    public Observable<UserBean> registerUser(@Body UserBean userBean);

    @FormUrlEncoded
    @POST("register")//("login")
    public Observable<UserResultBean> registerUser(@Field("name") String name,@Field("password") String password);
}
