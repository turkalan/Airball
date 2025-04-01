package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalAppColorScheme provides DarkColorScheme,
        LocalDimens provides compatDimens,
        LocalAppFonts provides font,
        LocalIconSize provides iconSizeDimens,
        LocalRadius provides radiusDimens,
        LocalAppTypography provides typography,
        content = content,
    )
}

object AppTheme {
    val colorScheme: AppColorScheme
        @ReadOnlyComposable
        @Composable get() = LocalAppColorScheme.current
    val dimens: Dimens
        @ReadOnlyComposable
        @Composable get() = LocalDimens.current
    val font: Font
        @ReadOnlyComposable
        @Composable get() = LocalAppFonts.current
    val iconSize: IconSize
        @ReadOnlyComposable
        @Composable get() = LocalIconSize.current
    val radius: Radius
        @ReadOnlyComposable
        @Composable get() = LocalRadius.current
    val typography: Typography
        @ReadOnlyComposable
        @Composable get() = LocalAppTypography.current

}