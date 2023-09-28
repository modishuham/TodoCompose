package com.example.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todocompose.screens.CreateNoteScreen
import com.example.todocompose.screens.DetailScreenMain
import com.example.todocompose.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.HOME.name) {
        composable(NavRoutes.HOME.name) {
            HomeScreen(navController)
        }
        composable(NavRoutes.CREATE_NOTE.name) {
            CreateNoteScreen(navController)
        }
        composable(NavRoutes.DETAIL.name) {
            DetailScreenMain()
        }
    }
}

enum class NavRoutes {
    HOME,
    CREATE_NOTE,
    DETAIL
}

