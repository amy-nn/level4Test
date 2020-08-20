package com.example.user.model;

import com.example.net.RetrofitFactory;
import com.example.user.model.api.UserAPIService;
import com.example.user.contract.UserContract;
import entity.UserBean;
import entity.UserResultBean;
import io.reactivex.Observable;

/**
 * Model层：真正实现数据处理的地方
 * 访问网络层，获得UserAPIService
 */
public class UserService implements UserContract.UserModel {

    private RetrofitFactory factory;

    @Override
    public Observable<UserBean> userRegister(UserBean bean) {

        factory = RetrofitFactory.getRetrofitFactoryInstance();
        UserAPIService apiInterface = factory.getApiInterface(UserAPIService.class);
        Observable<UserBean> observable = apiInterface.registerUser(bean);
        return observable;
    }

    @Override
    public Observable<UserResultBean> userRegister2(String name, String password) {
        factory = RetrofitFactory.getRetrofitFactoryInstance();
        UserAPIService apiService = factory.getApiInterface(UserAPIService.class);
        Observable<UserResultBean> observable = apiService.registerUser(name,password);
        return observable;
    }
}
