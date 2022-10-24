package com.hviksor.pizzaapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.hviksor.pizzaapp.data.database.PizzaDataBase
import com.hviksor.pizzaapp.data.mapper.PizzaMapper
import com.hviksor.pizzaapp.data.network.GetCategoryItem
import com.hviksor.pizzaapp.data.workers.RefreshDataWorker
import com.hviksor.pizzaapp.data.workers.RefreshDataWorker.Companion.WORKER_NAME
import com.hviksor.pizzaapp.domain.CategoryItem
import com.hviksor.pizzaapp.domain.PizzaInfoEntity
import com.hviksor.pizzaapp.domain.PizzaRepository
import java.util.*

class PizzaRepositoryImpl(private val application: Application) : PizzaRepository {
    private var categoryList = TreeSet<CategoryItem>()
    private val categoryListLD = MutableLiveData<List<CategoryItem>>()
    private val coinDao = PizzaDataBase.getInstance(application).pizzaDao()
    private val mapper = PizzaMapper()
    private val getCategory = GetCategoryItem()


    init {
        categoryList = getCategory.addCategory()
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
        workManager.enqueueUniqueWork(// Ощущение что здесь происходит какая-то магия. Как было бы прозрачней: из domain-слоя (UseCase) вызывается loadData() репозитория, 
            // в котором возвращаются данные. UseCase сохраняет эти данные в Room (на будущее, вдруг не будет соединения) и эти же данные отдает в presentation - слой.
            // По заданию - данные должны получатся от сервера, а Offline-режим - на  случай если нет сети
            WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.getOneTimeWorkRequest()
        )
    }

    private fun updateCategoryList() {
        categoryListLD.value = categoryList.toList()
    }


}
