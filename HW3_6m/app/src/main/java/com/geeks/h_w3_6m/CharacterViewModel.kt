package com.geeks.h_w3_6m

import androidx.lifecycle.ViewModel

class CharacterViewModel(
    private val repository: Repository
):ViewModel() {
    fun fetchCharacters()= repository.fetchCharacters()
}