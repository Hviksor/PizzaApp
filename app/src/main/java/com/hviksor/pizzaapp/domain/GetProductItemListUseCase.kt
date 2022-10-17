package com.hviksor.pizzaapp.domain

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl

class GetProductItemListUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(): LiveData<List<ProductItem>> {
        return repo.getProductListUseCase()
    }
}