package com.example.week4project

import android.os.Parcel
import android.os.Parcelable

class Address() : Parcelable {
    var number: Int = 0
    var street: String = ""
    var city: String = ""
    var postalCode : String = ""

    constructor(parcel: Parcel) : this() {
        number = parcel.readInt()
        street = parcel.readString().toString()
        city = parcel.readString().toString()
        postalCode = parcel.readString().toString()
    }

    constructor(number: Int, street: String, city: String,pc: String) : this() {
        this.number = number
        this.street = street
        this.city = city
        this.postalCode = pc
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(street)
        parcel.writeString(city)
        parcel.writeString(postalCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}