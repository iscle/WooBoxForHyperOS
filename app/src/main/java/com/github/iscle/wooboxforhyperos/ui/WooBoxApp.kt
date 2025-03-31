package com.github.iscle.wooboxforhyperos.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.iscle.wooboxforhyperos.ui.screen.HomeScreen

@Composable
fun WooBoxApp(
    wooBoxAppState: WooBoxAppState = rememberWooBoxAppState()
) {
    Route(
        wooBoxAppState = wooBoxAppState
    )
}

@Composable
private fun Route(
    wooBoxAppState: WooBoxAppState
) {
    NavHost(
        navController = wooBoxAppState.navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen()
        }
    }
}