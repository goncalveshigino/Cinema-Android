package com.example.moviieapp.movie_detail_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.core.domain.model.MovieDateils
import com.example.moviieapp.movie_detail_feature.domain.repository.MovieDetailsRepository
import com.example.moviieapp.movie_detail_feature.domain.source.MovieDetailsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieDetailsRemoteDataSource
): MovieDetailsRepository {

    override suspend fun getMovieDetails(movieId: Int): MovieDateils {
        return remoteDataSource.getMovieDetails(movieId = movieId)
    }

    override suspend fun getMovieSimilar(movieId: Int, pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getSimilarMoviesPagingSource(movieId = movieId)
            }
        ).flow
    }

}