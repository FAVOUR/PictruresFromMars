package com.example.pictruresfrommars.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pictruresfrommars.R
import com.example.pictruresfrommars.databinding.FragmentOverviewBinding
import com.example.pictruresfrommars.databinding.GridViewItemBinding

class OverViewFragment : Fragment() {



    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val viewModel: OverViewViewModel by lazy {
        ViewModelProviders.of(this)[OverViewViewModel::class.java]
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          val binding = FragmentOverviewBinding.inflate(layoutInflater)
         binding.lifecycleOwner =this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}