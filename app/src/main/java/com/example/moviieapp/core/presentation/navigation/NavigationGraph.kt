package com.example.moviieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigation.MoviePopular.route
    ) {
        composable(BottomNavigation.MoviePopular.route) {

        }

        composable(BottomNavigation.MovieSearch.route) {

        }

        composable(BottomNavigation.MovieFavorite.route) {

        }
    }
}
