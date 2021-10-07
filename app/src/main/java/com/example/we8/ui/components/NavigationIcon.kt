package com.example.we8.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationIcon (navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        "first_screen" -> {
        }

        else ->
            IconButton(onClick = { navHostController.navigate("first_screen") }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
    }
}