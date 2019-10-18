package com.sequenia.di.components;

import com.App;
import com.sequenia.di.modules.ActivityModule;
import com.sequenia.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App daggerApplication);

        ApplicationComponent build();
    }

}
