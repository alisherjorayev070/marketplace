package com.example.marketplace.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.data.room.entity.ProductEntity
import com.example.marketplace.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(private val useCase: UseCase) :
    HomeViewModel, ViewModel() {

    override val productFlow = MutableStateFlow<ProductEntity?>(null)
    override val productsFlow =
        MutableSharedFlow<List<ProductEntity>>()

    override fun products() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.products().collectLatest {
                productsFlow.emit(it)
            }
        }
    }

    override fun insert(products: List<ProductEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.insert(products)
        }
    }

    override fun getByID(productID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val byID = useCase.getByID(productID)
            if (byID != null)
                productFlow.emit(byID)
        }
    }
}