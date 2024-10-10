package com.geeks.h_w2_m6.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geeks.h_w2_m6.network.model.BaseResponse
import com.geeks.h_w2_m6.network.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository (
    private val api: ApiService? = RetrofitInstance.api
) {
    fun fetchCharacters(): LiveData<List<Characters>> {
        val data = MutableLiveData<List<Characters>>()
        api?.fetchCharacters()?.enqueue(object : Callback<BaseResponse> {
            override fun onResponse(p0: Call<BaseResponse>, response: Response<BaseResponse>) {
                data.postValue(response.body()!!.characters)
            }

            override fun onFailure(p0: Call<BaseResponse>, p1: Throwable) {
                print(p1.localizedMessage)
            }

        })
       return data

    }
}

