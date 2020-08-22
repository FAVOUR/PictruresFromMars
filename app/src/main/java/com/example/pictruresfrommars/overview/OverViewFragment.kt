package com.example.pictruresfrommars.overview

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.pictruresfrommars.R
import com.example.pictruresfrommars.databinding.FragmentOverviewBinding
import com.example.pictruresfrommars.network.MarsApiFilter

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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
          val binding = FragmentOverviewBinding.inflate(layoutInflater)
         binding.lifecycleOwner =this
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter(MarsPropertyListener {

            viewModel.setPropertyForNavigation(it)
            Toast.makeText(requireContext(),"I have been clicked, I cost  ${it.price}",Toast.LENGTH_SHORT).show()
        })

        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.navigateToSelectedProperty.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
           findNavController().navigate(OverViewFragmentDirections.actionShowDetail(it))
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        viewModel.updateFilter(
            when (item.itemId){
             R.id.show_buy_menu ->{
                 MarsApiFilter.SHOW_BUY
             }

             R.id.show_rent_menu ->{
                 MarsApiFilter.SHOW_RENT
             }

          else->{
                    MarsApiFilter.SHOW_ALL
                }
         }
        )
        return super.onOptionsItemSelected(item)
    }




}