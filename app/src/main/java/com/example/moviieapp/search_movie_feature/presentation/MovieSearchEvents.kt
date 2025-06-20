package com.example.moviieapp.search_movie_feature.presentation

sealed class MovieSearchEvents {
    data class  EnteredQuery(val value: String) : MovieSearchEvents()
}