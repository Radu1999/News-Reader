package com.radu.newsreader.model;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.radu.data.NewsRepository;
import com.radu.newsreader.DataProvider;
import com.radu.newsreader.model.newslist.NewsListFragmentViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListFragmentViewModel.class)) {
            NewsRepository repo = DataProvider.getRepoProvider().provideNewsRepository();
            return (T) new NewsListFragmentViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
