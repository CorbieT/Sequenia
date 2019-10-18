package com.sequenia.ui.fragments.movie.list;

import androidx.annotation.NonNull;

import com.sequenia.model.response.MovieResponse;
import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.repositories.network.NetworkRepository;
import com.sequenia.repositories.network.NetworkRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

public class MovieListPresenter implements MovieListContract.Presenter {

    MovieListContract.View view;
    private NetworkRepository networkRepository = new NetworkRepositoryImpl();

    @Inject
    public MovieListPresenter(MovieListContract.View view) {
        this.view = view;
    }

    //TODO create in other thread
    @Override
    public void loadMovies() {
        networkRepository.query(new MovieResponseCallback() {
            @Override
            public void onSuccess(List<MovieResponse> response) {
                view.updateData(response);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }

    @Override
    public void holderClick(MovieResponse movie) {
        view.openMovieInfoFragment(movie);
    }
}
