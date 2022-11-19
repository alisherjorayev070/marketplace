package com.example.marketplace.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.data.room.entity.CategoryEntity
import com.example.marketplace.databinding.ItemCategoryBinding

class CategoriesAdapter : ListAdapter<CategoryEntity, CategoriesAdapter.VH>(Comparator) {

    private var onItemClickListener: ((CategoryEntity) -> Unit)? = null

    fun onItemClickListener(block: (CategoryEntity) -> Unit) {
        onItemClickListener = block
    }

    inner class VH(private val itemBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = getItem(position)

            itemBinding.root.setOnClickListener {
                onItemClickListener?.invoke(getItem(position))
            }

            itemBinding.name.text = item.name
        }
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    object Comparator : DiffUtil.ItemCallback<CategoryEntity>() {
        override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem.categoryID == newItem.categoryID
        }

        override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem == newItem
        }
    }
}