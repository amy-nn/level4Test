package com.example.level4.login;

import com.example.core.mvp.ui.BasePresenter;
import com.example.core.mvp.ui.BaseRepository;
import com.example.core.mvp.ui.IModel;
import com.example.core.mvp.ui.IView;
import com.example.level4.Result;

/**
 * 契约类（主要用于设置功能实现时需要逻辑）
 * M层
 * V层
 * P层
 *
 */
public interface LoginConstract {

    /**
     * 要实现的逻辑（输入网址下载数据）
     * 使用接口回调获得数据
     */
    public interface LoginModel extends IModel{
        public void getData(String url, Result result);
    }

    /**
     * View视图层(传递数据接口）
     */
    public interface LoginView extends IView{
        public String getUrl();
        public void setValue(String value);
    }

    /**
     * 仓库（对Model层进行再次封装）
     */
    public abstract class LoginRepository extends BaseRepository<LoginModel>{
        public abstract void getData(String url, Result result);
    }

    /**
     * P层 （连接仓库和V层）
     * 编写方法调用V层和仓库
     *
     */
    public abstract class LoginPresenter extends BasePresenter<LoginRepository,LoginView>{

        /**
         * 实例化V层和M层
         *
         * @param view
         */
        public LoginPresenter(LoginView view) {
            super(view);
        }

        public abstract void getData();
    }


}
