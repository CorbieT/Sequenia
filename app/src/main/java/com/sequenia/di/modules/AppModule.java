package com.sequenia.di.modules;

import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import dagger.android.support.DaggerApplication;

@Module
public abstract class AppModule {

    @Binds
    @Reusable
    public abstract Context bindAppContext(DaggerApplication daggerApplication);

}