package com.marve.jikan.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marve.jikan.model.api.ApiAnimeSearchModel
import com.marve.jikan.R

class AnimeItemAdapter(private val list: List<ApiAnimeSearchModel.ApiAnimeSearchDataModel>?)
        : RecyclerView.Adapter<AnimeItemAdapter.AnimeItemViewHolder>() {

    class AnimeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tv_subtitle)
        val tvBody: TextView = itemView.findViewById(R.id.tv_body)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimeItemViewHolder {
        val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.anime_item, parent, false)
        return AnimeItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AnimeItemViewHolder,
        position: Int
    ) {
        val currentItem = list?.get(position)
        holder.tvTitle.text = currentItem?.title
        holder.tvSubtitle.text = currentItem?.titleJapanese
        holder.tvBody.text = currentItem?.synopsis
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }



}