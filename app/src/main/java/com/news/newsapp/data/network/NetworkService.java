package com.news.newsapp.data.network;

import com.news.newsapp.data.models.NewsEntry;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public interface NetworkService {

    @GET("/v2/top-headlines?country=in")
    Call<NewsEntry> getNews();
}
