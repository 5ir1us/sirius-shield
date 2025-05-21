package com.example.sirius_shield.presentation.screen.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.airbnb.lottie.Lottie
import com.example.sirius_shield.R

sealed class BottomNavItem(
    internal val route: String,
    @StringRes val titleId: Int,
     val icon: String
) {
    data object Settings : BottomNavItem("settings", R.string.bottom_nav_item_settings,"lottie/SettingNavBarAnimation.json" )
    data object Home : BottomNavItem("main", R.string.bottom_nav_item_home, "lottie/MainNavBarAnimation.json")
    data object Info : BottomNavItem("personal", R.string.bottom_nav_item_info, "lottie/ButtonActivateVpnFire.json")
}