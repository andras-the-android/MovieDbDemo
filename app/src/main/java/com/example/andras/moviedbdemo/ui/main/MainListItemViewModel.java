package com.example.andras.moviedbdemo.ui.main;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.data.tmdb.TmdbMovie;
import com.example.andras.moviedbdemo.di.NetworkComponent;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.squareup.picasso.Picasso;

public class MainListItemViewModel {

    private Movie movie;
    private Navigator navigator;

    public MainListItemViewModel(Movie movie, Navigator navigator) {
        this.movie = movie;
        this.navigator = navigator;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getRatingText() {
        return String.valueOf(movie.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(movie.getReleaseYear());
    }

    public void goToDetailsPage(View view) {
        navigator.goToDetailsScreen(movie);
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        TheMovieDbApiBuilder apiBuilder = NetworkComponent.Get.component().theMovieDbApiBuilder();
        Picasso picasso = apiBuilder.getPicasso(view.getContext());
        picasso.load(apiBuilder.getBaseImageUrlForThumbnailSize() + imageUrl).into(view);
    }


}
