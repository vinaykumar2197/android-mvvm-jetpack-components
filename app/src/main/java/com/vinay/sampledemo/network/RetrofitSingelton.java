package com.vinay.sampledemo.network;

import com.vinay.sampledemo.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingelton {
    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit==null) {
            synchronized (Retrofit.class) {
                if(retrofit ==null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BuildConfig.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

}
