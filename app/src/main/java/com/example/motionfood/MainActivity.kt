package com.example.motionfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionfood.adapter.AsiaFoodAdapter
import com.example.motionfood.adapter.PopularFoodAdapter
import com.example.motionfood.model.AsiaFood
import com.example.motionfood.model.PopularFood
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var popularFoodAdapter:PopularFoodAdapter
    lateinit var listFoods:MutableList<PopularFood>

    lateinit var asiaFoodAdapter:AsiaFoodAdapter
    lateinit var listAsia:MutableList<AsiaFood>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          listFoods = ArrayList()
          listAsia = ArrayList()

        //Food Horizontal recyclerView
        foodAddAll()
        popularFoodAdapter = PopularFoodAdapter(listFoods)
      recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = popularFoodAdapter

           foodAddAsia()
        recyclerView_asiaFood.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        asiaFoodAdapter = AsiaFoodAdapter(applicationContext,listAsia)
        recyclerView_asiaFood.adapter = asiaFoodAdapter

         }
    fun foodAddAll(){
        for (i in 1 until 20){
            listFoods.add(PopularFood("Float Cake\nVietnam","$${+5*i}",R.drawable.food))
        }
    }

    fun foodAddAsia(){
        for (i in 1 until 20){
            listAsia.add(AsiaFood(R.drawable.food,"Briand Restaurant","Chicago Pizza","4.9","$${i*3}"))
        }
    }

}