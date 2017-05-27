package com.example.cw.lowbee.fragments.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.FragmentTabHomeArticleBinding;
import com.example.cw.lowbee.fragments.BaseFragment;
import com.example.cw.lowbee.http.methods.GankHttpMethods;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.viewmodel.ArticleViewModel;

import java.util.List;

import rx.Observer;


/**
 * Created by cw on 2017/5/20.
 */

public class ArticleListFragment extends BaseFragment {
    public static final String ALL_ARTICLES = "All_Articles";
    public static final String ANDROID_ARTICLES = "Android_Articles";
    public static final String IOS_ARTICLES = "IOS_Articles";

    private static final String LOWBEE = "LowBee";
    private static final String FRAGMENTNAME = "FragmentName";

    private FragmentTabHomeArticleBinding binding;
    private String mFragmentName = ALL_ARTICLES;
    private ArticleViewModel viewModel;

    private Observer<List<Article>> observer = new Observer<List<Article>>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
            Log.e(LOWBEE,"Error Messge:"+e.toString());
        }

        @Override
        public void onNext(List<Article> articles) {
            viewModel.setItems(articles);
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
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tab_home_article,container,false);
        viewModel = new ArticleViewModel();
        binding.setViewModel(viewModel);
        binding.setTitle(mFragmentName);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mFragmentName.equals(ALL_ARTICLES)){
            //获取干货所有文章数据（200条）
            GankHttpMethods.getInstance().getGankAllArticle(observer);
        }else if(mFragmentName.equals(ANDROID_ARTICLES)){
            //获取干货Android文章数据（100条）
            GankHttpMethods.getInstance().getGankAndroidArticle(observer);
        }else if(mFragmentName.equals(IOS_ARTICLES)){
            //获取干货IOS文章数据（100条）
            GankHttpMethods.getInstance().getGankIOSArticle(observer);
        }
    }
}
