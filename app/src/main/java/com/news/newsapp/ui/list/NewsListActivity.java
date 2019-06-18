package com.news.newsapp.ui.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.news.newsapp.R;
import com.news.newsapp.data.Article;
import com.news.newsapp.utilities.InjectorUtils;

import java.util.List;

public class NewsListActivity extends AppCompatActivity {

    RecyclerView newsListView;
    NewsListViewModel newsListViewModel;
    NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNewsListView();
        NewsListViewModelFactory factory = InjectorUtils.provideMainActivityViewModelFactory(this.getApplicationContext());
        newsListViewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel.class);
        newsListViewModel.getNews().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                newsListAdapter.updateNewsList(articles);
            }
        });
    }

    private void setupNewsListView() {
        NewsListAdapter.NewsAdapterOnItemClickHandler adapterOnItemClickHandler = new NewsListAdapter.NewsAdapterOnItemClickHandler() {
            @Override
            public void onItemClick(Article article) {

            }
        };

        newsListView = findViewById(R.id.news_list_view);
        newsListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        newsListAdapter = new NewsListAdapter(this, adapterOnItemClickHandler);
        newsListView.setAdapter(newsListAdapter);
    }
}
