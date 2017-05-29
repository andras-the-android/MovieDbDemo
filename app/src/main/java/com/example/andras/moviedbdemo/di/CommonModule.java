package com.example.andras.moviedbdemo.di;

import android.app.Activity;
import android.content.Context;

import com.example.andras.moviedbdemo.ui.common.MovieDbApplication;
import com.example.andras.moviedbdemo.ui.common.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
class CommonModule {

    private Activity activity;

    CommonModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return MovieDbApplication.instance;
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator(activity);
    }
}
