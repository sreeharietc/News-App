package com.news.newsapp.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.news.newsapp.data.Article;
import com.news.newsapp.data.NewsRepository;

import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsListViewModel extends ViewModel {
    private LiveData<List<Article>> newsArticles;
    private NewsRepository newsRepository;

    NewsListViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        fetchNewsFromRepository();
    }

    public LiveData<List<Article>> getNews() {
        return newsArticles;
    }

    public void fetchNewsFromRepository() {
        newsArticles = this.newsRepository.getNewsArticles();
    }
}
