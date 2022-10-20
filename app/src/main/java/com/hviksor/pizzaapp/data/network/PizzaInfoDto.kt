package com.hviksor.pizzaapp.data.network

data class PizzaInfoDto(
    val title: String,
    val description: String,
    val price: String,
    val imgUrl: String,
    val pizzaId: Int
)