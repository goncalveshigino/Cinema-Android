package com.example.moviieapp.search_movie_feature.data.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviieapp.core.domain.model.MovieSearch
import com.example.moviieapp.search_movie_feature.domain.repository.MovieSearchRepository
import com.example.moviieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieSearchRemoteDataSource
): MovieSearchRepository {

    override fun getSearchMovies(query: String, pagingConfig: PagingConfig): Flow<PagingData<MovieSearch>> {
        TODO("Not yet implemented")
    }

}