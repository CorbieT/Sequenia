package com.sequenia.di.modules.fragments;

import com.sequenia.ui.fragments.movie.list.MovieListContract;
import com.sequenia.ui.fragments.movie.list.MovieListFragment;
import com.sequenia.ui.fragments.movie.list.MovieListPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieListModule {
    @Binds
    public abstract MovieListContract.Presenter bindPresenter(MovieListPresenter presenter);

    @Binds
    public abstract MovieListContract.View bindView(MovieListFragment view);
}
