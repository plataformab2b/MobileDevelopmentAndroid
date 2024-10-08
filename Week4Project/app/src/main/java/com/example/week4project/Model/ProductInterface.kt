package com.example.week4project.Model

interface ProductInterface {

    fun getProducts () : ArrayList<Product>
    fun addNewProduct(p: Product)
    fun deleteOneProduct (p: Product)
    fun updateProduct()
}