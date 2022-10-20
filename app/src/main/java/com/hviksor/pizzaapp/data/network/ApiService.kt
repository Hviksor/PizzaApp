package com.hviksor.pizzaapp.data.network

interface ApiService {
    suspend fun loadDataPizzaInfo(): ArrayList<PizzaInfoDto>
}