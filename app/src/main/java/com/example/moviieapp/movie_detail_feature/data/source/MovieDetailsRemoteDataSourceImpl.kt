package com.example.moviieapp.movie_detail_feature.data.source

import com.example.moviieapp.core.data.remote.MovieService
import com.example.moviieapp.core.data.remote.response.MovieResponse
import com.example.moviieapp.core.domain.model.MovieDateils
import com.example.moviieapp.core.page.MovieSimilarPagingSource
import com.example.moviieapp.core.util.toBackdropUrl
import com.example.moviieapp.movie_detail_feature.domain.source.MovieDetailsRemoteDataSource
import javax.inject.Inject

class MovieDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
): MovieDetailsRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int): MovieDateils {
        val response = service.getMovie(movieId)
        val genres = response.genres.map { it.name }

        return MovieDateils(
            id = response.id,
            title = response.title,
            overview = response.overview,
            genres = genres,
            backdropPathUrl = response.backdropPath.toBackdropUrl(),
            realseDate = response.releaseDate,
            voteAverage = response.voteAverage,
            vouteCount = response.voteCount
        )
    }

    override suspend fun getMoviesSimilar(page: Int, movieId: Int): MovieResponse {
       return service.getMoviesSimilar(page = page, movieId = movieId)
    }

    override fun getSimilarMoviesPagingSource(movieId: Int): MovieSimilarPagingSource {
        return MovieSimilarPagingSource(this, movieId)
    }

}