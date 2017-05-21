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

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Fresco.initialize(this);

    }
}
