package com.example.pictruresfrommars

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
    fun ImageView.setImage(imageUrl:String?){
    imageUrl?.let {

//        var proposedUri = Uri().
            Glide.with(this.context)
                .load(imageUrl)
                .apply(RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
                .into(this)


    }
       }