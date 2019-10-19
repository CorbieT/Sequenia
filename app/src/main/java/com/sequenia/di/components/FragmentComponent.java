package com.sequenia.di.components;

import com.sequenia.di.modules.FragmentScope;
import com.sequenia.di.modules.MovieListModule;
import com.sequenia.ui.fragments.movie.info.MovieInfoContract;
import com.sequenia.ui.fragments.movie.info.MovieInfoFragment;
import com.sequenia.ui.fragments.movie.list.MovieListContract;
import com.sequenia.ui.fragments.movie.list.MovieListFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = {MovieListModule.class})
public interface FragmentComponent {
    void inject(MovieListFragment movieListFragment);

    MovieListContract.Presenter getMovieListPresenter();
}
