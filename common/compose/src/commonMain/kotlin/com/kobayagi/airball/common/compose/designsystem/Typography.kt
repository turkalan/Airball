package com.kobayagi.airball.common.compose.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.sp
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_LARGE
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_MEDIUM
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_MEDIUM_DEFAULT
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_MEDIUM_LARGE
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_MEDIUM_SMALL
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_SMALL
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_VERY_LARGE
import com.kobayagi.airball.common.compose.constants.TextSizeConstants.TEXT_SIZE_VERY_SMALL
import com.kobayagi.airball.common.compose.designsystem.AppColors.White

data class Typography(
    val boldVeryLarge: TextStyle,
    val boldLarge: TextStyle,
    val boldMediumLarge: TextStyle,
    val boldMediumDefault: TextStyle,
    val boldMedium: TextStyle,
    val boldMediumSmall: TextStyle,
    val boldSmall: TextStyle,
    val semiboldMediumLarge: TextStyle,
    val semiboldMediumDefault: TextStyle,
    val semiboldMedium: TextStyle,
    val semiboldSmall: TextStyle,
    val semiboldVerySmall: TextStyle,
    val mediumMedium: TextStyle,
    val mediumVerySmall: TextStyle,
    val regularMedium: TextStyle,
    val regularSmall: TextStyle,
    val regularVerySmall: TextStyle,
    val regularMediumSmall: TextStyle,
)

internal val typography = Typography(
    boldVeryLarge = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_VERY_LARGE.sp,
        color = White,
    ),
    boldMediumLarge = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_MEDIUM_LARGE.sp,
        color = White,
    ),
    boldLarge = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_LARGE.sp,
        color = White,
    ),
    boldMediumDefault = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_MEDIUM_DEFAULT.sp,
        color = White,
    ),
    boldMedium = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_MEDIUM.sp,
        color = White,
    ),
    boldMediumSmall = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_MEDIUM_SMALL.sp,
    ),
    boldSmall = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Bold,
        fontSize = TEXT_SIZE_SMALL.sp,
        color = White,
    ),
    semiboldMediumLarge = TextStyle(
        fontFamily = font.barlow,
        fontWeight = SemiBold,
        fontSize = TEXT_SIZE_MEDIUM_LARGE.sp,
        color = White,
    ),
    semiboldMediumDefault = TextStyle(
        fontFamily = font.barlow,
        fontWeight = SemiBold,
        fontSize = TEXT_SIZE_MEDIUM_DEFAULT.sp,
        color = White,
    ),
    semiboldMedium = TextStyle(
        fontFamily = font.barlow,
        fontWeight = SemiBold,
        fontSize = TEXT_SIZE_MEDIUM.sp,
        color = White,
    ),
    semiboldSmall = TextStyle(
        fontFamily = font.barlow,
        fontWeight = SemiBold,
        fontSize = TEXT_SIZE_SMALL.sp,
        color = White,
    ),
    semiboldVerySmall = TextStyle(
        fontFamily = font.barlow,
        fontWeight = SemiBold,
        fontSize = TEXT_SIZE_VERY_SMALL.sp,
        color = White,
    ),
    mediumMedium = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Medium,
        fontSize = TEXT_SIZE_MEDIUM.sp,
    ),
    mediumVerySmall = TextStyle(
        fontFamily = font.barlow,
        fontWeight = Medium,
        fontSize = TEXT_SIZE_VERY_SMALL.sp,
        color = White,
    ),
    regularMedium = TextStyle(
        fontFamily = font.barlow,
        fontSize = TEXT_SIZE_MEDIUM.sp,
        color = White,
    ),
    regularSmall = TextStyle(
        fontFamily = font.barlow,
        fontSize = TEXT_SIZE_SMALL.sp,
        color = White,
    ),
    regularVerySmall = TextStyle(
        fontFamily = font.barlow,
        fontSize = TEXT_SIZE_VERY_SMALL.sp,
        color = White,
    ),
    regularMediumSmall = TextStyle(
        fontFamily = font.barlow,
        fontSize = TEXT_SIZE_MEDIUM_SMALL.sp,
        color = White,
    ),
)

@Suppress("CompositionLocalAllowlist")
internal val LocalAppTypography = staticCompositionLocalOf { typography }