package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val zero: Dp,
    val smallest: Dp,
    val small: Dp,
    val half: Dp,
    val medium: Dp,
    val default: Dp,
    val big: Dp,
    val veryBig: Dp,
    val double: Dp,
    val extra: Dp,
)

internal val compatDimens = Dimens(
    zero = 0.dp,
    smallest = 4.dp,
    small = 6.dp,
    half = 10.dp,
    medium = 16.dp,
    default = 20.dp,
    big = 24.dp,
    veryBig = 30.dp,
    double = 40.dp,
    extra = 60.dp,
)

@Suppress("CompositionLocalAllowlist")
internal val LocalDimens = staticCompositionLocalOf { compatDimens }