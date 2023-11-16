package com.example.digitaldukan

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products?limit=100")
    fun getProductData(): Call<MyData>
}