package com.news.newsapp.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.news.newsapp.data.network.NewsNetworkDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsRepository {
    private LiveData<List<Article>> articlesLiveData;
    private NewsNetworkDataSource newsNetworkDataSource;
    private static NewsRepository sInstance;

    private NewsRepository(NewsNetworkDataSource newsNetworkDataSource) {
        this.newsNetworkDataSource = newsNetworkDataSource;
    }

    public static NewsRepository getInstance(NewsNetworkDataSource networkDataSource) {
        if(sInstance == null) {
            sInstance = new NewsRepository(networkDataSource);
        }
        return sInstance;
    }

    public LiveData<List<Article>> getNewsArticles() {
        articlesLiveData = newsNetworkDataSource.getNewsArticles();
        return articlesLiveData;
    }
}
