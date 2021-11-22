package com.radu.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.radu.data.features.news.local.ArticleDao;
import com.radu.data.features.news.local.models.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao toDoDao();
}
