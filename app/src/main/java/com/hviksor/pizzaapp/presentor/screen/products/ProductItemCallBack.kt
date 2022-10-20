package com.hviksor.pizzaapp.presentor.screen.products

import androidx.recyclerview.widget.DiffUtil
import com.hviksor.pizzaapp.data.database.PizzaDbModel
import com.hviksor.pizzaapp.domain.PizzaInfoEntity

class ProductItemCallBack : DiffUtil.ItemCallback<PizzaInfoEntity>() {

    override fun areItemsTheSame(oldItem: PizzaInfoEntity, newItem: PizzaInfoEntity): Boolean {
        return oldItem.pizzaId == newItem.pizzaId
    }

    override fun areContentsTheSame(oldItem: PizzaInfoEntity, newItem: PizzaInfoEntity): Boolean {
        return oldItem == newItem
    }

}