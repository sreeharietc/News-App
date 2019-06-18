package com.news.newsapp.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.news.newsapp.data.Article;
import com.news.newsapp.data.NewsEntry;

import java.util.ArrayList;
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
    private Context context;

    public NewsNetworkDataSource(Context context) {
        this.context = context;
        this.articles = new MutableLiveData<>();
    }

    public static NewsNetworkDataSource getInstance(Context context) {
        if(sInstance == null) {
            sInstance = new NewsNetworkDataSource(context);
        }
        return sInstance;
    }

    public LiveData<List<Article>> getNewsArticles() {
        getNewsUpdates();
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article());
        articles.postValue(articleList);
        return articles;
    }



    private void getNewsUpdates() {
        /*Create handle for the RetrofitInstance interface*/
        NetworkService service = RetrofitClientInstance.getRetrofitInstance().create(NetworkService.class);
        Call<NewsEntry> call = service.getNews("in", 20, 1);
        call.enqueue(new Callback<NewsEntry>() {
            @Override
            public void onResponse(@NonNull Call<NewsEntry> call, @NonNull Response<NewsEntry> response) {
                if (response.body() != null) {
                    articles.postValue(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsEntry> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
