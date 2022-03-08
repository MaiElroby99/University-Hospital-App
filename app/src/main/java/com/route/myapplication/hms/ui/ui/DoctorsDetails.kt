package com.route.myapplication.hms.ui.ui

class DoctorsDetails {
    val imageID: Int
    var name : String
    var nationalID : String
    var email: String
    var gender : String
    var age : Int
    var address : String
    var phone : String
    var degree : String
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
        degree: String,
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
        this.degree = degree
        this.department = department

    }
}

