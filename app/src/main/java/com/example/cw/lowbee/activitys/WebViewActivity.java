package com.example.cw.lowbee.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.ActivityWebviewBinding;

/**
 * Created by cw on 2017/5/23.
 */

public class WebViewActivity extends BaseActivity{
    public static String URL = "url";
    public static String AUTHOR = "Author";
    private ActivityWebviewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onInitUI() {
        super.onInitUI();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        binding.setPresenter(new Presenter());

        WebSettings settings = binding.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        binding.webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

        });
    }

    @Override
    public void onInitData() {
        super.onInitData();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.containsKey(URL)){
                binding.webview.loadUrl(bundle.getString(URL));
            }
            if(bundle.containsKey(AUTHOR)){
                binding.setAuthor(bundle.getString(AUTHOR));
            }
        }
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
