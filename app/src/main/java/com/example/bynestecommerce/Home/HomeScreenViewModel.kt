package com.example.bynestecommerce.Home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bynestecommerce.ApiBaseClient
import com.example.bynestecommerce.ApiBaseInterface
import com.example.bynestecommerce.ProductDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenViewModel : ViewModel() {

    //1st
    private lateinit var apiInterface: ApiBaseInterface


    val responseListLivedata: MutableLiveData<ArrayList<ProductDetail>> by lazy {
        MutableLiveData<ArrayList<ProductDetail>>() //LAST
    }

    var productArrayList: ArrayList<ProductDetail> = ArrayList()

    init {
        apiInterface = ApiBaseClient.getInstance().create(ApiBaseInterface::class.java)
    }


    //2nd api call
    fun getProductList() {


        apiInterface.getProductsListApi().enqueue(object : Callback<ArrayList<ProductDetail>> {

            override fun onResponse(
                call: Call<ArrayList<ProductDetail>>,
                response: Response<ArrayList<ProductDetail>>
            ) {

                if (response.isSuccessful && response.body() != null) {
                    productArrayList = response.body()!!

                    responseListLivedata.postValue(productArrayList)

                    Log.d("API RESPONSE", productArrayList.toString())

                }


            }


            override fun onFailure(call: Call<ArrayList<ProductDetail>>, t: Throwable) {
                //failure case
                t.printStackTrace()
                Log.d("API RESPONSE", t.toString())
            }


        })
    }


}