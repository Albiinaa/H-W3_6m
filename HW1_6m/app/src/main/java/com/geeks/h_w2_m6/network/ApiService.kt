package com.geeks.h_w2_m6.network
import retrofit2.Call
import com.geeks.h_w2_m6.network.model.BaseResponse
import retrofit2.http.GET

interface ApiService {
@GET("characters")
 fun fetchCharacters(): Call<BaseResponse>

}