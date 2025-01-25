package com.example.bynestecommerce.Home2

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bynestecommerce.Home.CategoriesAdapter
import com.example.bynestecommerce.Home.HomeScreenFragment
import com.example.bynestecommerce.Home.HomeScreenViewModel
import com.example.bynestecommerce.ProductDetail
import com.example.bynestecommerce.ProductListAdapter
import com.example.bynestecommerce.R
import com.example.bynestecommerce.databinding.FragmentHomePageCatageresBinding
import com.example.bynestecommerce.databinding.FragmentHomeScreenBinding

class HomePageCategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()

    }

    private lateinit var _binding: FragmentHomePageCatageresBinding
    private val binding get() = _binding

    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageCatageresBinding.inflate(inflater, container, false)
         return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }




}
