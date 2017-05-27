package com.example.cw.lowbee.viewmodel;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cw.lowbee.BR;
import com.example.cw.lowbee.R;
import com.example.cw.lowbee.activitys.WebViewActivity;
import com.example.cw.lowbee.fragments.home.ArticleListFragment;
import com.example.cw.lowbee.http.methods.GankHttpMethods;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.adapter.RecyclerViewAdapter;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import rx.Observer;

/**
 * Created by cw on 2017/5/25.
 */

public class ArticleViewModel {
    public static final ObservableList<Article> items = new ObservableArrayList<>();
    public final ItemBinding<Article> itemView = ItemBinding.of(BR.article, R.layout.article_item);
    public final RecyclerViewAdapter<Article> adapter = new RecyclerViewAdapter<Article>(){
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position, List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //do some thing
                    Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                    intent.putExtra(WebViewActivity.URL,items.get(position).getUrl());
                    intent.putExtra(WebViewActivity.AUTHOR,items.get(position).getWho());
                    view.getContext().startActivity(intent);
                }
            });
        }
    };

    public void setItems(List<Article> items) {
        this.items.clear();
        this.items.addAll(items);
    }
    @BindingAdapter("refresh")
    public static void setSwipeRefreshLayoutProperty(final View view, final String str){
        ((SwipeRefreshLayout)view).setColorSchemeColors(Color.BLUE, Color.RED, Color.YELLOW);
        ((SwipeRefreshLayout)view).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpData(((SwipeRefreshLayout)view),str);
            }
        });

    }

    private static void getHttpData(final SwipeRefreshLayout view, String str) {
        Observer<List<Article>> observer = new Observer<List<Article>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                view.setRefreshing(false);
            }

            @Override
            public void onNext(List<Article> articles) {
                view.setRefreshing(false);
                items.clear();
                items.addAll(articles);
            }
        };

        if(str.equals(ArticleListFragment.ALL_ARTICLES)){
            GankHttpMethods.getInstance().getGankAllArticle(observer);
        }else if(str.equals(ArticleListFragment.ANDROID_ARTICLES)){
            GankHttpMethods.getInstance().getGankAndroidArticle(observer);
        }else if(str.equals(ArticleListFragment.IOS_ARTICLES)){
            GankHttpMethods.getInstance().getGankIOSArticle(observer);
        }
    }
}
