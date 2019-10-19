package com.sequenia.repositories.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.services.NetworkServiceImpl;
import com.sequenia.model.response.MovieListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepositoryImpl implements NetworkRepository {

    @Override
    public void query(final MovieResponseCallback callback) {
        NetworkServiceImpl.getInstance().getJSONApi().getMovies().enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieListResponse> call, @NonNull Response<MovieListResponse> response) {
                if (!response.isSuccessful()) return;
                if (response.body() == null  || response.body().getMovies() == null) {
                    Log.d("debug", "response error");
                } else {
                    callback.onSuccess(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieListResponse> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }
}
