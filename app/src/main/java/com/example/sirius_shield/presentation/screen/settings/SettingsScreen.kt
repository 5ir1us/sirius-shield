package com.example.sirius_shield.presentation.screen.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun SettingsScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("⚙️ Это настройки", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Назад на главный")
            }
        }
    }
}