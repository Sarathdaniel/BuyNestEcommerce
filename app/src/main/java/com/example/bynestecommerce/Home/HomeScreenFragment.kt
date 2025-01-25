package com.example.bynestecommerce.Home

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bynestecommerce.ProductDetail
import com.example.bynestecommerce.ProductListAdapter
import com.example.bynestecommerce.R
import com.example.bynestecommerce.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()
    }

    //2nd
    private lateinit var viewModel: HomeScreenViewModel

    //1st
    private lateinit var _binding: FragmentHomeScreenBinding
    private val binding get() = _binding

    private lateinit var adapter: ProductListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]

        viewModel.getProductList()

        //recycler adapter
        adapter = ProductListAdapter(viewModel.productArrayList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter


        viewModel.responseListLivedata.observe(viewLifecycleOwner,
            Observer<ArrayList<ProductDetail>>
            { latestList ->
                adapter.updateProduct(latestList)
            })


    }

}





