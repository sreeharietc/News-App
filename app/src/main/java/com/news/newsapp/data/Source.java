package com.news.newsapp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sreehari
 * on 18/6/19.
 */
class Source {
    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
