package com.example.moviieapp.movie_popular_feature.domain.source

import com.example.moviieapp.core.data.remote.response.MovieResponse
import com.example.moviieapp.core.page.MoviePagingSource

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource(): MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse
}