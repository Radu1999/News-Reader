package com.radu.data.features.news.remote;

import com.radu.data.features.news.models.Article;
import com.radu.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.radu.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    private static final String API_KEY = "3b9e4aee5f9644de842a13481c508023";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(@NonNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new NewsDtoToNewsMapper());
    }
}
