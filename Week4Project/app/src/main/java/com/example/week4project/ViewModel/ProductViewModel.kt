package com.example.week4project.ViewModel

import androidx.lifecycle.ViewModel
import com.example.week4project.Model.Product
import com.example.week4project.Model.ProductRepo

class ProductViewModel(private val productRepo: ProductRepo) : ViewModel() {


    fun getListOfProducts(): ArrayList<Product>{
       return productRepo.getProducts()
    }


}