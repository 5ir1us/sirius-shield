package com.example.sirius_shield.presentation.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.sirius_shield.presentation.theme.AppTypography

@Composable
fun BottomNavBar(
    selectedRoute: String,
    oneItemSelected: (String) -> Unit,

    ) {
    val items = listOf(
        BottomNavItem.Info,
        BottomNavItem.Home,
        BottomNavItem.Settings
    )
    Surface(
        tonalElevation = 1.dp,
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier

            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .navigationBarsPadding()
            .border(
                2.dp,
                MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )


    ) {
        BottomNavItemsRow(
            items,
            selectedRoute,
            oneItemSelected
        )
    }
}

@Composable
fun BottomNavItemsRow(
    items: List<BottomNavItem>,
    selectedRoute: String,
    oneItemSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .heightIn(35.dp)
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        ) {
        items.forEach { item ->
            val isSelected = item.route == selectedRoute

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { oneItemSelected(item.route) }
            ) {
                LottieAnimationBottomNav(
                    item,
                    isSelected = isSelected
                )

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = stringResource(item.titleId),
                    style = AppTypography.bodyMedium,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
fun LottieAnimationBottomNav(
    item: BottomNavItem,
    isSelected: Boolean = true,
    size: Dp = 28.dp,
    iterations: Int = LottieConstants.IterateForever
) {
    val scale = when (item.route) {
        BottomNavItem.Home.route -> 1.5f
        BottomNavItem.Info.route -> 1.5f
        BottomNavItem.Settings.route -> 1f
        else -> 1f
    }
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Asset(item.icon)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isSelected,
        restartOnPlay = true,
        speed = if (isSelected) 1f else 0f,
        iterations = iterations
    )
    LottieAnimation(
        composition,
        progress = { progress },
        modifier = Modifier
            .size(size)
            .scale(scale)
            .offset(y = 2.dp) ,


    )
}


@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(
        selectedRoute = BottomNavItem.Home.route,
        oneItemSelected = {},
        )
}