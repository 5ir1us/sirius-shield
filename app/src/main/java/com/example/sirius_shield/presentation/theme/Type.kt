package com.example.sirius_shield.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.sirius_shield.R

val InterFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_bold, FontWeight.Bold)
)

val base = Typography()

val AppTypography = Typography(
    displayLarge = base.displayLarge.copy(fontFamily = InterFont),
    displayMedium = base.displayMedium.copy(fontFamily = InterFont),
    displaySmall = base.displaySmall.copy(fontFamily = InterFont),
    headlineLarge = base.headlineLarge.copy(fontFamily = InterFont),
    headlineMedium = base.headlineMedium.copy(fontFamily = InterFont),
    headlineSmall = base.headlineSmall.copy(fontFamily = InterFont),
    titleLarge = base.titleLarge.copy(fontFamily = InterFont), //Заголовки экранов, секций
    titleMedium = base.titleMedium.copy(fontFamily = InterFont),
    titleSmall = base.titleSmall.copy(fontFamily = InterFont),
    bodyLarge = base.bodyLarge.copy(fontFamily = InterFont),
    bodyMedium = base.bodyMedium.copy(fontFamily = InterFont), //Обычный текст
    bodySmall = base.bodySmall.copy(fontFamily = InterFont), //Подсказки, примечания
    labelLarge = base.labelLarge.copy(fontFamily = InterFont), //Кнопки
    labelMedium = base.labelMedium.copy(fontFamily = InterFont),
    labelSmall = base.labelSmall.copy(fontFamily = InterFont), //Мелкие подписи, Chips
)
