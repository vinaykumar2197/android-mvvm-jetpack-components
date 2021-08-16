package com.vinay.sampledemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vinay.sampledemo.broadcast.DynamicBroadcast;
import com.vinay.sampledemo.broadcast.interfaces.BroadcastInterface;
import com.vinay.sampledemo.data.Article;
import com.vinay.sampledemo.data.ArticleResponse;
import com.vinay.sampledemo.databinding.ActivityMainBinding;
import com.vinay.sampledemo.view.adapter.NewsArticleAdapter;
import com.vinay.sampledemo.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BroadcastInterface {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    NewsViewModel newsViewModel;
    private RecyclerView.LayoutManager layoutManager;
    private NewsArticleAdapter newsArticleAdapter;
    private ArrayList<Article> articleArrayList;
    private DynamicBroadcast dynamicBroadcast = new DynamicBroadcast(this);


    @Override
    protected void onStart() {
        super.onStart();
        registerBroadcast();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        setUpRecyclerview();
        getMoviesArticles();

    }

    private void setUpRecyclerview(){
        articleArrayList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(MainActivity.this);

        binding.recyclerViewArticle.setLayoutManager(layoutManager);

        binding.recyclerViewArticle.setHasFixedSize(true);

        newsArticleAdapter = new NewsArticleAdapter(MainActivity.this,articleArrayList);

        binding.recyclerViewArticle.setAdapter(newsArticleAdapter);

    }

    private void getMoviesArticles(){
        newsViewModel.getArticleResponseLiveData().observe(this, new Observer<ArticleResponse>() {
            @Override
            public void onChanged(ArticleResponse articleResponse) {
                if(articleResponse!=null){
                    binding.pbArticle.setVisibility(View.GONE);
                    List<Article> articleList = articleResponse.getArticles();
                    articleArrayList.clear();
                    articleArrayList.addAll(articleList);
                    newsArticleAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void registerBroadcast(){
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        registerReceiver(dynamicBroadcast,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(dynamicBroadcast);
    }


    @Override
    public void onDataRecieved(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}