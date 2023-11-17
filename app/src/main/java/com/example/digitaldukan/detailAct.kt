package com.example.digitaldukan


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.squareup.picasso.Picasso

class detailAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imagedescs: ImageView = findViewById(R.id.imageViewThumbnail)
        val textViewTitle: TextView = findViewById(R.id.textViewTitle)
        val textViewBrand: TextView = findViewById(R.id.textViewBrand)
        val textViewCategory: TextView = findViewById(R.id.textViewCategory)
        val textViewDescription: TextView = findViewById(R.id.textViewDescription)
        val textViewPrice: TextView = findViewById(R.id.textViewPrice)
        val textViewDiscountPercentage: TextView = findViewById(R.id.textViewDiscountPercentage)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val textViewStock: TextView = findViewById(R.id.textViewStock)

        val selectedProduct = intent.getSerializableExtra("selectedProduct") as Product

        // Use the selectedProduct data to update your UI or perform other actions
        // For example, you can load the image into an ImageView:

        Picasso.get().load(selectedProduct.thumbnail).into(imagedescs)
        textViewTitle.text = selectedProduct.title
        textViewBrand.text = selectedProduct.brand
        textViewCategory.text = selectedProduct.category
        textViewDescription.text = selectedProduct.description
        textViewPrice.text = "Price :$${selectedProduct.price}"
        textViewDiscountPercentage.text = "Discount :${selectedProduct.discountPercentage}%"
        ratingBar.rating = selectedProduct.rating.toFloat()
        textViewStock.text = "In Stock :${selectedProduct.stock}"





    }
}




