package com.example.andras.moviedbdemo.ui.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.databinding.ActivityMovieDetailsBinding;

/**
 * Created by Andras Nemeth on 2017. 03. 06..
 */

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MODEL = "extraModel";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        binding.setModel(new MovieDetailViewModel((Movie) getIntent().getSerializableExtra(EXTRA_MODEL)));
    }
}
