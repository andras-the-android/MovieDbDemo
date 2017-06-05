package com.example.andras.moviedbdemo.ui.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.example.andras.moviedbdemo.data.MainListItemDto;
import com.example.andras.moviedbdemo.ui.detail.MovieDetailActivity;

public class Navigator {

    private static final String TAG = "Navigator";

    private Context context;

    public Navigator(Context context) {
        this.context = context;
    }

    public void goToDetailsScreen(MainListItemDto mainListItem, Bundle bundle) {
        Intent i = new Intent(context, MovieDetailActivity.class);
        i.putExtra(MovieDetailActivity.EXTRA_MODEL, mainListItem);
        ContextCompat.startActivity(context, i, bundle);
    }
}
