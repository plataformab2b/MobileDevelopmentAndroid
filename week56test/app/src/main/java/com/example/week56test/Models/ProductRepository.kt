package com.example.week56test.Models

class ProductRepository:ProductInterface {
    var list = ArrayList<Product>()

    // from db or from the web
    override fun getInitProducts(): ArrayList<Product> {
        list.add(    Product(1, "Hats", 40, 10.4))
        list.add(
            Product(2, "Tshirts", 50, 19.9))
        list.add(
            Product(3, "Pants", 30, 35.9))
        return list
    }

    override fun addNewProduct(p: Product):  ArrayList<Product> {
            list.add(p)
            return list
    }


}