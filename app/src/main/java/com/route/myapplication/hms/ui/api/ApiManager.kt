package com.route.myapplication.hms.ui.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object{
    private var retrofit : Retrofit?=null;

    private fun getInstance():Retrofit{
        val gson = GsonBuilder()
            .setLenient()
            .create()
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8090/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit!!;
    }
    public fun getApis():Services{
        return getInstance().create(Services::class.java);
    }
}
}