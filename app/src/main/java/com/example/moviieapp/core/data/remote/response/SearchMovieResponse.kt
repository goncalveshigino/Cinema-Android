package com.example.moviieapp.core.data.remote.response

import com.example.moviieapp.core.data.remote.model.SearchResult

data class SearchMovieResponse(
    val page: Int,
    val results: List<SearchResult>,
    val total_pages: Int,
    val total_results: Int
)