package com.example.cw.lowbee.activitys;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.ActivityMainBinding;
import com.example.cw.lowbee.databinding.TabContentBinding;
import com.example.cw.lowbee.view.DataGenerator;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private Fragment[] mFragmensts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onInitUI() {
        super.onInitUI();
        getSupportActionBar().hide();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mFragmensts = DataGenerator.getFragments("Tab");
        binding.bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());

                for (int i=0;i<binding.bottomTabLayout.getTabCount();i++){
                    View view = binding.bottomTabLayout.getTabAt(i).getCustomView();
                    TabContentBinding binding = DataBindingUtil.bind(view);
                    if(i == tab.getPosition()){ // 选中状态
                        binding.tabContentImage.setImageResource(DataGenerator.mTabResPressed[i]);
                    }else{// 未选中状态
                        binding.tabContentImage.setImageResource(DataGenerator.mTabRes[i]);
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // 提供自定义的布局添加Tab
        for(int i=0;i<mFragmensts.length;i++){
            binding.bottomTabLayout.addTab(binding.bottomTabLayout.newTab().setCustomView(DataGenerator.getTabView(this,i)));
        }
    }

    private void onTabItemSelected(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = mFragmensts[0];
                break;
            case 1:
                fragment = mFragmensts[1];
                break;

            case 2:
                fragment = mFragmensts[2];
                break;
            case 3:
                fragment = mFragmensts[3];
                break;
        }
        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
