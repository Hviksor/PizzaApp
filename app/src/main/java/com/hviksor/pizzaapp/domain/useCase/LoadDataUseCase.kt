package com.hviksor.pizzaapp.domain.useCase

import com.hviksor.pizzaapp.data.PizzaRepositoryImpl

class LoadDataUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke() {
        repo.loadData()
    }
}