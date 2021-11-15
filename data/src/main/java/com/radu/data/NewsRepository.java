package com.radu.data;

import androidx.annotation.NonNull;

import com.radu.data.models.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {
    @NonNull
    Single<List<Article>> getNewsArticles();

}
