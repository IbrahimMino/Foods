package com.example.motionfood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motionfood.R
import com.example.motionfood.model.PopularFood

class PopularFoodAdapter(private val listFoods:List<PopularFood>):RecyclerView.Adapter<PopularFoodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val ImgFood = itemView.findViewById<ImageView>(R.id.img_food)
        val FoodTitle = itemView.findViewById<TextView>(R.id.food_title)
        val FoodPrice = itemView.findViewById<TextView>(R.id.food_price)
        fun onBind(popularFood: PopularFood){
          ImgFood.setImageResource(popularFood.imgUrl)
            FoodTitle.text = popularFood.nam
            FoodPrice.text = "${popularFood.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.onBind(listFoods[position])
    }

    override fun getItemCount(): Int {
        return listFoods.size
    }
}