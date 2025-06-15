package com.example.moviieapp.movie_popular_feature.data.mapper

import com.example.moviieapp.core.data.remote.model.MovieResult
import com.example.moviieapp.core.domain.model.Movie
import com.example.moviieapp.core.util.toPostURL

fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath?.toPostURL() ?: ""
    )
}