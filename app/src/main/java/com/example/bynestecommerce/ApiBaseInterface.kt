package com.example.bynestecommerce

import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface ApiBaseInterface {

    @GET("products")
    fun getProductsListApi(): Call<ArrayList<ProductDetail>>


    @GET("products/categories")
    fun getCategoriesApi(): Call<ArrayList<String>>


}
