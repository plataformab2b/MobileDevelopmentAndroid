package com.example.week56test.Models

interface ProductInterface {
    fun getProducts() :  ArrayList<Product>
    fun addNewProduct(p: Product)
}