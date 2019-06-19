package com.news.newsapp.utilities;

import android.content.Context;

import com.news.newsapp.data.NewsRepository;
import com.news.newsapp.data.network.NewsNetworkDataSource;
import com.news.newsapp.ui.list.NewsListViewModelFactory;

/**
 * Created by sreehari
 * on 18/6/19.
 *
 * Provides static methods to inject the various classes needed for NewsApp
 */
public class InjectorUtils {
    public static NewsListViewModelFactory provideMainActivityViewModelFactory(Context context) {
        NewsRepository repository = provideRepository(context);
        return new NewsListViewModelFactory(repository);
    }

    private static NewsRepository provideRepository(Context context) {
        NewsNetworkDataSource networkDataSource =
                NewsNetworkDataSource.getInstance(context);
        return NewsRepository.getInstance(networkDataSource);
    }
}
