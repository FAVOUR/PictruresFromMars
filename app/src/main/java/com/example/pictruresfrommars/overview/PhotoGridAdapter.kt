/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.pictruresfrommars.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pictruresfrommars.databinding.GridViewItemBinding
import com.example.pictruresfrommars.network.MarsProperty


class PhotoGridAdapter(val marsPropertyListener: MarsPropertyListener) :ListAdapter<MarsProperty,PhotoGridAdapterViewHolder>(MarsPropertyDiffUtil()){
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapterViewHolder {
       return  PhotoGridAdapterViewHolder.from(parent)

   }

    override fun onBindViewHolder(holder: PhotoGridAdapterViewHolder, position: Int) {
        holder.bind(getItem(position),marsPropertyListener)

    }


    class  MarsPropertyDiffUtil : DiffUtil.ItemCallback<MarsProperty>(){
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
                return oldItem.id ==newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
                  return oldItem==newItem
        }

    }



}
  class PhotoGridAdapterViewHolder (val gridViewItemBinding: GridViewItemBinding) :RecyclerView.ViewHolder(gridViewItemBinding.root){


         fun bind(marsProperty: MarsProperty, marsPropertyListener: MarsPropertyListener){

             gridViewItemBinding.property =marsProperty
             gridViewItemBinding.itemClicked=marsPropertyListener
             gridViewItemBinding.executePendingBindings()
         }


          companion object{
               fun from(viewGroup: ViewGroup):PhotoGridAdapterViewHolder{
                  val layoutInflater = LayoutInflater.from(viewGroup.context)
                  val view = GridViewItemBinding.inflate(layoutInflater)
                  return PhotoGridAdapterViewHolder(view)
              }
          }
  }


     class  MarsPropertyListener( val clickListener :( marsProperty:MarsProperty) -> Unit){

       fun onClick( marsProperty:MarsProperty) = clickListener(marsProperty)
   }


