package com.example.andras.moviedbdemo.ui.common;

import android.content.Context;
import android.content.Intent;

import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.ui.detail.MovieDetailActivity;

/**
 * Created by Andras_Nemeth on 2017. 03. 07..
 */

public class Navigator {

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void goToDetailsScreen(Movie movie) {
        Intent i = new Intent(context, MovieDetailActivity.class);
        i.putExtra(MovieDetailActivity.EXTRA_MODEL, movie);
        context.startActivity(i);
    }
}
