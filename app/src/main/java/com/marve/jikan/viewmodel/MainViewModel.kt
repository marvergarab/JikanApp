package com.marve.jikan.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.marve.jikan.api.AnimeClient
import com.marve.jikan.model.api.ApiAnimeSearchModel
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {

    private var debounceJob: Job? = null
    private val _query = MutableLiveData<String?>()

    val results: LiveData<ApiAnimeSearchModel?> = _query.switchMap { query ->
        liveData{
            try {
                val response = AnimeClient.animeService.getAnimeList(searchStr = query)
                if (response.isSuccessful)
                    emit(response.body())
                else
                    emit(null)
            }
            catch (e: Exception) {
                Log.w("MainViewModel", "Exception: ${e.message}")
                emit(null)
            }
        }
    }

    fun onQueryChanged(newText: String) {
        debounceJob?.cancel()
        debounceJob = viewModelScope.launch {
            delay(1000) // Aplica el debounce
            val text = if (newText.isEmpty()) null else newText
            _query.postValue(text)
        }
    }
}