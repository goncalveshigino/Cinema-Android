package com.example.moviieapp.movie_detail_feature.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.core.domain.model.MovieDateils
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {

    suspend fun getMovieDetails(movieId: Int): MovieDateils
    suspend fun getMovieSimilar(movieId: Int, pagingConfig: PagingConfig): Flow<PagingData<Movie>>

}