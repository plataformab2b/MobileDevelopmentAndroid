package com.example.week56test.Models

import android.os.Parcel
import android.os.Parcelable

class Product() :Parcelable {
    var id : Int = 0
    var name: String = ""
    var quantity: Int = 0
    var price: Double = 0.0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString().toString()
        quantity = parcel.readInt()
        price = parcel.readDouble()
    }

    constructor(id: Int, name: String, q: Int, p: Double) : this() {
        this.id = id
        this.price = p
        this.quantity = q
        this.name = name
    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(quantity)
        parcel.writeDouble(price)
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }


}

