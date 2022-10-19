package com.hviksor.pizzaapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_product_info")
data class PizzaDbModel(
    val title: String,
    val description: String,
    val price: String,
    val url: String,
    @PrimaryKey
    val id: Int
)