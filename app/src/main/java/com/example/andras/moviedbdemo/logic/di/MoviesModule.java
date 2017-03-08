package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.logic.interactor.TheMovieDbInteractor;
import com.example.andras.moviedbdemo.logic.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.presentation.common.Navigator;
import com.example.andras.moviedbdemo.presentation.movies.list.model.MovieListModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */

@Module(includes = {TheMovieDbModule.class, CommonModule.class})
public class MoviesModule {

    @Provides
    @Singleton
    MovieListModel provideMovieListModel(TheMovieDbInteractor theMovieDbInteractor, Navigator navigator) {
        return new MovieListModel(theMovieDbInteractor, navigator);
    }
}