package com.example.andras.moviedbdemo.data.tmdb;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TmdbMovieResponse extends TmdbGenericResponse {

    @SerializedName("results")
    private List<TmdbMovie> movies;

    public List<TmdbMovie> getMovies() {
        return movies;
    }

}

