package com.vinay.sampledemo.repository;

import android.os.Build;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.vinay.sampledemo.BuildConfig;
import com.vinay.sampledemo.data.ArticleResponse;
import com.vinay.sampledemo.network.ApiInterface;
import com.vinay.sampledemo.network.RetrofitSingelton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepo {

    private static final String TAG = "ArticleRepo";
    private MutableLiveData<ArticleResponse> mutableLiveData;
    private ApiInterface apiInterface;

    public ArticleRepo() {
        apiInterface = RetrofitSingelton.getInstance().create(ApiInterface.class);
    }

    public LiveData<ArticleResponse> getMoviesArticle(){
        mutableLiveData = new MutableLiveData<>();
        apiInterface.getMoviesresponse(BuildConfig.ARTICLE_QUERY,BuildConfig.API_KEY)
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        Log.e(TAG,response.body().toString());
                        Log.e(TAG,""+response.body().getArticles().size());
                        Log.e(TAG,""+response.body().getStatus());
                        if(response.body()!=null){
                            mutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        mutableLiveData.setValue(null);
                    }
                });

        return mutableLiveData;
    }
}
