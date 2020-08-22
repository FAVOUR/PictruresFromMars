package com.example.pictruresfrommars

class Event <out T>(val content : T) {
    var hasContentBeenHandled :Boolean = false
       private set // Allow external read but not write

     fun getContentOnce():T?{
       return  if(hasContentBeenHandled){
                null
       }else{
           hasContentBeenHandled=true
           content
       }
     }
    fun  continusContent () :T  = content
}