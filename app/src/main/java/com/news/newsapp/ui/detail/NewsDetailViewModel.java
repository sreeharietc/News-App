package com.news.newsapp.ui.detail;

import android.arch.lifecycle.ViewModel;

import com.news.newsapp.data.Article;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsDetailViewModel extends ViewModel {
    Article article;

    public NewsDetailViewModel(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
