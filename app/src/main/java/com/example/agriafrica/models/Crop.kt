package com.example.agriafrica.models

class Crop {
    var name:String = ""
    var numbers:String = ""
    var location:String = ""
    var handler:String = ""
    var imageUrl:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String, numbers: String, location: String, handler:String, imageUrl: String, id: String, userId: String) {
        this.name = name
        this.numbers = numbers
        this.location = location
        this.handler = handler
        this.imageUrl = imageUrl
        this.id = id
        this.userId = userId
    }

    constructor()
}