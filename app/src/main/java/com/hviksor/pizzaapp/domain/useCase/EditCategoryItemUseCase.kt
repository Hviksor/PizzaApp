package com.hviksor.pizzaapp.domain.useCase

import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.CategoryItem

class EditCategoryItemUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(categoryItem: CategoryItem) {
        repo.editCategoryItemUseCase(categoryItem)
    }
}