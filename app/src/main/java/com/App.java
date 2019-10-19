package com;

import android.app.Application;
import android.content.Context;


import com.sequenia.di.components.AppComponent;
import com.sequenia.di.components.DaggerAppComponent;
import com.sequenia.di.modules.AppModule;
import com.sequenia.di.modules.ContextModule;

public class App extends Application {
    private AppComponent component;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .build();
    }

    public AppComponent component() {
        return component;
    }
}
