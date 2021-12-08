package com.radu.newsreader.features.article.mapper;

import androidx.annotation.NonNull;

import com.radu.data.features.news.models.Article;
import com.radu.newsreader.features.article.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(@NonNull List<Article> articles) throws Exception {
        List<ArticleItemViewModel> avm = new ArrayList<>();
        for(Article art : articles) {
            avm.add(new ArticleItemViewModel(art.title, art.description, art.imageUrl, art.content));
        }
        return avm;
    }
}
