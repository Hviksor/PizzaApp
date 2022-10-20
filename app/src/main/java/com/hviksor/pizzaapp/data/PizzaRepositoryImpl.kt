package com.hviksor.pizzaapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.hviksor.pizzaapp.data.database.PizzaDataBase
import com.hviksor.pizzaapp.data.database.PizzaDbModel
import com.hviksor.pizzaapp.data.mapper.PizzaMapper
import com.hviksor.pizzaapp.data.workers.RefreshDataWorker
import com.hviksor.pizzaapp.data.workers.RefreshDataWorker.Companion.WORKER_NAME
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.PizzaInfoEntity
import com.hviksor.pizzaapp.domain.PizzaRepository

class PizzaRepositoryImpl(private val application: Application) : PizzaRepository {
    private val categoryList = sortedSetOf<CategoryItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val categoryListLD = MutableLiveData<List<CategoryItem>>()

    private val coinDao = PizzaDataBase.getInstance(application).pizzaDao()
    private val mapper = PizzaMapper()


    init {
        categoryList.add(CategoryItem("Пицца", true, 1))
        categoryList.add(CategoryItem("Комбо", false, 2))
        categoryList.add(CategoryItem("Закуски", false, 3))
        categoryList.add(CategoryItem("Дессерт", false, 4))
        categoryList.add(CategoryItem("Напитки", false, 5))
        updateCategoryList()
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

    override fun getProductListUseCase(): LiveData<List<PizzaInfoEntity>> {
        return Transformations.map(coinDao.getPizzaListInfo()) { list ->
            list.map { mapper.mapDbToEntity(it) }
        }

    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.getOneTimeWorkRequest()
        )
    }

    private fun updateCategoryList() {
        categoryListLD.value = categoryList.toList()
    }


}