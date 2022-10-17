package com.hviksor.pizzaapp.domain

import com.hviksor.pizzaapp.data.PizzaRepositoryImpl

class EditCategoryItemUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(categoryItem: CategoryItem) {
        repo.editCategoryItemUseCase(categoryItem)
    }
}