package com.example.digitaldukan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    // lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)


        val retrofitBuilder = Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())  //We can also use moshi library as alternative of Gson
            .build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()
                val productlist = responseBody?.products!!

                myAdapter = MyAdapter(this@MainActivity, productlist)
                myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
                    override fun onItemClick(product: Product) {
                        // Start DetailActivity with the selected item's data
                        val intent = Intent(this@MainActivity, detailAct::class.java)
                        intent.putExtra("selectedProduct", product)
                        startActivity(intent)
                    }
                })
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Main Activity", "OnFailure: " + t.message)
            }
        })
    }
}


