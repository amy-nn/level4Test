package com.example.user.ui;

import android.Manifest;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.core.mvp.ui.ui.BaseActivity;
import com.example.imageloader.ImageLoader2;
import com.example.imageloader.settings.NormalImageSetting;
import com.example.net.log.LogTool;
import com.example.user.R;
import com.example.user.contract.UserContract;
import com.example.user.presenter.UserPresenter;

import entity.UserBean;

/**
 * 视图层V
 * 负责用户交互和结果展示
 */
public class UserActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {

    private Button commit;
    private EditText phoneNumber;
    private EditText password;
    private ImageView imageView;
    private UserPresenter presenter;
    private UserBean bean;

    @Override
    protected void createPresenter() {
        presenter = new UserPresenter(this);
    }

    @Override
    protected void initEvent() {
        commit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        /**
         * false状态就不会出现log
         */
//        LogTool.getInstance().setDebug(false);

        /**
         * 使用imageLoad类加载图片
         */
        ImageLoader2 imageLoader2 = ImageLoader2.create();
        imageLoader2.loadImage(this,
                new NormalImageSetting.Builder()
                .url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597469274512&di=43e5d0d0bcb3f286db2c9868b2297068&imgtype=0&src=http%3A%2F%2Ffile02.16sucai.com%2Fd%2Ffile%2F2014%2F0929%2F0befba7c8a1702dec85affb2ef4cd90b.jpg")
                .into(imageView).radius(0)
                .build());
    }

    @Override
    protected void initView() {
        commit = findViewById(R.id.btn_user_register);
        phoneNumber = findViewById(R.id.et_user_phoneNumber);
        password = findViewById(R.id.et_user_password);
        imageView = findViewById(R.id.img_user_showImage);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{Manifest.permission.INTERNET},100);
        }
    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.user_center_layout;
    }

    @Override
    public void onClick(View v) {

        /**
         * 判断是否点击了提交
         */
        if(v.getId() == R.id.btn_user_register){

//            bean = new UserBean();
//            bean.setPhoneNum(Integer.parseInt(phoneNumber.getText().toString()));
//            bean.setUserPassWord(password.getText().toString());
//            bean.setTime(System.currentTimeMillis()+"");
//            presenter.registerUser(bean);

            String name = phoneNumber.getText().toString();
            String passWord = password.getText().toString();

            LogTool.getInstance().d(name+"--"+passWord);
            presenter.registerUser2(name,passWord);
        }

    }

    @Override
    public void success() {
//        showMessage(bean.toString());
        Log.d("amy", "success: ");
    }

    @Override
    public void fail() {
//        showMessage("fail....");
        Log.d("amy", "fail: ");
    }
}
