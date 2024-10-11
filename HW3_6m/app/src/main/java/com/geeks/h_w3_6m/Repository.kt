package com.geeks.h_w3_6m

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(
    private val api:ApiService
) {
    fun fetchCharacters(): LiveData<Resource<List<Character>>> {
        val data = MutableLiveData<Resource<List<Character>>>()
        data.postValue(Resource.Loading())
        api.fetchCharacters().enqueue(object : Callback<List<Character>>{
            override fun onResponse(
                call: Call<List<Character>>,
                response:Response<List<Character>>) {
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(Resource.Success(response.body()!!))
                }
            }

            override fun onFailure(p0: Call<List<Character>>, t: Throwable) {
                data.postValue(Resource.Error(t.localizedMessage?:"Unknown error"))
            }
        })
        return data
    }
}