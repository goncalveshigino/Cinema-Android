package com.example.moviieapp.search_movie_feature.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.moviieapp.R
import com.example.moviieapp.search_movie_feature.presentation.components.SearchContent
import com.example.moviieapp.search_movie_feature.presentation.state.MovieSearchState
import com.example.moviieapp.ui.theme.black
import com.example.moviieapp.ui.theme.white

@Composable
fun MovieSearchScreen(
    uiState: MovieSearchState,
    onEvent: (MovieSearchEvents) -> Unit,
    onFectch: (String) -> Unit,
    navigateToDetailMovie: (Int) -> Unit
) {

    val pagingMovies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.search_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValues ->
            SearchContent(
                paddingValues = paddingValues,
               // pagingMovies = pagingMovies,
                query = uiState.query,
                onSearch = {
                    onFectch(it)
                },
                onEvent = {
                    onEvent(it)
                },
                onDetail = { movieId ->
                    navigateToDetailMovie(movieId)
                },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    )
}

@Preview
@Composable
private fun MovieSearchScreenPreview() {
    MovieSearchScreen(
        uiState = MovieSearchState(),
        onEvent = {},
        onFectch = {},
        navigateToDetailMovie = {}
    )
}
