package com.example.core.mvp.ui.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.core.mvp.ui.BasePresenter;
import com.example.core.mvp.ui.IView;

/**
 * BaseActivity
 * @param <P> P层对象
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView, View.OnClickListener {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayoutId());

        createPresenter();
        initView();
        initData();
        initEvent();
    }

    protected abstract void createPresenter();

    protected abstract void initEvent();

    protected abstract void initData();

    protected abstract void initView();

    @LayoutRes
    protected abstract int getViewLayoutId();

    @Override
    public abstract void onClick(View v);

    protected void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
