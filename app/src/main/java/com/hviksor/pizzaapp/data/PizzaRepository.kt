package com.hviksor.pizzaapp.data

import androidx.lifecycle.LiveData
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.PizzaInfoEntity

interface PizzaRepository {

    fun getCategoryListUseCase(): LiveData<List<CategoryItem>>
    fun editCategoryItemUseCase(categoryItem: CategoryItem)
    fun getProductListUseCase(): LiveData<List<PizzaInfoEntity>>
    fun loadData()

}