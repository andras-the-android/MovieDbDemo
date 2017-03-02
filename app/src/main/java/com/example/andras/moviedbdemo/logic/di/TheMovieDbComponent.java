package com.example.andras.moviedbdemo.logic.di;

import com.example.andras.moviedbdemo.modules.movies.list.view.MovieList;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Andras_Nemeth on 2017. 03. 02..
 */

@Component(modules = TheMovieDbModule.class)
@Singleton
public interface TheMovieDbComponent {

    void inject(MovieList MovieList);

    final class Get {
        private Get(){}

        static TheMovieDbComponent component;

        public static TheMovieDbComponent component() {
            if (component == null) {
                component = DaggerTheMovieDbComponent.builder()
                        .theMovieDbModule(new TheMovieDbModule())
                        .networkModule(new NetworkModule())
                        .build();
            }
            return component;
        }

    }
}
