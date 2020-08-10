package com.example.level4.login;

import android.Manifest;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.core.mvp.ui.ui.BaseActivity;
import com.example.level4.R;
import com.example.level4.Result;

/**
 * V层，负责界面显示（调用P层实现）
 */
public class APPLoginView extends BaseActivity<APPLoginPresenter>  implements LoginConstract.LoginView{

    private EditText editUrl;
    private Button commit;
    private final static String TAG = "amy";

    @Override
    public String getUrl() {
        return editUrl.getText().toString();
    }

    @Override
    public void setValue(String value) {
//        showMessage(value);
        Log.d(TAG, "setValue: "+value);
    }

    @Override
    protected void createPresenter() {
        presenter = new APPLoginPresenter(this);
    }

    @Override
    protected void initEvent() {
        commit.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        editUrl = findViewById(R.id.loginView_name);
        commit = findViewById(R.id.loginView_commit);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{Manifest.permission.INTERNET},100);
        }
    }

    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_loginwiew;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.loginView_commit){
            commit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.getData();
                }
            });
        }
    }
}
