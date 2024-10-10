package com.geeks.h_w2_m6.network.model



import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Characters>
)