package com.example.andras.moviedbdemo.ui.main.listitem;

import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andras.moviedbdemo.databinding.ListItemMovieBinding;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MainListItemViewModel> items = new ArrayList<>();
    private AppCompatActivity activity;

    public MovieAdapter(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void addItems(List<MainListItemViewModel> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemMovieBinding itemBinding = ListItemMovieBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding, activity);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindModel(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements MainListItemView {

        private final ListItemMovieBinding binding;
        private AppCompatActivity activity;

        ViewHolder(ListItemMovieBinding binding, AppCompatActivity activity) {
            super(binding.getRoot());
            this.binding = binding;
            this.activity = activity;
        }

        void bindModel(MainListItemViewModel movie) {
            binding.setModel(movie);
            movie.setView(this);
            ViewCompat.setTransitionName(binding.posterImageView, movie.getMovie().getTitle());
        }

        @Override
        public Bundle getTransitionBundle() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //ActivityOptionsCompat sometimes crashes
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        activity,
                        binding.posterImageView,
                        ViewCompat.getTransitionName(binding.posterImageView));
                return options.toBundle();
            }
            return new Bundle();
        }
    }

}
