package com.sequenia.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceImpl {
    private static NetworkServiceImpl mInstance;
    private static final String BASE_URL = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask/";
    private Retrofit mRetrofit;

    private NetworkServiceImpl() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkServiceImpl getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkServiceImpl();
        }
        return mInstance;
    }

    public NetworkService getJSONApi() {
        return mRetrofit.create(NetworkService.class);
    }
}
