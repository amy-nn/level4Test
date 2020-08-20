package com.example.user.contract;

import com.example.core.mvp.ui.BasePresenter;
import com.example.core.mvp.ui.BaseRepository;
import com.example.core.mvp.ui.IModel;
import com.example.core.mvp.ui.IView;

import entity.UserBean;
import entity.UserResultBean;
import io.reactivex.Observable;

/**
 * 用户契约接口
 * 主要负责：V M/R P 层逻辑
 */
public interface UserContract {

    /**
     * 负责逻辑的最终实现
     */
    public interface UserModel extends IModel{
        public Observable<UserBean> userRegister(UserBean bean);

        public Observable<UserResultBean> userRegister2(String name,String password);
    }

    /**
     * 负责对M层的包装，数据仓库层
     */
    public abstract class UserRepository extends BaseRepository<UserModel>{
        public abstract Observable<UserBean> userRegister(UserBean bean);
        public abstract Observable<UserResultBean> userRegister2(String name,String password);
    }

    /**
     * 视图层，负责界面显示结果
     */
    public interface UserView extends IView{
        public void success();
        public void  fail();
    }


    /**
     * P层
     * 调用M层的实现传递结果给V层
     */
    public abstract class UserPresenter extends BasePresenter<UserRepository,UserView>{


        /**
         * 实例化V层和M层
         *
         * @param view
         */
        public UserPresenter(UserView view) {
            super(view);
        }

        public abstract void registerUser(UserBean bean);

        public abstract void registerUser2(String name,String password);
    }
}
