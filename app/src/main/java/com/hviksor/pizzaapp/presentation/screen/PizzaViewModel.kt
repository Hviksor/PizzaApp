package com.hviksor.pizzaapp.presentation.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.useCase.EditCategoryItemUseCase
import com.hviksor.pizzaapp.domain.useCase.GetCategoryListUseCase
import com.hviksor.pizzaapp.domain.useCase.GetProductItemListUseCase
import com.hviksor.pizzaapp.domain.useCase.LoadDataUseCase

class PizzaViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = PizzaRepositoryImpl(application)
    private val loadDataUseCase = LoadDataUseCase(repo)
    private val getCategoryListUseCase = GetCategoryListUseCase(repo)
    private val getProductListUseCase = GetProductItemListUseCase(repo)
    private val editCategoryItemUseCase = EditCategoryItemUseCase(repo)

    init {
        loadDataUseCase()

    }

    val categoryList = getCategoryListUseCase()

    fun changeEnabled(categoryItem: CategoryItem) {
        editCategoryItemUseCase(categoryItem)
    }

    val productList = getProductListUseCase()

}