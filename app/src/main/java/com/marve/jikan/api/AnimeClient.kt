package com.marve.jikan.api

import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitBuilder {
    private val baseUrl = "https://api.jikan.moe/v4/"
    val networkJson = Json { ignoreUnknownKeys = true }
    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {
        if (!this::retrofit.isInitialized) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()


            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
                .client(client)
                .build()
        }

        return retrofit
    }
}


object AnimeClient {
    val animeService: AnimeServiceI by lazy {
        RetrofitBuilder.getRetrofit().create(AnimeServiceI::class.java)
    }
}