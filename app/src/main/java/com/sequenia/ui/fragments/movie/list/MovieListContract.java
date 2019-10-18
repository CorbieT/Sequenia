package com.sequenia.ui.fragments.movie.list;

import com.sequenia.model.response.MovieResponse;

import java.util.List;

public interface MovieListContract {
    interface View {
        void updateData(List<MovieResponse> response);
        void openMovieInfoFragment(MovieResponse movie);
    }

    interface Presenter {
        void holderClick(MovieResponse movie);
        void loadMovies();
    }
}
