package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.logic.network.TheMovieDbApi;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApiBuiler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    TheMovieDbApi provideTheMovieDbApi() {
        return TheMovieDbApiBuiler.build();
    }
}
