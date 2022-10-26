package com.hviksor.pizzaapp.presentation.screen.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hviksor.pizzaapp.R
import com.hviksor.pizzaapp.databinding.ItemProductBinding
import com.hviksor.pizzaapp.domain.PizzaInfoEntity
import com.squareup.picasso.Picasso

class ProductAdapter : ListAdapter<PizzaInfoEntity, ProductAdapter.ProductViewHolder>(ProductItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = getItem(position)
        val binding = ItemProductBinding.bind(holder.itemView)
        binding.titleTvProductItem.text = productItem.title
        binding.descTvProductItem.text = productItem.description
        binding.priceTvProductItem.text = productItem.price
        Picasso.get().load(productItem.imgUrl)
            .into(binding.imProductItem)
    }

    class ProductViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
    }

}