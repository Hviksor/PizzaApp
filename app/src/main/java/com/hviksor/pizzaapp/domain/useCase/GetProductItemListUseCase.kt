package com.hviksor.pizzaapp.domain.useCase

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.ProductItem

class GetProductItemListUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(): LiveData<List<ProductItem>> {
        return repo.getProductListUseCase()
    }
}