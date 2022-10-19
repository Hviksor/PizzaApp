package com.hviksor.pizzaapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface PizzaRepository {

    fun getCategoryListUseCase(): LiveData<List<CategoryItem>>
    fun editCategoryItemUseCase(categoryItem: CategoryItem)
    fun getProductListUseCase(): LiveData<List<ProductItem>>
    fun loadData()

}