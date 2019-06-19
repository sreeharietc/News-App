package com.news.newsapp.ui.list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.news.newsapp.data.NewsRepository;

/**
 * Created by sreehari
 * on 18/6/19.
 * Factory method that allows us to create a ViewModel with a constructor that takes a
 * {@link NewsRepository}
 */
public class NewsListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final NewsRepository newsRepository;

    /**
     *
     * @param newsRepository Get the instance of news repository
     */
    public NewsListViewModelFactory(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new NewsListViewModel(newsRepository);
    }
}
