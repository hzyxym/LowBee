package com.example.cw.lowbee.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by cw on 2017/5/20.
 */

public class HomeHomeFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_tab_home_home, container,false);
        //改变了数据发解决冲突。
    }

}
