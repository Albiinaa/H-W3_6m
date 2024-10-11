package com.geeks.h_w3_6m
import retrofit2.Call
import retrofit2.http.GET
interface ApiService {

 @GET
 fun fetchCharacters(): Call<List<Character>>
}