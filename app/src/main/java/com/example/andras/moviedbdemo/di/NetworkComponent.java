package com.example.andras.moviedbdemo.di;


import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public interface NetworkComponent {

    TheMovieDbApiBuilder theMovieDbApiBuilder();

    final class Get {
        private Get(){}

        static NetworkComponent component;

        public static NetworkComponent component() {
            if (component == null) {
                component = DaggerNetworkComponent.builder()
                        .networkModule(new NetworkModule())
                        .build();
            }
            return component;
        }

    }


}
