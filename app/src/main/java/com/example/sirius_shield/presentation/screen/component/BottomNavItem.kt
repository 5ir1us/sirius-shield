package com.example.sirius_shield.presentation.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import okhttp3.Route

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {

    data object Home : BottomNavItem("home", "Главная", Icons.Default.Home)
    data object Settings : BottomNavItem("settings", "Настройки", Icons.Default.Settings)

    @Composable
    fun BottomNavBar(navController: NavController) {
        val items = listOf(Home, Settings)
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }
        }
    }
}