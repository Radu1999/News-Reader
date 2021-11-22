package com.radu.data.features.news;

import com.radu.data.NewsRepository;
import com.radu.data.features.news.local.ArticleLocalDataStore;
import com.radu.data.features.news.models.Article;
import com.radu.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;
    private final ArticleLocalDataStore localDataStore;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, ArticleLocalDataStore localDataStore) {
        this.remoteSource = remoteSource;
        this.localDataStore = localDataStore;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localDataStore::saveArticleList)
                .onErrorResumeNext(localDataStore.getArticleList());
    }



}