package com.example.pictruresfrommars

class Event <out T>(val content : T) {
   private  var hasContentBeenHandled :Boolean = false
       private set // Allow external read but not write

     fun getContentIfNotHandled():T?{
       return  if(hasContentBeenHandled){
                null
       }else{
           hasContentBeenHandled=true
           content
       }
     }
    fun  continuousContent () :T  = content
}