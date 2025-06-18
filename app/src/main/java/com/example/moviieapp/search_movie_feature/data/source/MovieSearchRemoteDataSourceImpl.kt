package com.example.moviieapp.search_movie_feature.data.source

import com.example.moviieapp.core.data.remote.MovieService
import com.example.moviieapp.core.data.remote.response.SearchMovieResponse
import com.example.moviieapp.core.page.MovieSearchPagingSource
import com.example.moviieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {

    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchMovieResponse {
        return service.searchMovie(page = page, query = query)
    }

}