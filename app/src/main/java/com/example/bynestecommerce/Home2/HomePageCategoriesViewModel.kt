package com.example.bynestecommerce.Home2

import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.bynestecommerce.ApiBaseClient
import com.example.bynestecommerce.ApiBaseInterface


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageCategoriesViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private lateinit var apiInterface: ApiBaseInterface


    val responseListLivedata: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }
    var categoriesArrayList: ArrayList<String> = ArrayList()


    init {
        apiInterface = ApiBaseClient.getInstance().create(ApiBaseInterface::class.java)
    }


    fun getCategories() {


        apiInterface.getCategoriesApi().enqueue(object : Callback<ArrayList<String>> {
            override fun onResponse(
                call: Call<ArrayList<String>>,
                response: Response<ArrayList<String>>
            ) {

                if (response.isSuccessful && response.body() != null) {
                    categoriesArrayList = response.body()!!
                    responseListLivedata.postValue(categoriesArrayList)

                    Log.d("Api Response ", categoriesArrayList.toString())
                }

            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                t.printStackTrace()
                Log.d("API RESPONSE", t.toString())
            }
        })


    }

}






