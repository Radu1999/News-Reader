package com.radu.newsreader;

import android.app.Application;

import com.radu.data.di.RepoModule;

public class NewsApplication extends Application {
    private static RepoModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();
        repoModule = new RepoModule(this);
    }

    public static RepoModule getRepoProvider() {
        return repoModule;
    }
}
