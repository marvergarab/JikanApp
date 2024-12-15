package com.marve.jikan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.marve.jikan.viewmodel.MainViewModel


class MainActivity : ComponentActivity() {
    private lateinit var searchEditView: EditText
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        searchEditView = findViewById(R.id.et_search)
        searchEditView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onQueryChanged(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        viewModel.results.observe(this) { results ->
            Log.d("Anime", "resultado ${results?.pagination?.currentPage}")
        }
    }
}


