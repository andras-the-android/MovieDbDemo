package com.example.andras.moviedbdemo.ui.detail;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.di.MoviesComponent;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.squareup.picasso.Picasso;

/**
 * Created by Andras_Nemeth on 2017. 03. 08..
 */

public class MovieDetailViewModel {

    private Movie movie;

    public MovieDetailViewModel(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getOverview() {
        return movie.getOverview();
    }

    public String getPosterPath() {
        return movie.getPosterPath();
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public String getAverageVote() {
        return String.valueOf(movie.getAverageVote());
    }

    public String getReleaseDate() {
        return String.valueOf(movie.getReleaseDateText());
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

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
//        TheMovieDbApiBuilder apiBuilder = MoviesComponent.Get.component().getTheMovieDbApiBuilder();
//        Picasso picasso = apiBuilder.getPicasso(view.getContext());
//        picasso.load(apiBuilder.getBaseImageUrlForOriginalSize() + imageUrl).centerCrop().into(view);
    }

}
