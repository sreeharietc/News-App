package com.news.newsapp.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.news.newsapp.R;
import com.news.newsapp.data.Article;

import java.util.List;

/**
 * Created by sreehari
 * on 18/6/19.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListAdapterViewHolder> {

    private Context context;
    private NewsAdapterOnItemClickHandler onItemClickHandler;
    private List<Article> articles;

    public NewsListAdapter(Context context, NewsAdapterOnItemClickHandler onItemClickHandler) {
        this.context = context;
        this.onItemClickHandler = onItemClickHandler;
    }

    @NonNull
    @Override
    public NewsListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_news_list_item, viewGroup, false);
        return new NewsListAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListAdapterViewHolder newsListAdapterViewHolder, int position) {
        newsListAdapterViewHolder.tvNewsTitle.setText(articles.get(position).getTitle());
    }

    public void updateNewsList(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(articles == null) {
            return 0;
        } else {
            return articles.size();
        }
    }

    public class NewsListAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvNewsTitle;
        public NewsListAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickHandler.onItemClick(articles.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface NewsAdapterOnItemClickHandler {
        void onItemClick(Article article);
    }
}
