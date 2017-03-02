package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */
@Module(includes = NetworkModule.class)
public class TheMovieDbModule {

    @Provides
    @Singleton
    TheMovieDbInteractor provideTheMovieDbInteractor(TheMovieDbApi api) {
        return new TheMovieDbInteractor(api);
    }
}
