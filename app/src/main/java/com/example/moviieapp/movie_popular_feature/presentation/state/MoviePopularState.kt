package com.example.moviieapp.movie_popular_feature.presentation.state

import androidx.paging.PagingData
import com.example.moviieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviePopularState(
    val movies: Flow<PagingData<Movie>> = emptyFlow(),
//    val isLoading: Boolean = false,
//    val error: String? = null
)
