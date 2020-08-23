package com.example.pictruresfrommars.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pictruresfrommars.R
import com.example.pictruresfrommars.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var marsProperty =DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetailViewModelFactory(marsProperty,requireActivity().application)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailViewModel::class.java)

        val binding =DetailFragmentBinding.inflate(inflater)
           binding.lifecycleOwner=this
           binding.viewmodel =viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}