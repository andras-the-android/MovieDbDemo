package com.example.andras.moviedbdemo.data.tmdb;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TmdbGenericResponse implements Serializable {

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
