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
    var resultAnimeSearch: MutableLiveData<ApiAnimeSearchModel?> = MutableLiveData()

    fun searchAnimeList(qString: String)  {
        viewModelScope.launch {
            try {
                val response = AnimeClient.animeService.getAnimeList(searchStr = qString)
                resultAnimeSearch.value = if (response.isSuccessful) response.body() else null
            }
            catch (e: Exception) {
                Log.w("MainViewModel", "Exception: ${e.message}")
                resultAnimeSearch.value = null
            }
        }
    }
}