package com.example.moviieapp.movie_popular_feature.presentation

import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.moviieapp.R
import com.example.moviieapp.movie_popular_feature.presentation.components.MovieContent
import com.example.moviieapp.movie_popular_feature.presentation.state.MoviePopularState
import com.example.moviieapp.ui.theme.black
import com.example.moviieapp.ui.theme.white

@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToMovieDetail: (Int) -> Unit,
) {

    val movies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            MovieContent(
                pagingMovies = movies,
                paddingValues = paddingValues,
                oncClick = { movieId ->
                    navigateToMovieDetail(movieId)
                }
            )
        }
    )
}