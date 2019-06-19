package com.news.newsapp.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.newsapp.R;
import com.news.newsapp.data.Article;

import static com.news.newsapp.ui.list.NewsListActivity.NEWS_ARTICLE;

public class NewsDetailActivity extends AppCompatActivity {
    private NewsDetailViewModel newsDetailViewModel;
    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        NewsDetailViewModelFactory factory = new NewsDetailViewModelFactory((Article) getIntent().getParcelableExtra(NEWS_ARTICLE));
        newsDetailViewModel = ViewModelProviders.of(this, factory).get(NewsDetailViewModel.class);
        article = newsDetailViewModel.getArticle();
        setupView();
    }

    private void setupView() {
        TextView newsTitle = findViewById(R.id.tv_news_title);
        TextView newsDescription = findViewById(R.id.tv_news_description);
        ImageView newsImage = findViewById(R.id.news_image);

        newsTitle.setText(article.getTitle());
        newsDescription.setText(article.getDescription());
    }
}
