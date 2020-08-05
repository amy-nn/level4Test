package com.example.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.command.AroutPath;

@Route(path = AroutPath.home_path)
public class HomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
    }

    public void showHome(View view) {
        Toast.makeText(this, "Home Module", Toast.LENGTH_SHORT).show();
    }
}
