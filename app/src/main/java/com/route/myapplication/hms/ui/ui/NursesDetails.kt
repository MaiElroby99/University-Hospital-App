package com.route.myapplication.hms.ui.ui

class NursesDetails {
    val imageID: Int
    var name : String
    var nationalID : String
    var email: String
    var gender : String
    var age : Int
    var address : String
    var phone : String
    var department : String


    constructor(
        imageID: Int,
        name: String,
        nationalID: String,
        email: String,
        gender: String,
        age: Int,
        address: String,
        phone: String,
        department: String,
    ) {
        this.imageID = imageID
        this.name = name
        this.nationalID = nationalID
        this.email = email
        this.gender = gender
        this.age = age
        this.address = address
        this.phone = phone
        this.department = department

    }
}

