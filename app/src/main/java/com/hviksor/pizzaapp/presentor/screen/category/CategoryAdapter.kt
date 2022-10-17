package com.hviksor.pizzaapp.presentor.screen.category

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.hviksor.pizzaapp.R
import com.hviksor.pizzaapp.databinding.CategoryItemDisableBinding
import com.hviksor.pizzaapp.databinding.CategoryItemEnableBinding
import com.hviksor.pizzaapp.domain.CategoryItem

class CategoryAdapter : ListAdapter<CategoryItem, CategoryViewHolder>(CategoryItemCallBack()) {
    var categoryItemClick: ((CategoryItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.category_item_enable
            VIEW_TYPE_DISABLED -> R.layout.category_item_disable
            else -> throw RuntimeException("viewType is empty")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryItem = getItem(position)
        val binding = holder.binding
        binding.root.setOnClickListener {
            Log.e("editCategoryItemUseCase", "editCategoryItemUseCase")
            categoryItemClick?.invoke(categoryItem)
        }
        when (binding) {
            is CategoryItemEnableBinding -> {
                binding.categoryItemButton.text = categoryItem.name
            }
            is CategoryItemDisableBinding -> {
                binding.categoryItemButton.text = categoryItem.name
            }
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