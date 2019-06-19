package com.news.newsapp.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.news.newsapp.data.NewsRepository;
import com.news.newsapp.data.models.Article;

import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 * Holds the data for {@link NewsListActivity}.
 */
public class NewsListViewModel extends ViewModel {
    private LiveData<List<Article>> newsArticles;
    private NewsRepository newsRepository;

    /**
     * Get reference to news repository and intimate call to get news.
     * @param newsRepository reference to repository class which abstracts data fetch.
     */
    NewsListViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        fetchNewsFromRepository();
    }

    /**
     *
     * @return reference to LiveData newsArticles is returned
     */
    public LiveData<List<Article>> getNews() {
        return newsArticles;
    }

    /**
     * Get news from repository and updates the LiveData newsArticles
     */
    void fetchNewsFromRepository() {
        newsArticles = this.newsRepository.getNewsArticles();
    }
}
