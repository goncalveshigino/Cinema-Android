package com.example.moviieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviieapp.movie_popular_feature.presentation.MoviePopularScreen
import com.example.moviieapp.movie_popular_feature.presentation.MoviePopularViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviieapp.search_movie_feature.presentation.MovieSearchEvents
import com.example.moviieapp.search_movie_feature.presentation.MovieSearchScreen
import com.example.moviieapp.search_movie_feature.presentation.MovieSearchViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigation.MoviePopular.route
    ) {
        composable(BottomNavigation.MoviePopular.route) {

            val viewModel: MoviePopularViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            MoviePopularScreen(
                uiState = uiState,
                navigateToMovieDetail = { movieId ->
                   // navController.navigate("movieDetail/$movieId")
                }
            )
        }

        composable(BottomNavigation.MovieSearch.route) {

            val viewModel: MovieSearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            val onEvent: (MovieSearchEvents) -> Unit = viewModel::event
            val onFetch: (String) -> Unit = viewModel::fetch

            MovieSearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFectch = onFetch,
                navigateToDetailMovie = { movieId ->
                   // navController.navigate("movieDetail/$movieId")
                }
            )
        }

        composable(BottomNavigation.MovieFavorite.route) {

        }
    }
}
