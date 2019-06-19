package com.news.newsapp.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class Article implements Parcelable {
    @SerializedName("source")
    private
    Source source;

    @SerializedName("author")
    private
    String author;

    @SerializedName("title")
    private
    String title;

    @SerializedName("description")
    private
    String description;

    @SerializedName("url")
    private
    String url;

    @SerializedName("urlToImage")
    private
    String urlToImage;

    @SerializedName("publishedAt")
    private
    String publishedAt;

    @SerializedName("content")
    private
    String content;

    protected Article(Parcel in) {
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
        content = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(author);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(url);
        parcel.writeString(urlToImage);
        parcel.writeString(publishedAt);
        parcel.writeString(content);
    }
}
