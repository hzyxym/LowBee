package com.example.cw.lowbee.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.example.cw.lowbee.BR;
import com.example.cw.lowbee.R;
import com.example.cw.lowbee.model.Article;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by cw on 2017/5/25.
 */

public class ArticleViewModel {
    public final ObservableList<Article> Items = new ObservableArrayList<>();
    public final ItemBinding<Article> Item = ItemBinding.of(BR.article, R.layout.article_item);
}
