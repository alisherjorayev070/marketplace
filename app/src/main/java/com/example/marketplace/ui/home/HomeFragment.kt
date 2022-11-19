package com.example.marketplace.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.marketplace.ProductDetailsActivity
import com.example.marketplace.ProductDetailsActivity.Companion.PRODUCT_ID
import com.example.marketplace.TAG
import com.example.marketplace.data.Data
import com.example.marketplace.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

const val TAG = "HomeFragment"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private val productsAdapter = ProductsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rv.adapter = productsAdapter

        val products = Data.getProducts()
        productsAdapter.submitList(products)

//        viewModel.products()
//
//        viewModel.productsFlow.onEach {
//            productsAdapter.submitList(it)
//            Log.d(TAG, "list: $it")
//        }.launchIn(viewLifecycleOwner.lifecycleScope)

        productsAdapter.onItemClickListener {
            val intent = Intent(requireActivity(), ProductDetailsActivity::class.java)
            intent.putExtra(PRODUCT_ID, it.productId)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}