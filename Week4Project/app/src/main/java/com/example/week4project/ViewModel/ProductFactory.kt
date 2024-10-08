package com.example.week4project.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week4project.Model.ProductRepo

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(private val repo: ProductRepo) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)){
            return ProductViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class")
    }

}

