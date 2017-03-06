package com.example.andras.moviedbdemo.modules.movies.list.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andras.moviedbdemo.databinding.ListItemMovieBinding;
import com.example.andras.moviedbdemo.logic.data.Movie;
import com.example.andras.moviedbdemo.modules.movies.detail.view.MovieDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andras_Nemeth on 2017. 03. 06..
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<Movie> items = new ArrayList<>();
    private Context context;

    public MovieListAdapter(Context context) {
        this.context = context;
    }

    public void addItems(List<Movie> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemMovieBinding itemBinding = ListItemMovieBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding, new OnClickHandler(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindModel(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemMovieBinding binding;
        private OnClickHandler handler;

        public ViewHolder(ListItemMovieBinding binding, OnClickHandler handler) {
            super(binding.getRoot());
            this.binding = binding;
            this.handler = handler;
        }

        void bindModel(Movie movie) {
            binding.setMovie(movie);
            binding.setHandler(handler);
        }
    }

    public static class OnClickHandler {

        private Context context;

        private OnClickHandler(Context context) {
            this.context = context;
        }

        public void goToDetailsScreen(Movie movie) {
            Intent i = new Intent(context, MovieDetailActivity.class);
            i.putExtra(MovieDetailActivity.EXTRA_MODEL, movie);
            context.startActivity(i);
        }


    }
}
