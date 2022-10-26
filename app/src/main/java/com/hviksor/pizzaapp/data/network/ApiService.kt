package com.hviksor.pizzaapp.data.network

interface ApiService {
    suspend fun loadDataPizzaInfo(): List<PizzaInfoDto>
}