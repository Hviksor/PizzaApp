package com.hviksor.pizzaapp.presentor.screen.category

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hviksor.pizzaapp.R
import com.hviksor.pizzaapp.domain.CategoryItem

class CategoryAdapter : ListAdapter<CategoryItem, CategoryViewHolder>(CategoryItemCallBack()) {
    var categoryItemClick: ((CategoryItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.category_item_enable
            VIEW_TYPE_DISABLED -> R.layout.category_item_disable
            else -> throw RuntimeException("viewType is empty")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryItem = getItem(position)
        holder.btCategory.text = categoryItem.name
        holder.btCategory.setOnClickListener {
            categoryItemClick?.invoke(categoryItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0
    }

}