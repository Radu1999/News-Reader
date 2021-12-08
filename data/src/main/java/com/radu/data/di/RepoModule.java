package com.radu.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.radu.data.NewsRepository;
import com.radu.data.features.news.NewsRepositoryImpl;
import com.radu.data.features.news.local.ArticleLocalDataStore;
import com.radu.data.features.news.remote.NewsRemoteSource;
import com.radu.data.remote.HttpClientFactory;
import com.radu.data.store.local.ArticleDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;

    private volatile ArticleDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }
    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    private ArticleLocalDataStore provideLocalDataStore() {
        return new ArticleLocalDataStore(getInstance().toDoDao());
    }

    ArticleDatabase getInstance() {
        if (database == null) {
            synchronized (ArticleDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            ArticleDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
