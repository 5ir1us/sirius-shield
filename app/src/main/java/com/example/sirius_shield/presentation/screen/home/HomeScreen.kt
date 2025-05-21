package com.example.sirius_shield.presentation.screen.home


import android.app.Activity
import android.graphics.Color
import android.view.WindowInsetsController
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    StatusBar()

}

@Composable
fun StatusBar() {

}

@Preview(showBackground = true)
@Composable

fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}
