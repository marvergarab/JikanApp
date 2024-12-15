package com.marve.jikan.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable()
data class ApiAnimeSearchModel(
    @SerialName("pagination")   val pagination: ApiAnimeSearchPaginationModel,
    @SerialName("data")         val data:       List<ApiAnimeSearchDataModel> = listOf()
) {

    @Serializable()
    data class ApiAnimeSearchPaginationModel(
        //@SerialName("last_visible_page")    val lastVisiblePage: Int?,
        @SerialName("has_next_page")        val hasNextPage: Boolean?,
        @SerialName("current_page")         val currentPage: Int?,
        @SerialName("items")                val items: ApiAnimeSearchPaginationItemModel,
    )

    @Serializable()
    data class ApiAnimeSearchPaginationItemModel(
        @SerialName("count") val count: Int?,
        @SerialName("total") val total: Int?,
        //@SerialName("per_page") val perPage: Int?
    )

    @Serializable
    data class ApiAnimeSearchDataModel(
        @SerialName("mal_id") val malId: Int?,
        @SerialName("url") val url: String?,
        @SerialName("images") val images: ApiAnimeSearchDataImagesModel,
        //@SerialName("trailer") val trailer: ApiAnimeSearchDataTrailerModel,
        //@SerialName("approved") val approved: Boolean?,
        //@SerialName("titles") val titles: List<ApiAnimeSearchDataTitlesModel>,
        @SerialName("title") val title: String?,
        //@SerialName("title_english") val titleEnglish: String?,
        @SerialName("title_japanese") val titleJapanese: String?,
        //@SerialName("title_synonyms") val titleSynonyms: List<String>,
        @SerialName("type") val type: String?,
        @SerialName("source") val source: String?,
        @SerialName("episodes") val episodes: Int?,
        //@SerialName("status") val status: String?,
        //@SerialName("airing") val airing: Boolean?,
        //@SerialName("aired") val aired: ApiAnimeSearchDataAiredModel,
        //@SerialName("duration") val duration: String?,
        //@SerialName("rating") val rating: String?,
        //@SerialName("score") val score: Double?,
        //@SerialName("scored_by") val scoredBy: Int?,
        //@SerialName("rank") val rank: Int?,
        //@SerialName("popularity") val popularity: Int?,
        //@SerialName("members") val members: Int?,
        //@SerialName("favorites") val favorites: Int?,
        @SerialName("synopsis") val synopsis: String?,
        //@SerialName("background") val background: String?,
        //@SerialName("season") val season: String?,
        //@SerialName("year") val year: Int?,
        //@SerialName("broadcast") val broadcast: ApiAnimeSearchDataBroadcastModel,
        //@SerialName("producers") val producers: List<ApiAnimeSearchDataItemModel>,
        //@SerialName("licensors") val licensors: List<ApiAnimeSearchDataItemModel>,
        //@SerialName("explicit_genres") val explicitGenres: List<ApiAnimeSearchDataItemModel>,
        //@SerialName("themes") val themes: List<ApiAnimeSearchDataItemModel>,
        //@SerialName("demographics") val demographics: List<ApiAnimeSearchDataItemModel>
    )


    @Serializable
    data class ApiAnimeSearchDataImagesModel(
        //@SerialName("jpg") val jpg: ApiAnimeSearchDataImagesUrlModel,
        @SerialName("webp") val webp: ApiAnimeSearchDataImagesUrlModel
    )

    @Serializable
    data class ApiAnimeSearchDataImagesUrlModel(
        @SerialName("image_url") val imageUrl: String?,
        @SerialName("small_image_url") val smallImageUrl: String?,
        @SerialName("large_image_url") val largeImageUrl: String?
    )

    /*
    @Serializable
    data class ApiAnimeSearchDataTrailerModel(
        @SerialName("youtube_id") val youtubeId: String?,
        @SerialName("url") val url: String?,
        @SerialName("embed_url") val embedUrl: String?,
        @SerialName("images") val images: ApiAnimeSearchDataTrailerImagesModel
    )
    */

    @Serializable
    data class ApiAnimeSearchDataTrailerImagesModel(
        @SerialName("image_url") val imageUrl: String?,
        @SerialName("small_image_url") val smallImageUrl: String?,
        @SerialName("medium_image_url") val mediumImageUrl: String?,
        @SerialName("large_image_url") val largeImageUrl: String?,
        @SerialName("maximum_image_url") val maximumImageUrl: String?
    )

    /*
    @Serializable
    data class ApiAnimeSearchDataTitlesModel(
        @SerialName("type") val type: String?,
        @SerialName("title") val title: String?
    )
    */

    /*
    @Serializable
    data class ApiAnimeSearchDataAiredModel(
        @SerialName("from") val from: String?,
        @SerialName("to") val to: String?,
        @SerialName("prop") val prop: ApiAnimeSearchDataAiredPropModel,
        @SerialName("string")   val string: String?
    )
    */

    @Serializable
    data class ApiAnimeSearchDataAiredPropModel(
        @SerialName("from")     val from: ApiAnimeSearchDataAiredPropDateModel,
        @SerialName("to")       val to: ApiAnimeSearchDataAiredPropDateModel,
    )

    @Serializable
    data class ApiAnimeSearchDataAiredPropDateModel(
        @SerialName("day")      val day: Int?,
        @SerialName("month")    val month: Int?,
        @SerialName("year")     val year: Int?
    )

    /*
    @Serializable
    data class ApiAnimeSearchDataBroadcastModel(
        @SerialName("day")      val day: String?,
        @SerialName("time")     val time: String?,
        @SerialName("timezone") val timezone: String?,
        @SerialName("string")   val string: String?
    )
    */

    /* @Serializable
    data class ApiAnimeSearchDataItemModel(
        @SerialName("mal_id")   val malId: Int?,
        @SerialName("type")     val type: String?,
        @SerialName("name")     val name: String?,
        @SerialName("url")      val url: String?
    )*/
}
