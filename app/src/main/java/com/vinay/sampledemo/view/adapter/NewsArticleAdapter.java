package com.vinay.sampledemo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.vinay.sampledemo.R;
import com.vinay.sampledemo.data.Article;
import com.vinay.sampledemo.databinding.RowNewsBinding;

import java.util.ArrayList;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleAdapter.ViewHolder> {

    private Context context;
    ArrayList<Article> articleArrayList;

    public NewsArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @Override
    public NewsArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowNewsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            Glide
                    .with(context)
                    .load(articleArrayList.get(position).getUrlToImage())
                    .centerCrop()
//                .placeholder(R.drawable.loading_spinner)
                    .into(holder.rowNewsBinding.ivCover);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        holder.rowNewsBinding.tvTitle.setText(articleArrayList.get(position).getTitle());
        holder.rowNewsBinding.tvDescription.setText(articleArrayList.get(position).getDescription());
        holder.rowNewsBinding.tvPublishedAt.setText(articleArrayList.get(position).getPublishedAt());


    }


    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        public  RowNewsBinding rowNewsBinding;

        public ViewHolder(com.vinay.sampledemo.databinding.RowNewsBinding binding) {
            super(binding.getRoot());
            this.rowNewsBinding = binding;
        }

    }
}
