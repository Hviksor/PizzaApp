package com.hviksor.pizzaapp.presentor.screen.products

import com.hviksor.pizzaapp.domain.CategoryItem
import androidx.recyclerview.widget.DiffUtil
import com.hviksor.pizzaapp.domain.ProductItem

class ProductItemCallBack : DiffUtil.ItemCallback<ProductItem>() {

    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }

}