package com.example.level4.login;

import com.example.level4.Result;

/**
 * P层（负责调用V层和仓库）
 */
public class APPLoginPresenter extends LoginConstract.LoginPresenter{

    /**
     * 实例化V层和M层
     *
     * @param view
     */
    public APPLoginPresenter(LoginConstract.LoginView view) {
        super(view);
    }

    @Override
    public void getData() {
        baseRepository.getData(weakView.get().getUrl(), new Result() {
            @Override
            public void success(String path) {
                weakView.get().setValue(path);
            }

            @Override
            public void fail(Throwable msg) {
                weakView.get().setValue(msg.getMessage());
            }
        });
    }

    @Override
    public void createModel() {
        super.baseRepository = new AppLoginRepository();
    }
}
