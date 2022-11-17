package com.example.marketplace.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marketplace.data.room.entity.ProductEntity
import com.example.marketplace.databinding.ItemProductBinding

class ProductsAdapter : ListAdapter<ProductEntity, ProductsAdapter.VH>(Comparator) {

    private var onItemClickListener: ((ProductEntity) -> Unit)? = null

    fun onItemClickListener(block: (ProductEntity) -> Unit) {
        onItemClickListener = block
    }

    inner class VH(private val itemBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = getItem(position)

            itemBinding.root.setOnClickListener {
                onItemClickListener?.invoke(getItem(position))
            }

            Glide.with(itemBinding.root)
                .load(item.imageID)
                .into(itemBinding.image)
        }
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    object Comparator : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }
    }
}