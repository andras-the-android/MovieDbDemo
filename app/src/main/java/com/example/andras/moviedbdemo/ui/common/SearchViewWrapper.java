package com.example.andras.moviedbdemo.ui.common;

import android.app.Activity;
import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;


import com.annimon.stream.function.Consumer;
import com.example.andras.moviedbdemo.R;

import static android.content.Context.SEARCH_SERVICE;

public class SearchViewWrapper {

    private Consumer<String> callback;

    public SearchViewWrapper(Activity activity, Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_search);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(menuItem);
        SearchManager searchManager = (SearchManager) activity.getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callback.accept(newText);
                return true;
            }
        });
    }

    public void setCallback(Consumer<String> callback) {
        this.callback = callback;
    }

}
