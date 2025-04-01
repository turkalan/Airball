package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Suppress("MagicNumber")
object AppColors {
    val Transparent = Color(0x00000000)
    val White = Color(0xFFFFFFFF)
    val Black = Color(0xFF000000)
}

data class AppColorScheme(
    val primary: Color = Color.Unspecified,
    val onPrimary: Color = Color.Unspecified,
    val secondary: Color = Color.Unspecified,
    val onSecondary: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val onBackground: Color = Color.Unspecified,
    val error: Color = Color.Unspecified,
    val success: Color = Color.Unspecified,
)

internal val DarkColorScheme = AppColorScheme(
    primary = AppColors.Black,
    onPrimary = AppColors.White,
    secondary = AppColors.Black,
    onSecondary = AppColors.White,
    background = AppColors.Black,
    onBackground = AppColors.White,
    error = Color.Red,
    success = Color.Green,
)

internal val LightColorScheme = AppColorScheme(
    primary = AppColors.White,
    onPrimary = AppColors.Black,
    secondary = AppColors.White,
    onSecondary = AppColors.Black,
    background = AppColors.White,
    onBackground = AppColors.Black,
    error = Color.Red,
    success = Color.Green,
)

@Suppress("CompositionLocalAllowlist")
internal val LocalAppColorScheme = staticCompositionLocalOf { AppColorScheme() }