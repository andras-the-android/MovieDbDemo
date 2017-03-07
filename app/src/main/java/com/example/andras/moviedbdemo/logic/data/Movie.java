package com.example.andras.moviedbdemo.logic.data;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.andras.moviedbdemo.logic.network.TheMovieDbApiBuiler;
import com.google.gson.annotations.SerializedName;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {


    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("adult")
    private boolean isAdult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDateText;

    @SerializedName("genre_ids")
    private List<Integer> genreIdList;

    private List<Genre> genres;

    @SerializedName("id")
    private int id;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private float averageVote;


    public Movie() {
    }


    public String getPosterPath() {
        return posterPath;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDateText() {
        return releaseDateText;
    }

    public List<Integer> getGenreIdList() {
        return genreIdList;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public float getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public float getAverageVote() {
        return averageVote;
    }

    public String getAverageVoteString() {
        return String.valueOf(averageVote);
    }

    public String getConcatenatedGenre() {
//        StringBuffer sb = new StringBuffer();
//        for (Genre genre : genres) {
//            if (sb.length() > 0) {
//                sb.append(", ");
//            }
//            sb.append(genre.getName());
//        }
//        return sb.toString();
        return "temp genre";
    }

    public String getReleaseYear() {
        return releaseDateText.substring(0, 4);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso picasso = new Picasso.Builder(view.getContext())
                .downloader(new OkHttp3Downloader(TheMovieDbApiBuiler.getOkHttpClient()))
                .build();

        picasso
                .load("https://api.themoviedb.org/3/" + imageUrl)
                .into(view);
    }
}

