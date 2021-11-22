package com.radu.newsreader.model.newslist;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.radu.data.NewsRepository;
import com.radu.newsreader.R;
import com.radu.newsreader.mapper.ArticleToVMListMapper;
import com.radu.newsreader.model.article.ArticleItemViewModel;
import com.radu.newsreader.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListFragmentViewModel extends AndroidViewModel implements LifecycleObserver {
    @NonNull
    private final ObservableList<ArticleItemViewModel> newsList = new ObservableArrayList();
    private final NewsRepository repo;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    private final static String LINK = "https://newsapi.org/";

    public NewsListFragmentViewModel(Application app, NewsRepository repo) {
        super(app);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }


    @NonNull
    public ObservableList<ArticleItemViewModel> getNewsList() {
        return newsList;
    }


    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refreshData() {
        isLoading.set(true);
        repo.getNewsArticles()
                .map(new ArticleToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        isLoading.set(false);
        resultText.set(getApplication().getString(R.string.results, articles.size()));
        newsList.clear();
        newsList.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }
}
