package com.example.cw.lowbee.fragments.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabSearchBinding;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by hzy on 2017/5/20.
 */

public class SearchFragment extends BaseFragment {
    FragmentTabSearchBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_tab_search, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);
    }
}
