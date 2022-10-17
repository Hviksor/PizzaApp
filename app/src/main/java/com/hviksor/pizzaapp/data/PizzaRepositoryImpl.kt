package com.hviksor.pizzaapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.PizzaRepository

object PizzaRepositoryImpl : PizzaRepository {
    private val categoryList = sortedSetOf<CategoryItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val categoryListLD = MutableLiveData<List<CategoryItem>>()

    init {
        categoryList.add(CategoryItem("Пицца", true, 1))
        categoryList.add(CategoryItem("Комбо", false, 2))
        categoryList.add(CategoryItem("Закуски", false, 3))
        categoryList.add(CategoryItem("Дессерт", false, 4))
        categoryList.add(CategoryItem("Напитки", false, 5))
        updateList()
    }


    override fun getCategoryListUseCase(): LiveData<List<CategoryItem>> {
        return categoryListLD
    }

    override fun editCategoryItemUseCase(categoryItem: CategoryItem) {
        for (item in categoryList) {
            item.enabled = false
        }
        val oldItem = categoryList.find { it.id == categoryItem.id } ?: throw RuntimeException("categoryItem.id is absent")
        categoryList.remove(oldItem)
        categoryList.add(oldItem.copy(enabled = true))
        updateList()
    }

    private fun updateList() {
        categoryListLD.value = categoryList.toList()
    }


}