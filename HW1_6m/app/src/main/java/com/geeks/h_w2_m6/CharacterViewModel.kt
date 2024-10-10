package com.geeks.h_w2_m6

import androidx.lifecycle.ViewModel
import com.geeks.h_w2_m6.network.CharacterRepository

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

   fun fetchCharacters() = repository.fetchCharacters()
}