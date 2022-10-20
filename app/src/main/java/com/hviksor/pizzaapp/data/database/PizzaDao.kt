package com.hviksor.pizzaapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PizzaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPizzaInfo(list: ArrayList<PizzaDbModel>)

    @Query("SELECT * FROM pizza_product_info")
    fun getPizzaListInfo(): LiveData<List<PizzaDbModel>>


}