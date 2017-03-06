package com.example.andras.moviedbdemo.modules.movies.detail.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.databinding.ActivityMovieDetailsBinding;
import com.example.andras.moviedbdemo.logic.data.Movie;

/**
 * Created by Andras Nemeth on 2017. 03. 06..
 */

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MODEL = "extraModel";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        binding.setMovie((Movie) getIntent().getSerializableExtra(EXTRA_MODEL));
    }
}
