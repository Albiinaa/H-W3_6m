package com.geeks.h_w2_m6.network.model



import com.google.gson.annotations.SerializedName


data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)