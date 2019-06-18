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

    @GET("/v2/top-headlines")
    Call<NewsEntry> getNews(@Query("country") String country, @Query("pageSize") int pageSize, @Query("page") int page);
}
