package com.sequenia.services;

import com.sequenia.model.response.MovieListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {
    @GET("films.json")
    Call<MovieListResponse> getMovies();
}
