package com.example.andras.moviedbdemo.data.tmdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmdbPersonResponse extends TmdbGenericResponse {

    @SerializedName("results")
    private List<TmdbPerson> people;

    public List<TmdbPerson> getPeople() {
        return people;
    }
}
