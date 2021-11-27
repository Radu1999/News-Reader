package com.radu.newsreader.bindings;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.radu.newsreader.R;

public class ImageBinding {

    @BindingAdapter({"imageUrl"})
    public static void loadIMageWithUrl(ImageView imageView, @Nullable String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
