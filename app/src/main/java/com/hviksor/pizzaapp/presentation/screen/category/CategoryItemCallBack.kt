package com.hviksor.pizzaapp.presentation.screen.category

import com.hviksor.pizzaapp.domain.CategoryItem
import androidx.recyclerview.widget.DiffUtil

class CategoryItemCallBack : DiffUtil.ItemCallback<CategoryItem>() {

    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }

}