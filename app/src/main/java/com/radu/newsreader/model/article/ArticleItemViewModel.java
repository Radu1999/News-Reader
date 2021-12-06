package com.radu.newsreader.model.article;

public class ArticleItemViewModel {

    public final String imageUrl;
    public final String title;
    public final String text;
    public final String content;

    public ArticleItemViewModel(String title, String text, String imageUrl, String content) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
        this.content = content;
    }
}