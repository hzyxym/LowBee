package com.example.cw.lowbee.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by cw on 2017/5/19.
 */

public class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);

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

    public void onInitUI(){

    }

    public void onInitData(){

    }

    private void onReflashUI() {

    }
}
