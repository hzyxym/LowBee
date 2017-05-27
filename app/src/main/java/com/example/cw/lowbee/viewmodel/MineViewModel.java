package com.example.cw.lowbee.viewmodel;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by cw on 2017/5/27.
 */

public class MineViewModel {

    @BindingAdapter("setUrl")
    public static void setPropertyImage(View view, String url) {
        ((SimpleDraweeView)view).setImageURI(TextUtils.isEmpty(url) ? null : Uri.parse(url));
    }

}
