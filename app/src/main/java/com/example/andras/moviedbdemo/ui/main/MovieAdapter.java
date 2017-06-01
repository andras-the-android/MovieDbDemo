package com.example.andras.moviedbdemo.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andras.moviedbdemo.databinding.ListItemMovieBinding;

import java.util.ArrayList;
import java.util.List;


class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MainListItemViewModel> items = new ArrayList<>();

    void addItems(List<MainListItemViewModel> newItems) {
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemMovieBinding itemBinding = ListItemMovieBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
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

        ViewHolder(ListItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindModel(MainListItemViewModel movie) {
            binding.setModel(movie);
        }
    }

}
