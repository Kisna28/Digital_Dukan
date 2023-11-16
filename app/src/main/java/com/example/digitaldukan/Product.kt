package com.example.digitaldukan

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.util.ArrayList

data class Product(
    val brand: String?,
    val category: String?,
    val description: String?,
    val discountPercentage: Double,
    val id: Int,
    val images: ArrayList<String>?,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String?,
    val title: String?
): Serializable
