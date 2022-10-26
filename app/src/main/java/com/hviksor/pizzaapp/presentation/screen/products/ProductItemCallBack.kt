package com.hviksor.pizzaapp.presentation.screen.products

import androidx.recyclerview.widget.DiffUtil
import com.hviksor.pizzaapp.domain.PizzaInfoEntity

class ProductItemCallBack : DiffUtil.ItemCallback<PizzaInfoEntity>() {

    override fun areItemsTheSame(oldItem: PizzaInfoEntity, newItem: PizzaInfoEntity): Boolean {
        return oldItem.pizzaId == newItem.pizzaId
    }

    override fun areContentsTheSame(oldItem: PizzaInfoEntity, newItem: PizzaInfoEntity): Boolean {
        return oldItem == newItem
    }

}