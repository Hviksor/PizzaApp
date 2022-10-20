package com.hviksor.pizzaapp.data.network

import com.hviksor.pizzaapp.domain.CategoryItem
import java.util.*

class GetCategoryItem {
    private val categoryList = sortedSetOf<CategoryItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    fun addCategory(): TreeSet<CategoryItem> {
        categoryList.add(CategoryItem("Пицца", true, 1))
        categoryList.add(CategoryItem("Комбо", false, 2))
        categoryList.add(CategoryItem("Закуски", false, 3))
        categoryList.add(CategoryItem("Дессерт", false, 4))
        categoryList.add(CategoryItem("Напитки", false, 5))
        categoryList.add(CategoryItem("Другие товары", false, 6))
        categoryList.add(CategoryItem("Акции", false, 7))
        categoryList.add(CategoryItem("Контакты", false, 8))
        categoryList.add(CategoryItem("О нас", false, 9))
        categoryList.add(CategoryItem("Работа в Додо", false, 10))
        return categoryList
    }


}