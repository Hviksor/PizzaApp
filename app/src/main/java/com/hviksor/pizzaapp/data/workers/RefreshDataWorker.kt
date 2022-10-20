package com.hviksor.pizzaapp.data.workers

import android.content.Context
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.hviksor.pizzaapp.data.database.PizzaDataBase
import com.hviksor.pizzaapp.data.mapper.PizzaMapper
import com.hviksor.pizzaapp.data.network.GetWbeInform
import kotlinx.coroutines.delay

class RefreshDataWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    private val dao = PizzaDataBase.getInstance(appContext).pizzaDao()
    private val pizzaMapper = PizzaMapper()
    private val apiService = GetWbeInform()


    override suspend fun doWork(): Result {
            try {
                val pizzaInfoList = apiService.loadDataPizzaInfo()
                val pizzaInfoDbList = pizzaMapper.mapDtoToDb(pizzaInfoList)
                dao.insertPizzaInfo(pizzaInfoDbList)

            } catch (e: Exception) {
            }
        return Result.success()
    }
    companion object {
        const val WORKER_NAME = "RefreshDataWorker"

        fun getOneTimeWorkRequest() =
            OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .setConstraints(getConstraint())
                .build()

        private fun getConstraint(): Constraints {
            return Constraints.Builder()
                .setRequiresCharging(true)
                .build()
        }

    }
}