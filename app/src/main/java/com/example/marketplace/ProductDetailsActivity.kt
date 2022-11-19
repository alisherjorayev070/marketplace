package com.example.marketplace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.marketplace.data.Data
import com.example.marketplace.data.room.entity.AboutProductItemData
import com.example.marketplace.databinding.ActivityProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
//    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    private val adapter = AboutProductDataAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutRV.adapter = adapter

        val productID = intent.getIntExtra(PRODUCT_ID, -1)

        val byID = Data.getByID(productID)
        if (byID != null) {
            binding.productID.text = "Product ID: ${byID.productId}"
            Glide.with(this)
                .load(byID.imageID)
                .into(binding.image)
            binding.name.text = byID.name
            binding.price.text = byID.price
            binding.description.text = byID.description
            val abouts = ArrayList<AboutProductItemData>()
            byID.aboutProduct?.map {
                abouts.add(AboutProductItemData(it.key, it.value))
            }
            adapter.submitList(abouts)
        }

//        viewModel.getByID(productID)
//
//        viewModel.productFlow.onEach { productEntity ->
//
//        }.launchIn(this.lifecycleScope)

    }

    companion object {
        const val PRODUCT_ID = "product_id"
    }

}