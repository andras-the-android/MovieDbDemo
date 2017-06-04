package com.example.andras.moviedbdemo.data.tmdb;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TmdbGenre implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


