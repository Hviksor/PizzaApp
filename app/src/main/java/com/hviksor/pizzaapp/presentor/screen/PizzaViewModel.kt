package com.hviksor.pizzaapp.presentor.screen

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.EditCategoryItemUseCase
import com.hviksor.pizzaapp.domain.GetCategoryListUseCase
import com.hviksor.pizzaapp.domain.GetProductItemListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel : ViewModel() {
    private val repo = PizzaRepositoryImpl
    private val getCategoryListUseCase = GetCategoryListUseCase(repo)
    private val getProductListUseCase = GetProductItemListUseCase(repo)
    private val editCategoryItemUseCase = EditCategoryItemUseCase(repo)

    init {
        var doc: Document
        viewModelScope.launch(Dispatchers.IO) {
            Log.e("jsoupp", "jsoupp")
            doc = Jsoup.connect("https://dodopizza.ru/moscow/").get()

            Log.e("jsoupp", doc.title())
        }
//


    }

    val categoryList = getCategoryListUseCase()

    fun changeEnabled(categoryItem: CategoryItem) {
        editCategoryItemUseCase(categoryItem)
    }

    val productList = getProductListUseCase()

}