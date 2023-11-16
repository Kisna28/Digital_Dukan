package com.example.digitaldukan

import java.util.ArrayList

data class MyData(
    val limit: Int,
    val products: ArrayList<Product>?,
    val skip: Int,
    val total: Int
)
