package com.sequenia.di.modules;

import com.sequenia.ui.fragments.movie.list.MovieListPresenter;

import dagger.Module;
import dagger.Provides;

import static com.sequenia.ui.fragments.movie.list.MovieListContract.*;

@Module
public class MovieListModule {

    private View view;

    public MovieListModule(View view) {
        this.view = view;
    }

    @Provides
    public View provideView() {
        return view;
    }

    @Provides
    public Presenter providePresenter(View view) {
        return new MovieListPresenter(view);
    }
}
