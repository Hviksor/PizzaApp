package com.hviksor.pizzaapp.domain

import androidx.lifecycle.LiveData

interface PizzaRepository {

    fun getCategoryListUseCase(): LiveData<List<CategoryItem>>
    fun editCategoryItemUseCase(categoryItem: CategoryItem)
    fun getProductListUseCase(): LiveData<List<PizzaInfoEntity>>
    fun loadData()

}