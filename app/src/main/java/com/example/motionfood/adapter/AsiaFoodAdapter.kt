package com.example.motionfood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motionfood.DetailsActivity
import com.example.motionfood.R
import com.example.motionfood.model.AsiaFood
import com.example.motionfood.model.PopularFood

lateinit var mContext: Context
class AsiaFoodAdapter(val context: Context,private val listAsia:List<AsiaFood>):RecyclerView.Adapter<AsiaFoodAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val ImgFood = itemView.findViewById<ImageView>(R.id.img_food_asia)
        val FoodName = itemView.findViewById<TextView>(R.id.foodName_asia)
        val FoodPrice = itemView.findViewById<TextView>(R.id.food_price_asia)
        val RestauranName = itemView.findViewById<TextView>(R.id.food_title_asia)
        val Rating = itemView.findViewById<TextView>(R.id.Rating)

        fun onBind(asiaFood: AsiaFood){
          ImgFood.setImageResource(asiaFood.imgUrlAsia)
            FoodName.text = asiaFood.foodName
            FoodPrice.text = asiaFood.price
            RestauranName.text = asiaFood.restauranName
            Rating.text =asiaFood.rating

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_asia,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.onBind(listAsia[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listAsia.size
    }
}