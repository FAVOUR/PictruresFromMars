package com.example.pictruresfrommars.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pictruresfrommars.network.MarsApi
import com.example.pictruresfrommars.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverViewViewModel : ViewModel() {
    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    private val _properties =MutableLiveData<List<MarsProperty>>()
     val properties :LiveData<List<MarsProperty>>
      get() = _properties


    private val viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {

       coroutineScope.launch {
        var getPropertiesDeferred =  MarsApi.retrofitService.getProperties()


           try {

               // Await the completion of our Retrofit request
               var listResult = getPropertiesDeferred.await()

               _response.value =
                   "Success: ${listResult.size} Mars properties retrieved"


                   _properties.value=listResult


           } catch (e: Exception) {
               _response.value = "Failure: ${e.message}"
           }
    }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}