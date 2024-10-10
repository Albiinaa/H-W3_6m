package com.geeks.h_w1_6m

import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacter(): Response<List<CharacterResponse>>
    @GET("episode")
    suspend fun getEpisode():Response<List<EpisodeResponse>>
}