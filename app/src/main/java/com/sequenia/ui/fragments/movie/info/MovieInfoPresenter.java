package com.sequenia.ui.fragments.movie.info;

import android.os.Bundle;

import com.sequenia.model.response.MovieResponse;

import javax.inject.Inject;

import static com.sequenia.ui.fragments.movie.info.MovieInfoFragment.movieKey;

public class MovieInfoPresenter implements MovieInfoContract.Presenter {

    MovieInfoContract.View<MovieResponse> view;
    private MovieResponse movie;

    public MovieInfoPresenter(MovieInfoContract.View<MovieResponse> view) {
        this.view = view;
    }

    @Override
    public void loadBundle(Bundle bundle) {
        if (bundle != null) {
            movie = bundle.getParcelable(movieKey);
        }
        view.updatePageInfo(movie);
    }
}
