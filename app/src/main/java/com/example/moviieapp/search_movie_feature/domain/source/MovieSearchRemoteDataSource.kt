package com.example.moviieapp.search_movie_feature.domain.source

import com.example.moviieapp.core.data.remote.response.SearchMovieResponse
import com.example.moviieapp.core.page.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource
    suspend fun getSearchMovies(page: Int, query: String): SearchMovieResponse
}