package com.example.bynestecommerce.Home2

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bynestecommerce.ApiBaseClient
import com.example.bynestecommerce.ApiBaseInterface
import com.example.bynestecommerce.Home.CategoriesAdapter
import com.example.bynestecommerce.ProductDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageCategoriesViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var apiInterface: ApiBaseInterface

    var categoriesArrayList: ArrayList<String> = ArrayList()



    init {
        apiInterface = ApiBaseClient.getInstance().create(ApiBaseInterface::class.java)
    }


    
    fun getCategories () {

        apiInterface.getCategoriesApi().enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(
                call: Call<ArrayList<String>>,
                response: Response<ArrayList<String>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }


}