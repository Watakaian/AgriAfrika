package com.example.agriafrica.models

class Product {
    var name:String = ""
    var description:String = ""
    var price:String = ""
    var phoneno:String = ""
    var location:String = ""
    var imageUrl:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String, description: String, price: String, phoneno:String,location:String,imageUrl: String, id: String, userId: String) {
        this.name = name
        this.description = description
        this.price = price
        this.phoneno = phoneno
        this.location = location
        this.imageUrl = imageUrl
        this.id = id
        this.userId = userId
    }

    constructor()
}