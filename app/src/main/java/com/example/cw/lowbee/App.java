package com.example.cw.lowbee;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by cw on 2017/5/18.
 */

public class App extends Application {
    public static App INSTANCE;
    public static App getInstance(){
        return INSTANCE;
    }

    public static boolean IsRelease = false;	//是否对外发布版本
    public static boolean IsTestVersion = true;	//是否测试服务器

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Fresco.initialize(this);

        //初始化变量
        initVal();
    }

    private void initVal() {
        IsTestVersion = getResources().getString(R.string.istestversion).equals("true");
        IsRelease = getResources().getString(R.string.isrelease).equals("true");
    }


}
