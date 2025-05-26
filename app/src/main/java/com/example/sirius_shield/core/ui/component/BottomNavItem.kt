package com.example.sirius_shield.core.ui.component

import androidx.annotation.StringRes
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