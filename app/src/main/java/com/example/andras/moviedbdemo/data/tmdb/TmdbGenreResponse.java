package com.example.andras.moviedbdemo.data.tmdb;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TmdbGenreResponse implements Serializable {

    @SerializedName("genres")
    private List<TmdbGenre> genres;

    public List<TmdbGenre> getGenres() {
        return genres;
    }
}
