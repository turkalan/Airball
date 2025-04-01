package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class IconSize(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
)

internal val iconSizeDimens = IconSize(
    small = 16.dp,
    medium = 24.dp,
    large = 32.dp,
)

@Suppress("CompositionLocalAllowlist")
internal val LocalIconSize = staticCompositionLocalOf { iconSizeDimens }

