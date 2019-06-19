package com.news.newsapp.data;

import android.arch.lifecycle.LiveData;

import com.news.newsapp.data.models.Article;
import com.news.newsapp.data.network.NewsNetworkDataSource;

import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 *
 * Handles data operations in NewsApp. Acts as a mediator between {@link NewsNetworkDataSource}
 * and {@link com.news.newsapp.ui.list.NewsListViewModel}
 */
public class NewsRepository {
    private NewsNetworkDataSource newsNetworkDataSource;
    private static NewsRepository sInstance;

    private NewsRepository(NewsNetworkDataSource newsNetworkDataSource) {
        this.newsNetworkDataSource = newsNetworkDataSource;
    }

    /**
     * Get the singleton for this class
     */
    public static NewsRepository getInstance(NewsNetworkDataSource networkDataSource) {
        if(sInstance == null) {
            sInstance = new NewsRepository(networkDataSource);
        }
        return sInstance;
    }

    /**
     *
     * @return news articles from network class.
     */
    public LiveData<List<Article>> getNewsArticles() {
        return newsNetworkDataSource.getNewsArticles();
    }
}
