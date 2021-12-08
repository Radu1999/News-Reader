package com.radu.data.features.news.local;

import com.radu.data.features.news.local.models.ArticleEntity;
import com.radu.data.features.news.models.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ArticleLocalDataStore {
    private final ArticleDao dao;

    public ArticleLocalDataStore(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticleList() {
        return dao.queryArticles().map(list -> list.stream()
                .map(ent -> new Article(ent.imageUrl, ent.title, ent.content, ent.description))
                .collect(Collectors.toList()));
    }

    public void saveArticleList(List<Article> list) {
        List<ArticleEntity> entities = new ArrayList<>();
        for (Article article : list) {
            entities.add(new ArticleEntity(article.imageUrl, article.title,
                    article.content, article.description));
        }
        dao.insertArticles(entities)
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
