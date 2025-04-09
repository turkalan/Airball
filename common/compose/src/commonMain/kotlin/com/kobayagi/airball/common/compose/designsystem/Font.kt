package com.kobayagi.airball.common.compose.designsystem

import airball.common.compose.generated.resources.Res
import airball.common.compose.generated.resources.barlow
import airball.common.compose.generated.resources.barlow_bold
import airball.common.compose.generated.resources.barlow_medium
import airball.common.compose.generated.resources.barlow_semibold
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
//        Font(Res.font.barlow, Normal),
//        Font(Res.font.barlow_medium, Medium),
//        Font(Res.font.barlow_semibold, SemiBold),
//        Font(Res.font.barlow_bold, Bold),]
    )
)

@Suppress("CompositionLocalAllowlist")
internal val LocalAppFonts = staticCompositionLocalOf { font }