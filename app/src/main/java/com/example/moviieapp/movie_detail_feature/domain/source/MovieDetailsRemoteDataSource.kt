package com.example.moviieapp.movie_detail_feature.domain.source

import com.example.moviieapp.core.data.remote.response.MovieResponse
import com.example.moviieapp.core.domain.model.MovieDateils
import com.example.moviieapp.core.page.MovieSimilarPagingSource

interface MovieDetailsRemoteDataSource {

    suspend fun getMovieDetails(movieId: Int): MovieDateils
    suspend fun getMoviesSimilar(page: Int, movieId: Int): MovieResponse
    fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource

}