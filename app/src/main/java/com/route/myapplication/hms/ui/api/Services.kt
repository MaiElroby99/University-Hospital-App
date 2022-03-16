package com.route.myapplication.hms.ui.api

import com.route.myapplication.hms.ui.api.Model.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Services {
    @POST("api/Authentication/login")
    fun userLogin(@Body loginRequest:LoginRequest): Call<String>

}