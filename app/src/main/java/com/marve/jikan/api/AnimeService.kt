package com.marve.jikan.api

import com.marve.jikan.model.api.ApiAnimeSearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {
    @GET("anime")
    suspend fun getAnimeList(@Query("page") page: Int? = null,
                             @Query("q") searchStr: String? = null): Response<ApiAnimeSearchModel>

}