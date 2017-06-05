package com.example.andras.moviedbdemo.di;

import android.app.Activity;

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
    Navigator provideNavigator() {
        return new Navigator(activity);
    }
}
