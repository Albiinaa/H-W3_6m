package com.geeks.h_w1_6m

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(private val api: RickAndMortyApi) {
    suspend fun fetchCharacters(): List<CharacterResponse>? {
        return try {
            val response = api.getCharacter()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }catch (e:Exception){
            null
        }
    }
    suspend fun fetchEpisodes(): List<EpisodeResponse>? {
        return try {
            val response = api.getEpisode()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }catch (e:Exception){
            null
        }
    }
}