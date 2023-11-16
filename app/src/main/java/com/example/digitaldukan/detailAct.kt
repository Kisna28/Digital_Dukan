package com.example.digitaldukan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class detailAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val imagedescs: ImageView = findViewById(R.id.imagedesc)
        val textdesc: TextView = findViewById(R.id.textdesc)
        val selectedProduct = intent.getSerializableExtra("selectedProduct") as Product

        // Use the selectedProduct data to update your UI or perform other actions
        // For example, you can load the image into an ImageView:

        Picasso.get().load(selectedProduct.thumbnail).into(imagedescs)
        textdesc.text = selectedProduct.title


        /*
           val model = intent.getParcelableExtra<Product>("image")
                textdesc.text = model?.title
        */


    }
}




