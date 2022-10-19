package com.hviksor.pizzaapp.domain.useCase

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.CategoryItem

class GetCategoryListUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(): LiveData<List<CategoryItem>> {
        return repo.getCategoryListUseCase()
    }
}