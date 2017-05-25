package com.example.cw.lowbee.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.example.cw.lowbee.BR;
import com.example.cw.lowbee.R;
import com.example.cw.lowbee.model.Article;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by cw on 2017/5/25.
 */

public class ArticleViewModel {
    public final ObservableList<Article> items = new ObservableArrayList<>();
    public final ItemBinding<Article> itemView = ItemBinding.of(BR.article, R.layout.article_item);

    public ArticleViewModel(){
    }

    public void setItems(List<Article> items) {
        this.items.addAll(items);
    }
}
