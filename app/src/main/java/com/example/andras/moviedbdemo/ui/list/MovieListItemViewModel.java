package com.example.andras.moviedbdemo.ui.list;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.di.MoviesComponent;
import com.example.andras.moviedbdemo.di.NetworkComponent;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.example.andras.moviedbdemo.ui.common.Navigator;
import com.squareup.picasso.Picasso;

public class MovieListItemViewModel {

    private Movie movie;
    private Navigator navigator;

    MovieListItemViewModel(Movie movie, Navigator navigator) {
        this.movie = movie;
        this.navigator = navigator;
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

    public String getReleaseYear() {
        return movie.getReleaseDateText().substring(0, 4);
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
