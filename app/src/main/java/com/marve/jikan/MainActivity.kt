package com.marve.jikan

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marve.jikan.view.adapters.AnimeItemAdapter
import com.marve.jikan.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    private lateinit var searchEditView: EditText
    private lateinit var searchProgressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView


    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        searchProgressBar = findViewById(R.id.pb_search)
        searchEditView = findViewById(R.id.et_search)
        recyclerView = findViewById(R.id.rv_listAnime)

        searchEditView.setOnEditorActionListener { v, actionId, event ->
            searchProgressBar.visibility = View.VISIBLE
            viewModel.searchAnimeList((v as EditText).text.toString())
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val imm = v.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
                true
            }
            else
                false
        }

        viewModel.resultAnimeSearch.observe(this) { results ->
            searchProgressBar.visibility = View.GONE
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = AnimeItemAdapter(this@MainActivity, results?.data)

            Log.d("Anime", "resultado ${results?.pagination?.currentPage}")
        }
    }
}

private fun EditText.setOnEditorActionListener(function: () -> Unit) {
    TODO("Not yet implemented")
}


