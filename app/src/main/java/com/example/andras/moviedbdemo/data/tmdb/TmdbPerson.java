package com.example.andras.moviedbdemo.data.tmdb;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmdbPerson {

    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("also_known_as")
    @Expose
    public List<String> alsoKnownAs = null;
    @SerializedName("biography")
    @Expose
    public String biography;
    @SerializedName("birthday")
    @Expose
    public String birthday;
    @SerializedName("deathday")
    @Expose
    public String deathday;
    @SerializedName("gender")
    @Expose
    public Integer gender;
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("imdb_id")
    @Expose
    public String imdbId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("place_of_birth")
    @Expose
    public String placeOfBirth;
    @SerializedName("popularity")
    @Expose
    public Float popularity;
    @SerializedName("profile_path")
    @Expose
    public String profilePath;

    public Boolean getAdult() {
        return adult;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public String getBiography() {
        return biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public Integer getGender() {
        return gender;
    }

    public String getHomepage() {
        return homepage;
    }

    public Integer getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getName() {
        return name;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public Float getPopularity() {
        return popularity;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
