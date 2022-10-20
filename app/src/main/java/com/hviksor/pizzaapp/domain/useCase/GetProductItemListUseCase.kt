package com.hviksor.pizzaapp.domain.useCase

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.PizzaInfoEntity

class GetProductItemListUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(): LiveData<List<PizzaInfoEntity>> {
        return repo.getProductListUseCase()
    }
}