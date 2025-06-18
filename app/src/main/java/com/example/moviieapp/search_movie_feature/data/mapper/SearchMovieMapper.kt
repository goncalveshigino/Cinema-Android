package com.example.moviieapp.search_movie_feature.data.mapper

import com.example.moviieapp.core.data.remote.model.SearchResult
import com.example.moviieapp.core.domain.model.MovieSearch
import com.example.moviieapp.core.util.toPostUrl


fun List<SearchResult>.toSearchMovie() = map { searchResult ->
    MovieSearch(
        id = searchResult.id,
        voteAverage = searchResult.voteAverage,
        imageUrl = searchResult.posterPath?.toPostUrl() ?: ""
    )
}