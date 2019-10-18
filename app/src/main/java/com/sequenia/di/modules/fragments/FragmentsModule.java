package com.sequenia.di.modules.fragments;

import com.sequenia.ui.fragments.movie.info.MovieInfoFragment;
import com.sequenia.ui.fragments.movie.list.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = {MovieInfoModule.class})
    public abstract MovieInfoFragment movieInfoFragment();

    @ContributesAndroidInjector(modules = {MovieListModule.class})
    public abstract MovieListFragment movieListFragment();
}
