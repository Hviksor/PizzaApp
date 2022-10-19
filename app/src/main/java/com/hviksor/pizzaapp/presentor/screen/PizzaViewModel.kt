package com.hviksor.pizzaapp.presentor.screen

import org.jsoup.nodes.Document
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hviksor.pizzaapp.data.PizzaRepositoryImpl
import com.hviksor.pizzaapp.data.network.GetWbeInform
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.useCase.EditCategoryItemUseCase
import com.hviksor.pizzaapp.domain.useCase.GetCategoryListUseCase
import com.hviksor.pizzaapp.domain.useCase.GetProductItemListUseCase
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
            val getWeb = GetWbeInform()
            getWeb.loadDataPizzaInfo()
        }
//


    }

    val categoryList = getCategoryListUseCase()

    fun changeEnabled(categoryItem: CategoryItem) {
        editCategoryItemUseCase(categoryItem)
    }

    val productList = getProductListUseCase()

}