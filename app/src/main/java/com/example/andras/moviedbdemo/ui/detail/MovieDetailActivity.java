package com.example.andras.moviedbdemo.ui.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.data.Movie;
import com.example.andras.moviedbdemo.databinding.ActivityMovieDetailsBinding;
import com.example.andras.moviedbdemo.di.NetworkComponent;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MODEL = "extraModel";
    private ActivityMovieDetailsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        postponeEnterTransition();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MODEL);
        binding.setModel(new MovieDetailViewModel(movie));
        ViewCompat.setTransitionName(binding.detailPosterImageView, movie.getTitle());
        setupToolbar();
        loadImage(movie);
    }

    private void loadImage(Movie movie) {
        TheMovieDbApiBuilder apiBuilder = NetworkComponent.Get.component().theMovieDbApiBuilder();
        Picasso picasso = apiBuilder.getPicasso(this);
        picasso.load(apiBuilder.getBaseImageUrlForOriginalSize() + movie.getImageUrl())
                .into(binding.detailPosterImageView, new Callback() {
            @Override
            public void onSuccess() {
                supportStartPostponedEnterTransition();
            }

            @Override
            public void onError() {
                supportStartPostponedEnterTransition();
            }
        });
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        binding.collapsingToolbar.setTitleEnabled(false);
        binding.collapsingToolbar.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimary));
        binding.collapsingToolbar.setStatusBarScrimColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        binding.collapsingToolbar.setScrimAnimationDuration(300L);
        binding.appBar.addOnOffsetChangedListener(this::onAppbarOffsetChanged);
    }

    private void onAppbarOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float textViewAlpha = -verticalOffset / calcFullToolbarScrollingOffset(appBarLayout);
        float actionViewAlpha = 1.0F - textViewAlpha;
        for (int i = 0; i < binding.toolbar.getChildCount(); i++){
            View currentView = binding.toolbar.getChildAt(i);
            if(currentView.getClass().equals(android.support.v7.widget.AppCompatTextView.class)){
                currentView.setAlpha(textViewAlpha);
            }
            if(currentView.getClass().equals(android.support.v7.widget.ActionMenuView.class)){
                currentView.setAlpha(actionViewAlpha);
                currentView.setVisibility(actionViewAlpha < 0.001 ? View.INVISIBLE : View.VISIBLE);
            }
        }
    }

    float calcFullToolbarScrollingOffset(AppBarLayout appBarLayout) {
        return (float)(appBarLayout.getHeight() - binding.toolbar.getHeight());
    }
}
