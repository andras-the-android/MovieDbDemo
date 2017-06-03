package com.example.andras.moviedbdemo.ui.main.content;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.andras.moviedbdemo.databinding.ViewMainContentBinding;
import com.example.andras.moviedbdemo.ui.main.listitem.MainAdapter;
import com.example.andras.moviedbdemo.ui.main.listitem.MainListItemViewModel;

import java.util.List;

@SuppressLint("ViewConstructor")
public class MainContentViewImpl extends FrameLayout implements MainContentView {

    private final ViewMainContentBinding binding;
    private final MainAdapter adapter;

    public MainContentViewImpl(@NonNull AppCompatActivity activity) {
        super(activity);
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        binding = ViewMainContentBinding.inflate(layoutInflater, this, true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new MainAdapter(activity);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void hideLoaderOverlay() {
        binding.loaderOverlay.setVisibility(GONE);
    }

    @Override
    public void setItems(List<MainListItemViewModel> items) {
        adapter.setItems(items);
    }
}
