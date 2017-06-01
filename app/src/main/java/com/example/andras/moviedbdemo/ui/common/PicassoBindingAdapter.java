package com.example.andras.moviedbdemo.ui.common;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.andras.moviedbdemo.R;
import com.example.andras.moviedbdemo.di.NetworkComponent;
import com.example.andras.moviedbdemo.network.TheMovieDbApiBuilder;
import com.squareup.picasso.Picasso;

public final class PicassoBindingAdapter {

    private PicassoBindingAdapter() {
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        TheMovieDbApiBuilder apiBuilder = NetworkComponent.Get.component().theMovieDbApiBuilder();
        Picasso picasso = apiBuilder.getPicasso(view.getContext());
        picasso.load(apiBuilder.getBaseImageUrlForThumbnailSize() + imageUrl).placeholder(R.mipmap.ic_launcher).into(view);
    }
}
