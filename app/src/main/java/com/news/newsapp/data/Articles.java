package com.news.newsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sreehari
 * on 18/6/19.
 */
class Articles {
    @SerializedName("source")
    Source source;

    @SerializedName("author")
    String author;

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;

    @SerializedName("url")
    String url;

    @SerializedName("urlToImage")
    String urlToImage;

    @SerializedName("publishedAt")
    String publishedAt;

    @SerializedName("content")
    String content;

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }
}
