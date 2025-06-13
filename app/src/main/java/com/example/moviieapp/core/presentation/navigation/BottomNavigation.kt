package com.example.moviieapp.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigation(val title: String, val icon: ImageVector, val route: String){
    object MoviePopular: BottomNavigation(
        title = "Popular",
        icon = Icons.Default.Movie,
        route = "movie_popular_screen"
    )

    object MovieSearch : BottomNavigation(
        title = "Pesquisar",
        icon = Icons.Default.Search,
        route = "movie_search_screen"
    )

    object MovieFavorite : BottomNavigation(
        title = "Favoritos",
        icon = Icons.Default.Favorite,
        route = "movie_favorite_screen"
    )
}
