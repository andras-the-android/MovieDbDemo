package com.example.andras.moviedbdemo.logic.di;

import android.content.Context;

import com.example.andras.moviedbdemo.presentation.common.MovieDbApplication;
import com.example.andras.moviedbdemo.presentation.common.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */
@Module
public class CommonModule {

    @Provides
    @Singleton
    Context provideContext() {
        return MovieDbApplication.instance;
    }

    @Provides
    @Singleton
    Navigator provideNavigator(Context context) {
        return new Navigator(context);
    }
}
