package com.radu.newsreader.adapters.newslist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.radu.newsreader.databinding.ArticleItemBinding;
import com.radu.newsreader.model.article.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ArticleItemViewHolder> {

    private List<ArticleItemViewModel> articleList;

    public NewsListAdapter() {
        this.articleList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ArticleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ArticleItemViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleItemViewHolder holder, int position) {
        holder.binding.setViewModel(articleList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(@NonNull  List<ArticleItemViewModel> list) {
        articleList = list;
        notifyDataSetChanged();
    }

    public static class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;

        public ArticleItemViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
