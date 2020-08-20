package com.example.user.presenter;

import com.example.net.BaseObserver;
import com.example.user.contract.UserContract;
import com.example.user.model.UserServiceRepository;

import java.util.Scanner;

import entity.UserBean;
import entity.UserResultBean;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * P层的实现类，连接M和V层
 */
public class UserPresenter extends UserContract.UserPresenter {
    /**
     * 实例化V层和M层
     *
     * @param view
     */
    public UserPresenter(UserContract.UserView view) {
        super(view);
    }

    /**
     * 调用R层对象实现注册逻辑，返回结果给V
     * @param bean
     */
    @Override
    public void registerUser(UserBean bean) {
        Observable<UserBean> observable = baseRepository.userRegister(bean);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {

                        if(userBean != null){
                            weakView.get().success();
                        }
                        else
                            weakView.get().fail();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void registerUser2(String name, String password) {
        //被观察者 订阅  被观察者
        Observable<UserResultBean> observable = baseRepository.userRegister2(name, password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<UserResultBean>() {
                    @Override
                    public void onNext(UserResultBean userResultBean) {
                        weakView.get().success();
                    }

                    @Override
                    public void onError(Throwable e) {
                        weakView.get().fail();
                    }
                });
    }

    /**
     * 初始化R仓库对象
     */
    @Override
    public void createModel() {
        baseRepository = new UserServiceRepository();
    }
}
