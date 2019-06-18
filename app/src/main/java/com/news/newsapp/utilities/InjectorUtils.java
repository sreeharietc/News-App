package com.news.newsapp.utilities;

import android.content.Context;

import com.news.newsapp.data.NewsRepository;
import com.news.newsapp.data.network.NewsNetworkDataSource;
import com.news.newsapp.ui.list.NewsListViewModelFactory;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class InjectorUtils {
    public static NewsListViewModelFactory provideMainActivityViewModelFactory(Context context) {
        NewsRepository repository = provideRepository();
        return new NewsListViewModelFactory(repository);
    }

    private static NewsRepository provideRepository() {
        NewsNetworkDataSource networkDataSource =
                NewsNetworkDataSource.getInstance();
        return NewsRepository.getInstance(networkDataSource);
    }
}
