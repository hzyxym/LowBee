package com.example.cw.lowbee.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.ActivityWebviewBinding;

/**
 * Created by cw on 2017/5/23.
 */

public class WebViewActivity extends BaseActivity{
    public static String URL = "url";
    private ActivityWebviewBinding binding;
    private String mUrl = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        binding.setPresenter(new Presenter());

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.containsKey(URL)){
                mUrl = bundle.getString(URL);
            }
        }

        binding.webview.loadUrl(mUrl);

    }

    public class Presenter {
        public void onClickBack(View view){
            WebViewActivity.this.finish();
        }

        public void onClickHeart(View view){
            binding.setToggle(!binding.getToggle());
        }

    }
}
