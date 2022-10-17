package com.hviksor.pizzaapp.presentor.screen

import androidx.lifecycle.ViewModel
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.EditCategoryItemUseCase
import com.hviksor.pizzaapp.domain.GetCategoryListUseCase

class PizzaViewModel : ViewModel() {
    private val repo = PizzaRepositoryImpl
    private val getCategoryListUseCase = GetCategoryListUseCase(repo)
    private val editCategoryItemUseCase = EditCategoryItemUseCase(repo)

    val categoryList = getCategoryListUseCase()

    fun changeEnabled(categoryItem: CategoryItem) {
        editCategoryItemUseCase(categoryItem)
    }

}