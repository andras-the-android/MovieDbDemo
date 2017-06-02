package com.example.andras.moviedbdemo.data.tmdb;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmdbTvShowResponse {

    @SerializedName("results")
    private List<TmdbTvShow> tvShows;

    public List<TmdbTvShow> getTvShows() {
        return tvShows;
    }
}
