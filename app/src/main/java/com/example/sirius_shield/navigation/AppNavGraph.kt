package com.example.sirius_shield.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sirius_shield.R
import com.example.sirius_shield.core.ui.component.AppTopBar
import com.example.sirius_shield.core.ui.component.BottomNavBar
import com.example.sirius_shield.features.home.presentation.HomeScreen
import com.example.sirius_shield.features.info.presentation.InfoScreen
import com.example.sirius_shield.features.settings.presentation.SettingsScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "main"

    Scaffold(
        topBar = {
            when (currentRoute){
                "main" ->  AppTopBar(R.string.app_name)
                "settings" ->  AppTopBar(R.string.bottom_nav_item_settings)
            }

        },

        bottomBar = {
            BottomNavBar(
                selectedRoute = currentRoute,
                oneItemSelected = { route ->
                    if (route != currentRoute) {
                        navController.navigate(route) {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "main",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("main") { HomeScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("personal") { InfoScreen(navController) }
        }
    }
}