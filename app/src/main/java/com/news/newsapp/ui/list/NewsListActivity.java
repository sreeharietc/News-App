package com.news.newsapp.ui.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.news.newsapp.R;
import com.news.newsapp.data.models.Article;
import com.news.newsapp.ui.detail.NewsDetailActivity;
import com.news.newsapp.utilities.InjectorUtils;

import java.util.List;

/**
 * Class that takes news list from network and display in recyclerview.
 * Progress dialog shows network operation.
 * Refresh button in menu to get news on demand.
 */

public class NewsListActivity extends AppCompatActivity {

    public static final String NEWS_ARTICLE = "news_article";
    RecyclerView newsListView;
    NewsListViewModel newsListViewModel;
    NewsListAdapter newsListAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_circular);
        setupNewsListView();
        NewsListViewModelFactory factory = InjectorUtils.provideMainActivityViewModelFactory(this.getApplicationContext());
        newsListViewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel.class);
        newsListViewModel.getNews().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                //Once LiveData gets updated, progressbar is set to invisible and list view adapter is updated.
                progressBar.setVisibility(View.GONE);
                newsListAdapter.updateNewsList(articles);
            }
        });
    }


    /**
     * Set adapter for recyclerview and define click listener for news list item.
     */
    private void setupNewsListView() {
        NewsListAdapter.NewsAdapterOnItemClickHandler adapterOnItemClickHandler = new NewsListAdapter.NewsAdapterOnItemClickHandler() {
            @Override
            public void onItemClick(Article article) {
                Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
                intent.putExtra(NEWS_ARTICLE, article);
                startActivity(intent);
            }
        };

        newsListView = findViewById(R.id.news_list_view);
        newsListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        newsListAdapter = new NewsListAdapter(this, adapterOnItemClickHandler);
        newsListView.setAdapter(newsListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // When refresh button is clicked, news is again fetched from repository and progress bar is set to visible.
        if (item.getItemId() == R.id.menu_item_refresh) {
            newsListViewModel.fetchNewsFromRepository();
            progressBar.setVisibility(View.VISIBLE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
