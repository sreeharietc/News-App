package com.news.newsapp.ui.detail;

import android.arch.lifecycle.ViewModel;

import com.news.newsapp.data.models.Article;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsDetailViewModel extends ViewModel {
    private Article article;

    /**
     *
     * @param article is passed from {@link NewsDetailViewModelFactory}
     */
    NewsDetailViewModel(Article article) {
        this.article = article;
    }

    /**
     *
     * @return Reference to the news Article
     */
    public Article getArticle() {
        return article;
    }
}
