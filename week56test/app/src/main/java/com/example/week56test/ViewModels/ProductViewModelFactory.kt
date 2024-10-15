package com.example.week56test.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week56test.Models.ProductRepository

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(private val repo: ProductRepository) :
    ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(ProductViewModel::class.java)){
           return ProductViewModel() as T
       }
        throw IllegalArgumentException("Unknow")

    }

}