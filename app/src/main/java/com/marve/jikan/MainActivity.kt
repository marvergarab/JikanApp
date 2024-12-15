package com.marve.jikan

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.marve.jikan.api.AnimeClient
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        lifecycleScope.launch{
            try {
                val ans = AnimeClient.animeService.getAnimeList(searchStr = "Conan")
                Log.d("Anime", "Ok")
                Log.d("anime", "${ans.code()}")
                Log.d("Anime", "${ans.body()?.pagination}")
                Log.d("Anime", "num datos ${ans.body()?.data?.size}")
            }
            catch (e: Exception) {
                Log.w("Anime", "${e.message}")
            }
        }
    }
}

