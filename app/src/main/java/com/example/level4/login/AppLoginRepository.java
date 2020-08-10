package com.example.level4.login;

import com.example.level4.Result;

/**
 * 实现逻辑的仓库层
 */
public class AppLoginRepository extends LoginConstract.LoginRepository{

    @Override
    public void getData(String url, Result result) {
        RMode.getData(url,result);
    }

    @Override
    public void createModel() {
        RMode = new APPLoginModel();
    }
}
