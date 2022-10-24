package com.hviksor.pizzaapp.domain // Интерфейс Repository вроде не должен в слое domain лежать, а в слое data

import androidx.lifecycle.LiveData

interface PizzaRepository {

    fun getCategoryListUseCase(): LiveData<List<CategoryItem>>
    fun editCategoryItemUseCase(categoryItem: CategoryItem)
    fun getProductListUseCase(): LiveData<List<PizzaInfoEntity>>
    fun loadData()

}
