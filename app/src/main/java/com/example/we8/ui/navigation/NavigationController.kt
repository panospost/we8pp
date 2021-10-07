package com.example.we8.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.we8.ui.screens.FirstScreen.FirstScreen
import com.example.we8.ui.screens.WebView.WebPageScreen
import com.example.we8.utils.Constants

@Composable
fun ComposeNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("webview/{url}",
            arguments = listOf(navArgument("url"){
                type = NavType.StringType
                defaultValue = Constants.WEB_VIEW_DEFAULT_URL
            })
        ) { backStackEntry ->
            WebPageScreen(backStackEntry.arguments?.getString("url"))
        }
    }
}