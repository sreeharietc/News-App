package com.news.newsapp.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.news.newsapp.data.Article;
import com.news.newsapp.data.NewsEntry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsNetworkDataSource {

    private MutableLiveData<List<Article>> articles;
    private static NewsNetworkDataSource sInstance;

    private NewsNetworkDataSource() {
        getNewsUpdates();
    }

    public static NewsNetworkDataSource getInstance() {
        if(sInstance == null) {
            sInstance = new NewsNetworkDataSource();
        }
        return sInstance;
    }

    public LiveData<List<Article>> getNewsArticles() {
        return articles;
    }



    public void getNewsUpdates() {
        /*Create handle for the RetrofitInstance interface*/
        NetworkService service = RetrofitClientInstance.getRetrofitInstance().create(NetworkService.class);
        Call<NewsEntry> call = service.getNews();
        call.enqueue(new Callback<NewsEntry>() {
            @Override
            public void onResponse(Call<NewsEntry> call, Response<NewsEntry> response) {
                articles.postValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsEntry> call, Throwable t) {

            }
        });
    }

}
