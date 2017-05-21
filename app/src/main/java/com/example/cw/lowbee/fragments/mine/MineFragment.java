package com.example.cw.lowbee.fragments.mine;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabMineBinding;
import com.example.cw.lowbee.databinding.FragmentTabSearchBinding;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by cw on 2017/5/20.
 */

public class MineFragment extends BaseFragment {
    private FragmentTabMineBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_tab_mine, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);
        Uri uri = Uri.parse("https://avatars0.githubusercontent.com/u/9972897?v=3");
        binding.mineHead.setImageURI(uri);
    }
}
