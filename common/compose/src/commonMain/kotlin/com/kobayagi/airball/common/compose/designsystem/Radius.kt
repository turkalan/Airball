package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val smallest: Dp,
    val small: Dp,
    val medium: Dp,
    val default: Dp,
)

internal val radiusDimens = Radius(
    smallest = 4.dp,
    small = 6.dp,
    medium = 12.dp,
    default = 18.dp,
)

@Suppress("CompositionLocalAllowlist")
internal val LocalRadius = staticCompositionLocalOf { radiusDimens }