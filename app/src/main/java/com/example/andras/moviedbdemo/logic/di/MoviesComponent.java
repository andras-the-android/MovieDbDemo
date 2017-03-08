package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.logic.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.presentation.movies.list.view.MovieListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */
@Component(modules = MoviesModule.class)
@Singleton
public interface MoviesComponent {

    void inject(MovieListActivity MovieListActivity);
    TheMovieDbApiBuilder getTheMovieDbApiBuilder();

    final class Get {
        private Get(){}

        static MoviesComponent component;

        public static MoviesComponent component() {
            if (component == null) {
                component = DaggerMoviesComponent.builder()
                        .theMovieDbModule(new TheMovieDbModule())
                        .networkModule(new NetworkModule())
                        .commonModule(new CommonModule())
                        .build();
            }
            return component;
        }

    }
}
