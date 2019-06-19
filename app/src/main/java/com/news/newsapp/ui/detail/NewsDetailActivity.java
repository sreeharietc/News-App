package com.news.newsapp.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.newsapp.R;
import com.news.newsapp.data.models.Article;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import static com.news.newsapp.ui.list.NewsListActivity.NEWS_ARTICLE;

/**
 * Displays news in detail with description and image.
 * All needed data is stored in {@link NewsDetailViewModel}
 */
public class NewsDetailActivity extends AppCompatActivity {
    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        NewsDetailViewModelFactory factory = new NewsDetailViewModelFactory((Article) getIntent().getParcelableExtra(NEWS_ARTICLE));
        NewsDetailViewModel newsDetailViewModel = ViewModelProviders.of(this, factory).get(NewsDetailViewModel.class);
        article = newsDetailViewModel.getArticle();
        //Set the actionbar title and back button.
        Objects.requireNonNull(getSupportActionBar()).setTitle(getResources().getString(R.string.news_detail));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setupView();
    }

    /**
     * Populate the layout with values from {@link article}
     */
    private void setupView() {
        TextView newsTitle = findViewById(R.id.tv_news_title);
        TextView newsDescription = findViewById(R.id.tv_news_description);
        ImageView newsImage = findViewById(R.id.news_image);

        newsTitle.setText(article.getTitle());
        newsDescription.setText(article.getDescription());
        Picasso.get().load(article.getUrlToImage()).placeholder(R.drawable.ic_launcher_foreground).into(newsImage);
    }
}
