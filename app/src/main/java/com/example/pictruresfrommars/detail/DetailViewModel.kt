package com.example.pictruresfrommars.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.pictruresfrommars.network.MarsProperty

/**
 * The [ViewModel] that is associated with the [DetailFragment].
 */
class DetailViewModel(marsProperty: MarsProperty, app: Application) : AndroidViewModel(app) {

    private val  _selectedProperty = MutableLiveData<MarsProperty>()

    val selectedProperty :LiveData<MarsProperty>
       get() = _selectedProperty


    init {
        _selectedProperty.value = marsProperty
    }




}