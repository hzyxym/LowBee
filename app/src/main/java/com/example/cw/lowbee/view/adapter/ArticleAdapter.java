package com.example.cw.lowbee.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.ArticleItemBinding;
import com.example.cw.lowbee.model.Article;

import java.util.List;

/**
 * Created by cw on 2017/5/22.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{
    private List<Article> articles;
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
//        holder.mBinding.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private ArticleItemBinding mBinding;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            mBinding.bind(itemView);
        }
    }
}
