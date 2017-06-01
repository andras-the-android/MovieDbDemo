package com.example.andras.moviedbdemo.ui.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.ui.detail.MovieDetailActivity;

public class Navigator {

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void goToDetailsScreen(Movie movie, Bundle bundle) {
        Intent i = new Intent(context, MovieDetailActivity.class);
        i.putExtra(MovieDetailActivity.EXTRA_MODEL, movie);
        context.startActivity(i, bundle);
    }
}
