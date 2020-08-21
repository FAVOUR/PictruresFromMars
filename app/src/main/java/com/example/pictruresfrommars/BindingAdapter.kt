package com.example.pictruresfrommars

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.pictruresfrommars.network.MarsProperty
import com.example.pictruresfrommars.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
    fun setImage(imageView :ImageView,imageUrl:String?){
    imageUrl?.let {

        var proposedUri = imageUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imageView.context)
                .load(proposedUri)
                .apply(RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
                .into(imageView)


    }
       }

   @BindingAdapter("listItem")
      fun setProperties(recyclerView: RecyclerView,marsProperty:List<MarsProperty>?){

      val adapter = recyclerView.adapter  as PhotoGridAdapter

       adapter.submitList(marsProperty)




   }