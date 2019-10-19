package com.sequenia.di.modules.fragments;

import com.sequenia.model.response.MovieResponse;
import com.sequenia.ui.fragments.movie.info.MovieInfoContract;
import com.sequenia.ui.fragments.movie.info.MovieInfoFragment;
import com.sequenia.ui.fragments.movie.info.MovieInfoPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieInfoModule {

    @Binds
    public abstract MovieInfoContract.Presenter providePresenter(MovieInfoPresenter presenter);

    @Binds
    public abstract MovieInfoContract.View<MovieResponse> provideView(MovieInfoFragment view);
}
