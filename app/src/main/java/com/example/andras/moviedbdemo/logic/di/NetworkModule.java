package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.logic.network.TheMovieDbApi;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApiBuilder;

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
    TheMovieDbApiBuilder provideTheMovieDbApiBuiler() {
        return new TheMovieDbApiBuilder();
    }


    @Provides
    @Singleton
    TheMovieDbApi provideTheMovieDbApi(TheMovieDbApiBuilder apiBuiler) {
        return apiBuiler.build();
    }
}
