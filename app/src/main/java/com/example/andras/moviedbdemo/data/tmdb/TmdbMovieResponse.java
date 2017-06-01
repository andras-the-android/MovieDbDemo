package com.example.andras.moviedbdemo.data.tmdb;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TmdbMovieResponse implements Serializable {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<TmdbMovie> movies;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public List<TmdbMovie> getMovies() {
        return movies;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

}

