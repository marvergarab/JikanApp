package com.marve.jikan.viewmodel

import android.util.Log
import androidx.compose.foundation.pager.PageInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.marve.jikan.api.AnimeClient
import com.marve.jikan.model.api.ApiAnimeSearchModel
import com.marve.jikan.model.api.ApiAnimeSearchModel.ApiAnimeSearchDataModel
import com.marve.jikan.model.api.ApiAnimeSearchModel.ApiAnimeSearchPaginationModel
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {
    var resultAnimeSearch: MutableLiveData<List<ApiAnimeSearchDataModel>> = MutableLiveData()
    private var pageInfo: ApiAnimeSearchPaginationModel? = null
    private var currentSearchStr = ""
    private var isRunningQuery = false



    fun searchAnimeList(qString: String)  {
        if (currentSearchStr != qString) {
            pageInfo = null
            currentSearchStr = qString
        }

        if (isRunningQuery)
            return

        isRunningQuery = true

        viewModelScope.launch {
            try {
                var page: Int? = null
                if (pageInfo != null && pageInfo?.hasNextPage != null && pageInfo?.hasNextPage == false) {
                    isRunningQuery = false
                    return@launch
                }

                if (pageInfo?.hasNextPage == true)
                    page = pageInfo?.currentPage?.plus(1)

                val response =
                    AnimeClient.animeService.getAnimeList(searchStr = qString, page = page)
                if (response.isSuccessful) {
                    resultAnimeSearch.value = response.body()?.data
                    pageInfo = response.body()?.pagination
                    Log.d("pagina", "pageinfo: $pageInfo")

                } else
                    resultAnimeSearch.value = listOf()
            }
            catch (e: Exception) {
                Log.w("MainViewModel", "Exception: ${e.message}")
                resultAnimeSearch.value = listOf()
            }

            isRunningQuery = false
        }
    }
}