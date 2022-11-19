package com.example.marketplace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.data.room.entity.AboutProductItemData
import com.example.marketplace.databinding.ItemAboutProductDataBinding

class AboutProductDataAdapter :
    ListAdapter<AboutProductItemData, AboutProductDataAdapter.VH>(Comparator) {

    private var onItemClickListener: ((AboutProductItemData) -> Unit)? = null

    fun onItemClickListener(block: (AboutProductItemData) -> Unit) {
        onItemClickListener = block
    }

    inner class VH(private val itemBinding: ItemAboutProductDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = getItem(position)

            itemBinding.root.setOnClickListener {
                onItemClickListener?.invoke(getItem(position))
            }

            itemBinding.key.text = item.key
            itemBinding.value.text = item.value
        }
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            ItemAboutProductDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    object Comparator : DiffUtil.ItemCallback<AboutProductItemData>() {
        override fun areItemsTheSame(
            oldItem: AboutProductItemData,
            newItem: AboutProductItemData
        ): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(
            oldItem: AboutProductItemData,
            newItem: AboutProductItemData
        ): Boolean {
            return oldItem == newItem
        }
    }
}