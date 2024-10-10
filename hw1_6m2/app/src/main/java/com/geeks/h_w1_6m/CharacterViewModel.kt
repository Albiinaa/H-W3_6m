package com.geeks.h_w1_6m

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository):ViewModel() {
    private val _characters = MutableLiveData<List<CharacterResponse>>()
    val characters: LiveData<List<CharacterResponse>> get() = _characters
    private val _episodes = MutableLiveData<List<EpisodeResponse>>()
    val episodes: LiveData<List<EpisodeResponse>> get() = _episodes
    fun fetchCharacters() {
        viewModelScope.launch() {
                val result = repository.fetchCharacters()
                result?.let { _characters.postValue(it) }
        }
    }
    fun fetchEpisodes() {
        viewModelScope.launch {
            val result = repository.fetchEpisodes()
            result?.let { _episodes.postValue(it) }
        }
    }
}