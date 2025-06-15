package com.example.moviieapp.movie_popular_feature.data.source

import com.example.moviieapp.core.data.remote.MovieService
import com.example.moviieapp.core.data.remote.response.MovieResponse
import com.example.moviieapp.core.page.MoviePagingSource
import com.example.moviieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImp @Inject constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource  {

    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page)
    }

}