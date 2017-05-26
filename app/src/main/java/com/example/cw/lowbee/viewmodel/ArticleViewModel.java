package com.example.cw.lowbee.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.cw.lowbee.BR;
import com.example.cw.lowbee.R;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.viewmodel.adapter.RecyclerViewAdapter;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingListViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by cw on 2017/5/25.
 */

public class ArticleViewModel {
    public final ObservableList<Article> items = new ObservableArrayList<>();
    public final ItemBinding<Article> itemView = ItemBinding.of(BR.article, R.layout.article_item);
    public final RecyclerViewAdapter<Article> adapter = new RecyclerViewAdapter<>();


    public ArticleViewModel(){
    }

    public final BindingListViewAdapter.ItemIds<Article> itemId = new BindingListViewAdapter.ItemIds<Article>() {
        @Override
        public long getItemId(int position, Article item) {
            Log.i("hzy","position:"+position);
            return position;
        }
    };

    public final BindingRecyclerViewAdapter.ViewHolderFactory viewHolder = new BindingRecyclerViewAdapter.ViewHolderFactory() {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewDataBinding binding) {
            return new ArticleViewHolder(binding.getRoot());
        }



    };

    private static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ArticleViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("hzy","Hooder");
                }
            });

        }
    }

    public void setItems(List<Article> items) {
        this.items.addAll(items);
    }
}
