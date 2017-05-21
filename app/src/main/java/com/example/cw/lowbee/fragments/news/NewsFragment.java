package com.example.cw.lowbee.fragments.news;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabNewsBinding;
import com.example.cw.lowbee.fragments.BaseFragment;

/**
 * Created by hzy on 2017/5/20.
 */

public class NewsFragment extends BaseFragment {
    FragmentTabNewsBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_tab_news, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);

        binding.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new NewsNewFragment();
                    case 1:
                        return new NewsDynamicFragment();
                    default:
                        return new NewsNewFragment();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.title_newsNew);
                    case 1:
                        return getString(R.string.title_newsDynamic);
                    default:
                        return getString(R.string.title_newsNew);
                }
            }
        });
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}
