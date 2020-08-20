package com.example.pictruresfrommars

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
    fun setImage(imageView :ImageView,imageUrl:String?){
    imageUrl?.let {

        var proposedUri = imageUrl. toUri().buildUpon().scheme("https").build()
            Glide.with(imageView.context)
                .load(proposedUri)
                .apply(RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
                .into(imageView)


    }
       }