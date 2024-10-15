package com.example.week56test.Models

interface ProductInterface {
    fun getInitProducts() :  ArrayList<Product>
    fun addNewProduct(p: Product):  ArrayList<Product>
    // delete Product
    // update Product
}