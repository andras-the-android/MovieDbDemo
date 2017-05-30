package com.example.andras.moviedbdemo.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.andras.moviedbdemo.databinding.ViewMainContentBinding;

@SuppressLint("ViewConstructor")
public class MainContentView extends FrameLayout {

    public MainContentView(@NonNull Context context, RecyclerView.Adapter adapter) {
        super(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        ViewMainContentBinding binding = ViewMainContentBinding.inflate(layoutInflater, this, true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(adapter);
    }

}
