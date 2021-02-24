package com.example.delivery.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.delivery.App;
import com.example.delivery.Loger;


public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void setImageUrl(ImageView imageView, String url) {
        Context context=imageView.getContext();
        int imageRecource=context.getResources().getIdentifier(url,  null,context.getPackageName());

        Loger.log("ids");
        Drawable drawable=context.getResources().getDrawable((imageRecource));

    }
}
