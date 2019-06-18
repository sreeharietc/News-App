package com.news.newsapp.data.network;

import com.news.newsapp.data.NewsEntry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public interface NetworkService {

    @GET("/v2/top-headlines?country=in&pageSize=20")
    Call<NewsEntry> getNews(@Query("page") int page);
}
