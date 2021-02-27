package com.example.delivery.menu.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.delivery.App;
import com.example.delivery.Loger;


public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void setImageUrl(ImageView imageView, String url) {
        if (url!=null) {
            Context context = imageView.getContext();
            int imageRecource = context.getResources().getIdentifier(url, "drawable", context.getPackageName());
            Drawable drawable = context.getResources().getDrawable((imageRecource));
            imageView.setImageDrawable(drawable);
        }
    }
}
