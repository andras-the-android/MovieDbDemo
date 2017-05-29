package com.example.andras.moviedbdemo.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by false on 2017. 02. 28..
 */

public class GenresListResponse implements Serializable {
    @SerializedName("genres")

    List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }
}
