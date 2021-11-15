package com.radu.newsreader.model.newslist;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.radu.newsreader.model.article.ArticleItemViewModel;

public class NewsListFragmentViewModel extends ViewModel implements LifecycleObserver {
    @NonNull
    private final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();

    @NonNull
    public ObservableList<ArticleItemViewModel> getNewsList() {
        return newsList;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        newsList.add(new ArticleItemViewModel("oare", "merge?"));
    }
}
