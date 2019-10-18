package com.sequenia.di.modules;

import android.app.Activity;

import com.sequenia.di.modules.fragments.FragmentsModule;
import com.sequenia.interfaces.FragmentHandler;
import com.sequenia.ui.activities.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    public abstract MainActivity mainActivity();

    @Binds
    @Reusable
    public abstract FragmentHandler bindFragmentHandler(MainActivity activity);

    @Binds
    @Reusable
    public abstract Activity bindActivity(MainActivity appActivity);

}
