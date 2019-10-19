package com.sequenia.ui.fragments.movie.list;

import com.sequenia.model.response.MovieResponse;

import java.util.List;

public interface MovieListContract {
    interface View {
        void updateRecyclerData(List<MovieResponse> response);
        void openMovieInfoFragment(MovieResponse movie);
        void updateSpinnerData(List<String> data);
    }

    interface Presenter {
        void holderClick(MovieResponse movie);
        void loadMovies();
        void onChooseGengre(String gengre);
    }
}
