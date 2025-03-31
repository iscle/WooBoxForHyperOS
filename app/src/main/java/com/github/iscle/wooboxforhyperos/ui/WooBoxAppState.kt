package com.github.iscle.wooboxforhyperos.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.map

class WooBoxAppState(
    val navController: NavHostController,
) {
    val currentRouteFlow = navController.currentBackStackEntryFlow.map {
        it.destination.route
    }

    fun navigateToHome() {
        navigate(Screen.Home)
    }

    private fun navigate(screen: Screen) {
        navController.navigate(screen.route)
    }
}

@Composable
fun rememberWooBoxAppState(
    navHostController: NavHostController = rememberNavController(),
): WooBoxAppState =
    remember(navHostController) {
        WooBoxAppState(navHostController)
    }

sealed interface Screen {
    val route: String

    data object Home : Screen {
        override val route = "home"
    }
}