package com.sequenia.di.components;

import android.app.Application;
import android.content.Context;

import com.App;
import com.sequenia.di.modules.AppModule;
import com.sequenia.di.modules.ContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ContextModule.class})
public interface AppComponent {
    void inject(App initApplication);
    Context getContext();
    Application getApplication();
}