package com.example.bynestecommerce.Home2

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bynestecommerce.Home.CategoriesAdapter
import com.example.bynestecommerce.Home.HomeScreenFragment
import com.example.bynestecommerce.Home.HomeScreenViewModel
import com.example.bynestecommerce.ProductDetail
import com.example.bynestecommerce.ProductListAdapter
import com.example.bynestecommerce.R

import com.example.bynestecommerce.databinding.FragmentHomePageCategoriesBinding
import com.example.bynestecommerce.databinding.FragmentHomeScreenBinding

class HomePageCategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()

    }
    private lateinit var viewModel: HomePageCategoriesViewModel
    private lateinit var _binding: FragmentHomePageCategoriesBinding
    private val binding get() = _binding

    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageCategoriesBinding.inflate(inflater, container, false)
         return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomePageCategoriesViewModel::class.java]

        viewModel.getCategories()

        adapter =   CategoriesAdapter(viewModel.categoriesArrayList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter


        viewModel.responseListLivedata.observe(viewLifecycleOwner,
            Observer<ArrayList<String>>
            { latestList ->
                adapter.updateProduct(latestList)
            })


        binding.startb.setOnClickListener {
            findNavController().navigate(R.id.action_homePageCategoriesFragment_to_homeScreenFragment2)
        }



    }




}
