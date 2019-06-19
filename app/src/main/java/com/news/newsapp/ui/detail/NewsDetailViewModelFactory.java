package com.news.newsapp.ui.detail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.news.newsapp.data.Article;
import com.news.newsapp.data.NewsRepository;
import com.news.newsapp.ui.list.NewsListViewModel;

/**
 * Created by sreehari
 * on 18/6/19.
 */
/**
 * Factory method that allows us to create a ViewModel with a constructor that takes a
 * {@link Article}
 */
public class NewsDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory  {
    private final Article article;

    public NewsDetailViewModelFactory(Article article) {
        this.article = article;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new NewsDetailViewModel(article);
    }
}
