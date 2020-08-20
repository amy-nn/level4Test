package com.example.net;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 封装观察者基类
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public abstract void onNext(T t);

    @Override
    public abstract void onError(Throwable e);

    @Override
    public void onComplete() {

    }
}
