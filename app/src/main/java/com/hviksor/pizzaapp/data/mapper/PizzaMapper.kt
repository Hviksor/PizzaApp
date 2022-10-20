package com.hviksor.pizzaapp.data.mapper

import com.hviksor.pizzaapp.data.database.PizzaDbModel
import com.hviksor.pizzaapp.data.network.PizzaInfoDto
import com.hviksor.pizzaapp.domain.PizzaInfoEntity

class PizzaMapper {

    fun mapDtoToDb(pizzaInfoDto: ArrayList<PizzaInfoDto>): ArrayList<PizzaDbModel> {
        val pizzaDbModel = ArrayList<PizzaDbModel>()
        for (item in pizzaInfoDto) {
            pizzaDbModel.add(
                PizzaDbModel(
                    title = item.title,
                    description = item.description,
                    price = item.price,
                    imgUrl = item.imgUrl,
                    pizzaId = item.pizzaId

                )
            )
        }
        return pizzaDbModel
    }

    fun mapDbToEntity(item: PizzaDbModel): PizzaInfoEntity {
        return PizzaInfoEntity(
            title = item.title,
            description = item.description,
            price = item.price,
            imgUrl = item.imgUrl,
            pizzaId = item.pizzaId
        )
    }

}