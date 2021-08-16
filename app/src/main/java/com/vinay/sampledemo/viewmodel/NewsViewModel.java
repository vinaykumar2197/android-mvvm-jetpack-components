package com.vinay.sampledemo.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.vinay.sampledemo.data.ArticleResponse;
import com.vinay.sampledemo.repository.ArticleRepo;

public class NewsViewModel extends AndroidViewModel {

    private ArticleRepo articleRepo;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public NewsViewModel(@NonNull Application application) {
        super(application);

        if(articleRepo==null) {
            articleRepo = new ArticleRepo();
        }
        this.articleResponseLiveData = articleRepo.getMoviesArticle();
    }

    public LiveData<ArticleResponse>  getArticleResponseLiveData(){
        return articleResponseLiveData;
    }

}
