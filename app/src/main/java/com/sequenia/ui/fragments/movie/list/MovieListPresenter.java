package com.sequenia.ui.fragments.movie.list;

import android.util.Log;

import androidx.annotation.NonNull;

import com.sequenia.model.response.MovieResponse;
import com.sequenia.model.response.MovieResponseCallback;
import com.sequenia.repositories.network.NetworkRepository;
import com.sequenia.repositories.network.NetworkRepositoryImpl;
import com.sequenia.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View view;
    private NetworkRepository networkRepository = new NetworkRepositoryImpl();
    private List<MovieResponse> movies;

    public MovieListPresenter(MovieListContract.View view) {
        this.view = view;
    }

    //TODO create in other thread
    @Override
    public void loadMovies() {
        networkRepository.query(new MovieResponseCallback() {
            @Override
            public void onSuccess(List<MovieResponse> response) {
                movies = response;
                view.updateSpinnerData(makeGenresList(response));
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }

    @Override
    public void onChooseGengre(String gengre) {
        if (gengre.equalsIgnoreCase("Все")) {
            view.updateRecyclerData(movies);
            return;
        }
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (MovieResponse movie : movies) {
            if (movie.getGenres().contains(gengre.toLowerCase())) {
                movieResponses.add(movie);
            }
        }
        view.updateRecyclerData(movieResponses);
    }

    private List<String> makeGenresList(List<MovieResponse> movieResponseList) {
        List<String> gengres = new ArrayList<>();
        for (MovieResponse movie : movieResponseList) {
            gengres.addAll(movie.getGenres());
        }
        gengres.add(0, "Все");

        return ListUtils.makeFirsLetterUppercase(ListUtils.removeAllEquals(gengres));
    }

    @Override
    public void holderClick(MovieResponse movie) {
        view.openMovieInfoFragment(movie);
    }
}
