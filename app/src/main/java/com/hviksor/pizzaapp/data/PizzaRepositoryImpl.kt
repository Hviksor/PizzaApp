package com.hviksor.pizzaapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.PizzaRepository
import com.hviksor.pizzaapp.domain.ProductItem

object PizzaRepositoryImpl : PizzaRepository {
    private val categoryList = sortedSetOf<CategoryItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val categoryListLD = MutableLiveData<List<CategoryItem>>()

    private val productList = sortedSetOf<ProductItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val productListLD = MutableLiveData<List<ProductItem>>()

    init {
        categoryList.add(CategoryItem("Пицца", true, 1))
        categoryList.add(CategoryItem("Комбо", false, 2))
        categoryList.add(CategoryItem("Закуски", false, 3))
        categoryList.add(CategoryItem("Дессерт", false, 4))
        categoryList.add(CategoryItem("Напитки", false, 5))
        updateCategoryList()
        productList.add(ProductItem("Цыпленок карри", "Цыпленок, ананасы, соус карри, красный лук, сладкий перец, моцарелла, фирменный томатный соус", "от 439 ₽", 1))
        productList.add(ProductItem("Мясной Микс", "Пастрами из индейки, острая чоризо, пикантная пепперони, бекон, моцарелла, фирменный томатный соус", "от 489 ₽", 2))
        productList.add(ProductItem("Сырная", "Моцарелла, сыры чеддер и пармезан, фирменный соус альфредо", "от 299 ₽", 3))
        productList.add(ProductItem("Ветчина и сыр", "Ветчина, моцарелла, фирменный соус альфредо", "от 329 ₽", 4))
        productList.add(ProductItem("Пепперони фреш", "Пикантная пепперони, увеличенная порция моцареллы, томаты, фирменный томатный соус", "от 439 ₽", 5))
        updateProductList()

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
        updateCategoryList()
    }

    override fun getProductListUseCase(): LiveData<List<ProductItem>> {
        return productListLD
    }

    private fun updateCategoryList() {
        categoryListLD.value = categoryList.toList()
    }

    private fun updateProductList() {
        productListLD.value = productList.toList()
    }


}