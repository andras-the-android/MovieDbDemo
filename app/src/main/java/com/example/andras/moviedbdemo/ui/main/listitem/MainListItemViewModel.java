package com.example.andras.moviedbdemo.ui.main.listitem;

import android.view.View;

import com.example.andras.moviedbdemo.data.MainListItem;
import com.example.andras.moviedbdemo.ui.common.Navigator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainListItemViewModel {

    private static NumberFormat ratingFormat;
    static {
        ratingFormat = new DecimalFormat("#.0");
        ratingFormat.setRoundingMode(RoundingMode.HALF_UP);
    }

    private MainListItem mainListItem;
    private Navigator navigator;
    private MainListItemView view;

    public MainListItemViewModel(MainListItem mainListItem, Navigator navigator) {
        this.mainListItem = mainListItem;
        this.navigator = navigator;
    }

    public MainListItem getDto() {
        return mainListItem;
    }

    public String getRatingText() {
        return ratingFormat.format(mainListItem.getRating());
    }

    public String getReleaseYearText() {
        return String.valueOf(mainListItem.getReleaseYear());
    }

    public void goToDetailsPage(View v) {
        navigator.goToDetailsScreen(mainListItem, this.view.getTransitionBundle());
    }

    public void setView(MainListItemView view) {
        this.view = view;
    }
}
