package com.example.cw.lowbee.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cw.lowbee.R;
import com.example.cw.lowbee.databinding.ArticleItemBinding;
import com.example.cw.lowbee.model.Article;
import com.example.cw.lowbee.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cw on 2017/5/22.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{
    private List<Article> articles = new ArrayList<>();
    private ItemClickListener mListener;
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        holder.bind(articles.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(ItemClickListener listener){
        this.mListener = listener;
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private ArticleItemBinding mBinding;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
        public void bind(@NonNull Article article) {
            mBinding.setArticle(article);
        }
    }
}
