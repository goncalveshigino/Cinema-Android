package com.example.moviieapp.movie_popular_feature.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface  GetPopularMoviesUseCase {
    operator  fun invoke(): Flow<PagingData<Movie>>
}


class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MoviePopularRepository
): GetPopularMoviesUseCase  {

    override fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovies(
            pagingConfig = PagingConfig(
                pageSize = 5,
                initialLoadSize = 5
            )
        )
    }

}