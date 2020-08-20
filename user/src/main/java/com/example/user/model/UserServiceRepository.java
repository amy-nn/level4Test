package com.example.user.model;

import com.example.user.contract.UserContract;
import entity.UserBean;
import entity.UserResultBean;
import io.reactivex.Observable;

/**
 * 仓库层：封装Model层逻辑
 */
public class UserServiceRepository extends UserContract.UserRepository {

    /**
     * 调用Model层实现
     * @param bean
     * @return
     */
    @Override
    public Observable<UserBean> userRegister(UserBean bean) {
        return model.userRegister(bean);
    }

    @Override
    public Observable<UserResultBean> userRegister2(String name, String password) {
        return model.userRegister2(name,password);
    }

    /**
     * 创建Model层对象
     */
    @Override
    public void createModel() {
        model = new UserService();
    }
}
