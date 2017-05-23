package com.example.cw.lowbee.fragments.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabHomeBinding;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by cw on 2017/5/19.
 */

public class HomeFragment extends BaseFragment {

    private FragmentTabHomeBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_tab_home, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);

        binding.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return ArticleListFragment.newInstance(ArticleListFragment.ALL_ARTICLES);
                    case 1:
                        return ArticleListFragment.newInstance(ArticleListFragment.ANDROID_ARTICLES);
                    case 2:
                        return ArticleListFragment.newInstance(ArticleListFragment.IOS_ARTICLES);
                    default:
                        return ArticleListFragment.newInstance(ArticleListFragment.ALL_ARTICLES);
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.title_homeHome);
                    case 1:
                        return getString(R.string.title_homeAndroid);
                    case 2:
                        return getString(R.string.title_homeIOS);
                    default:
                        return getString(R.string.title_homeHome);
                }
            }
        });
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }


}
