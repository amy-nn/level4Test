package com.example.core.mvp.ui;

/**
 * 仓库层：创建M层对象
 * @param <M> Model层对象
 */
public abstract class BaseRepository<M extends IModel>{

    protected M RMode;

    public BaseRepository(){
        createModel();
    }

    public abstract void createModel();

}
