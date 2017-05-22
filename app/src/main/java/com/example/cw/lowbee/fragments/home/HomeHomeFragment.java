package com.example.cw.lowbee.fragments.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabHomeHomeBinding;
import com.example.cw.lowbee.fragments.BaseFragment;
import com.example.cw.lowbee.http.methods.GankHttpMethods;
import com.example.cw.lowbee.model.Article;

import java.util.List;

import rx.Observer;
import rx.Subscriber;

import static com.example.cw.lowbee.R.id.swipeRefreshLayout;

/**
 * Created by cw on 2017/5/20.
 */

public class HomeHomeFragment extends BaseFragment {

    private FragmentTabHomeHomeBinding binding;

    private Subscriber<List<Article>> subscriber = new Subscriber<List<Article>>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Log.i("hzy",e.toString());
            binding.swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<Article> articles) {
            binding.swipeRefreshLayout.setRefreshing(false);
//            adapter.setImages(images);
            for (Article article : articles){
                Log.i("hzy","url:"+article.getUrl()+", describe:"+article.getDesc());
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_home_home, container,false);
        binding = DataBindingUtil.bind(view);
        binding.gridRv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getHttpData();
    }

    //进行网络请求
    private void getHttpData(){
        GankHttpMethods.getInstance().getGankAndroid(subscriber);
    }
}
