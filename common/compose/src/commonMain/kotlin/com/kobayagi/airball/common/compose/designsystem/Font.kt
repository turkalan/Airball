package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold

data class Font(val barlow: FontFamily)

internal val font = Font(
    barlow = FontFamily(
//        Font(R.font.barlow, Normal),
//        Font(R.font.barlow_medium, Medium),
//        Font(R.font.barlow_semibold, SemiBold),
//        Font(R.font.barlow_bold, Bold),
    )
)

@Suppress("CompositionLocalAllowlist")
internal val LocalAppFonts = staticCompositionLocalOf { font }