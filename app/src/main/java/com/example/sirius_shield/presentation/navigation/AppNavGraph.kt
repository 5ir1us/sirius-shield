package com.example.sirius_shield.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sirius_shield.presentation.screen.component.BottomNavItem.Home.BottomNavBar
import com.example.sirius_shield.presentation.screen.home.HomeScreen
import com.example.sirius_shield.presentation.screen.settings.SettingsScreen

@Composable
fun AppNavGraph( ) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
        }
    }
}