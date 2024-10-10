package com.geeks.h_w2_m6.network

object RetrofitInstance {
    private val retrofit by lazy {

    }
    val api by lazy {
        retrofit.create(ApiService::class.java)
    }
}