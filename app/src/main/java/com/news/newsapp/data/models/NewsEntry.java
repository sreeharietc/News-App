package com.news.newsapp.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsEntry {
    @SerializedName("status")
    private
    String status;

    @SerializedName("totalResults")
    private
    String totalResults;

    @SerializedName("articles")
    private
    List<Article> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
