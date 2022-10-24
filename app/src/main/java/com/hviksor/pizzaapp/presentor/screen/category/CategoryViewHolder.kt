package com.hviksor.pizzaapp.presentor.screen.category

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.hviksor.pizzaapp.R

class CategoryViewHolder( // ViewHolder удобно делать вложенным классом в CategoryAdapter ( private inner class ViewHolder)
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    val btCategory = itemView.findViewById<Button>(R.id.category_item_button)

}
