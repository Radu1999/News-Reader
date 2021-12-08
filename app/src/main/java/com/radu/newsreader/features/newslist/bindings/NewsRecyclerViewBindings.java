package com.radu.newsreader.features.newslist.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.radu.newsreader.features.newslist.adapter.NewsListAdapter;
import com.radu.newsreader.features.article.model.ArticleItemViewModel;

import java.util.List;

public class NewsRecyclerViewBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> tasks) {
        NewsListAdapter taskAdapter = (NewsListAdapter) recyclerView.getAdapter();

        if (taskAdapter == null) {
            taskAdapter = new NewsListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(taskAdapter);
        }
        taskAdapter.setItems(tasks);
    }
}
