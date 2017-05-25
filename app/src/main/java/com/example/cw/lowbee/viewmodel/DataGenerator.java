package com.example.cw.lowbee.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.TabContentBinding;
import com.example.cw.lowbee.fragments.home.HomeFragment;
import com.example.cw.lowbee.fragments.mine.MineFragment;
import com.example.cw.lowbee.fragments.news.NewsFragment;
import com.example.cw.lowbee.fragments.search.SearchFragment;

/**
 * Created by cw on 2017/5/19.
 */

public class DataGenerator {
    public static final int []mTabRes = new int[]{R.drawable.tab_home,R.drawable.tab_search,R.drawable.tab_news,R.drawable.tab_mine};
    public static final int []mTabResPressed = new int[]{R.drawable.tab_home_c,R.drawable.tab_search_c,R.drawable.tab_news_c,R.drawable.tab_mine_c};
    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = new HomeFragment();
        fragments[1] = new SearchFragment();
        fragments[2] = new NewsFragment();
        fragments[3] = new MineFragment();
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        TabContentBinding binding = DataBindingUtil.bind(LayoutInflater.from(context).inflate(R.layout.tab_content,null));
        binding.tabContentImage.setImageResource(DataGenerator.mTabRes[position]);
        return binding.getRoot();
    }

}
