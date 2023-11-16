package com.example.digitaldukan

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context,val productArrayList : List<Product> ) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


 interface OnItemClickListener {
     fun onItemClick(product: Product)
 }
    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]




        holder.title.text = currentItem.title
        holder.desc.text = currentItem.description
        holder.price.text = currentItem.price.toString() //Here we can Add toString() Methode because Price is Integer so...
        Picasso.get().load(currentItem.thumbnail).into(holder.image)

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }
    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        val image : ImageView = itemView.findViewById(R.id.image)
        val title : TextView = itemView.findViewById(R.id.title)
        val desc : TextView = itemView.findViewById(R.id.description)
        val price : TextView = itemView.findViewById(R.id.price)
    }
}


