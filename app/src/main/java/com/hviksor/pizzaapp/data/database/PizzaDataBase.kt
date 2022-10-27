package com.hviksor.pizzaapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PizzaDbModel::class], version = 4, exportSchema = false)
abstract class PizzaDataBase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao

    companion object {
        private var INSTANCE: PizzaDataBase? = null
        private var LOCK = Any()
        private const val DB_NAME = "db"

        @Synchronized
        fun getInstance(context: Context): PizzaDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = createDb(context)
                INSTANCE = db
                return db
            }

        }

        private fun createDb(context: Context): PizzaDataBase {
            val db = Room.databaseBuilder(context, PizzaDataBase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
            return db
        }


    }


}