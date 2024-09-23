package com.geeks.hw_2_5m

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.PUT

class MainPresenter {
    private val api = RetrofitService.api


    fun getPercentage(){
        api.getPercentage("X-Rapidapi-Key", "X-Rapidapi-Host",).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, p1: Response<LoveModel>) {

            }

            override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {

            }

        }

        )
    }
}