package com.example.moviieapp.core.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviieapp.ui.theme.MoviieAppTheme
import com.example.moviieapp.ui.theme.black
import com.example.moviieapp.ui.theme.yellow

@Composable
fun BottommNavigationBar(
    navController: NavController
) {

    val items = listOf(
        BottomNavigation.MoviePopular,
        BottomNavigation.MovieSearch,
        BottomNavigation.MovieFavorite
    )

    BottomNavigation(
       contentColor = yellow,
        backgroundColor = black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { destination ->
            BottomNavigationItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = destination.icon, contentDescription = null)
                },
                label = {
                    Text(text = destination.title)
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    MoviieAppTheme {
        BottommNavigationBar(navController = rememberNavController())
    }
}