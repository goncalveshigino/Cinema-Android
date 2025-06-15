package com.example.moviieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviieapp.movie_popular_feature.presentation.MoviePopularScreen
import com.example.moviieapp.movie_popular_feature.presentation.MoviePopularViewModel
import androidx.hilt.navigation.compose.hiltViewModel

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

        }

        composable(BottomNavigation.MovieFavorite.route) {

        }
    }
}
