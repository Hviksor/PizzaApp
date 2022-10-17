package com.hviksor.pizzaapp.domain

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl

class GetCategoryListUseCase(private val repo: PizzaRepositoryImpl) {
    operator fun invoke(): LiveData<List<CategoryItem>> {
        return repo.getCategoryListUseCase()
    }
}