package com.example.animacionessa.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Colores EXTENDIDOS: decoración de la marca que no existe como rol en Material 3.
 * Se usan con MaterialTheme.splash.ring1, etc. Cambian solos entre claro y oscuro.
 */
@Immutable
data class SplashColors(
    val ring1: Color, val ring2: Color, val ring3: Color, val ring4: Color,
    val center: Color,
    val titleFront: Color, val titleMid: Color, val titleBack: Color
)

val LightSplashColors = SplashColors(
    ring1 = Primary30,
    ring2 = Accent50,
    ring3 = Secondary50,
    ring4 = Tertiary80,
    center = Neutral94,
    titleFront = Primary40,
    titleMid = Secondary70,
    titleBack = Accent70
)

val DarkSplashColors = SplashColors(
    ring1 = Secondary60,
    ring2 = Primary30,
    ring3 = Tertiary70,
    ring4 = Accent30,
    center = Neutral20,
    titleFront = Neutral92,
    titleMid = Secondary50,
    titleBack = Accent30
)

val LocalSplashColors = staticCompositionLocalOf { LightSplashColors }

val MaterialTheme.splash: SplashColors
    @Composable @ReadOnlyComposable get() = LocalSplashColors.current