package com.example.week56test.ViewModels

import androidx.lifecycle.ViewModel
import com.example.week56test.Models.Product
import com.example.week56test.Models.ProductRepository

class ProductViewModel(var repo: ProductRepository)
    : ViewModel() {
    fun getProducts() : ArrayList<Product>{
        return repo.getProducts()
    }
    fun addNewProduct(p: Product) {
        repo.addNewProduct(p)
    }
}