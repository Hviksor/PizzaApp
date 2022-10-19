package com.hviksor.pizzaapp.data.mapper

import com.hviksor.pizzaapp.data.database.PizzaDbModel
import com.hviksor.pizzaapp.data.network.PizzaInfoDto

class PizzaMapper {

    fun mapDtoToDb(pizzaInfoDto: ArrayList<PizzaInfoDto>): ArrayList<PizzaDbModel> {
        val pizzaDbModel = ArrayList<PizzaDbModel>()
        for (item in pizzaInfoDto) {
            pizzaDbModel.add(
                PizzaDbModel(
                    title = item.title,
                    description = item.description,
                    price = item.price,
                    url = item.url,
                    id = item.id
                )
            )

        }
        return pizzaDbModel
    }
}