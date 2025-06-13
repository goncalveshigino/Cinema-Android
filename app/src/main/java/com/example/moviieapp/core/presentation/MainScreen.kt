package com.example.moviieapp.core.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.moviieapp.core.presentation.navigation.BottommNavigationBar
import com.example.moviieapp.core.presentation.navigation.NavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottommNavigationBar(navController = navHostController)
        },
        content = {
            NavigationGraph(navController = navHostController)
        }
    )

}