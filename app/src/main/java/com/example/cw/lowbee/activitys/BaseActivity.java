package com.example.cw.lowbee.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by cw on 2017/5/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitUI();
        onInitData();
        onReflashUI();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public String getStringById(int id){
        return this.getResources().getString(id);
    }

    public void onInitUI(){

    }

    public void onInitData(){

    }

    private void onReflashUI() {

    }
}
