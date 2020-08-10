package com.example.core.mvp.ui;

import java.lang.ref.WeakReference;

/**
 * Presenter层，需要M和V层对象，其中V设置为软引用
 *
 * @param <R> 数据仓库层对象
 * @param <V> V层对象
 */
public abstract class BasePresenter <R extends BaseRepository,V extends IView>{

    protected R baseRepository;
    protected WeakReference<V> weakView;

    /**
     * 实例化V层和M层
     * @param view
     */
    public BasePresenter(V view){
        weakView = new WeakReference<>(view);
        createModel();
    }

    /**
     * 创建M层对象
     */
    public abstract void createModel();



}
