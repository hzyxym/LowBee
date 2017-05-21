package com.example.cw.lowbee.fragments.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by hzy on 2017/5/20.
 */

public class NewsDynamicFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_tab_news_dynamic, container,false);
    }
}
