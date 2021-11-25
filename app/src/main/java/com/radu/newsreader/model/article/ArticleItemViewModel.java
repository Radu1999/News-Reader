package com.radu.newsreader.model.article;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

public class ArticleItemViewModel extends ViewModel implements LifecycleObserver {
    // TODO: Implement the ViewModel
    public  String imageUrl;
    public  String title;
    public  String text;
    public  String content;

    public ArticleItemViewModel(String title, String text, String imageUrl, String content) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.content = content;
    }
}