package com.radu.newsreader.model.article;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel implements LifecycleObserver {
    // TODO: Implement the ViewModel
    public String title;
    public String text;

    public ArticleItemViewModel(String title, String text) {
        this.title = title;
        this.text = text;
    }


}