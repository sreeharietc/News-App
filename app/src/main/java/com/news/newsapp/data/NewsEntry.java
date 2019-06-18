package com.news.newsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsEntry {
    @SerializedName("status")
    String status;

    @SerializedName("totalResults")
    String totalResults;

    @SerializedName("articles")
    Articles articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public Articles getArticles() {
        return articles;
    }
}
