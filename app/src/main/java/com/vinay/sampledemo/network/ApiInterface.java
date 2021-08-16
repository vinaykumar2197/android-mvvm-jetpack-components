package com.vinay.sampledemo.network;

import com.vinay.sampledemo.data.ArticleResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v2/everything/")
    Call<ArticleResponse> getMoviesresponse(
            @Query("q") String query,
            @Query("apikey") String apiKey
    );
}
