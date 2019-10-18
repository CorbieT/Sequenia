package com.sequenia.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResponse {
    @SerializedName("films")
    @Expose
    private List<MovieResponse> movies;

    public List<MovieResponse> getMovies() {
        return movies;
    }
}
