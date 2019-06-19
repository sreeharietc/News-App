package com.news.newsapp.data.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sreehari
 * on 18/6/19.
 */
class Source {
    @SerializedName("id")
    private
    String id;

    @SerializedName("name")
    private
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
