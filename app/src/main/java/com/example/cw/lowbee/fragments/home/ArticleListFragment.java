package com.example.cw.lowbee.fragments.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.activitys.WebViewActivity;
import com.example.cw.lowbee.databinding.FragmentTabHomeArticleBinding;
import com.example.cw.lowbee.fragments.BaseFragment;
import com.example.cw.lowbee.http.methods.GankHttpMethods;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.utils.ItemClickListener;
import com.example.cw.lowbee.view.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscriber;


/**
 * Created by cw on 2017/5/20.
 */

public class ArticleListFragment extends BaseFragment {
    public static final String ALL_ARTICLES = "All_Articles";
    public static final String ANDROID_ARTICLES = "Android_Articles";
    public static final String IOS_ARTICLES = "IOS_Articles";
    public static final String SEARCH_ARTICLES = "Search_Articles";

    private static final String LOWBEE = "LowBee";
    private static final String FRAGMENTNAME = "FragmentName";

    private FragmentTabHomeArticleBinding binding;
    private ArticleAdapter adapter = new ArticleAdapter();
    private String mFragmentName = ALL_ARTICLES;
    private List<Article> mData = new ArrayList<>();

    private Observer<List<Article>> observer = new Observer<List<Article>>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            binding.swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
            Log.e(LOWBEE,"Error Messge:"+e.toString());
        }

        @Override
        public void onNext(List<Article> articles) {
            binding.swipeRefreshLayout.setRefreshing(false);
            adapter.setArticles(articles);
            mData = articles;
        }
    };

    //带参数实例化Fragement
    public static ArticleListFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString(FRAGMENTNAME, name);
        ArticleListFragment fragment = new ArticleListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            mFragmentName = bundle.getString(FRAGMENTNAME).toString();
            Log.i(LOWBEE,"Fragment Name:" + mFragmentName);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tab_home_article, container,false);

        binding = DataBindingUtil.bind(view);
        binding.gridRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.gridRv.setAdapter(adapter);

        adapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //do some thing
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL,mData.get(position).getUrl());
                startActivity(intent);
            }
        });

        binding.swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(mFragmentName.equals(ALL_ARTICLES)){
                    getAllArticleHttpData();
                }else if(mFragmentName.equals(ANDROID_ARTICLES)){
                    getAnroidArticleHttpData();
                }else if(mFragmentName.equals(IOS_ARTICLES)){
                    getIOSArticleHttpData();
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mFragmentName.equals(ALL_ARTICLES)){
            getAllArticleHttpData();
        }else if(mFragmentName.equals(ANDROID_ARTICLES)){
            getAnroidArticleHttpData();
        }else if(mFragmentName.equals(IOS_ARTICLES)){
            getIOSArticleHttpData();
        }
    }

    //获取干货所有文章数据（500条）
    private void getAllArticleHttpData(){
        GankHttpMethods.getInstance().getGankAllArticle(observer);
    }

    //获取干货Android文章数据（100条）
    private void getAnroidArticleHttpData(){
        GankHttpMethods.getInstance().getGankAndroidArticle(observer);
    }

    //获取干货IOS文章数据（100条）
    private void getIOSArticleHttpData(){
        GankHttpMethods.getInstance().getGankIOSArticle(observer);

    }

}
