package com.geeks.h_w2_m6.network.model

import com.google.gson.annotations.SerializedName




data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)