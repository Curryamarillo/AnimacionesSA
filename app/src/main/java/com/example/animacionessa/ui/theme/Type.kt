package com.example.animacionessa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.unit.em
import com.example.animacionessa.R

// Las fuentes están en la carpeta res/font
val SpicyRice = FontFamily(Font(R.font.spicy_rice, FontWeight.Normal))

@OptIn(androidx.compose.ui.text.ExperimentalTextApi::class)
private fun gluten(weight: FontWeight) = Font(
    resId = R.font.gluten,
    weight = weight,
    variationSettings = FontVariation.Settings(FontVariation.weight(weight.weight))
)

val Gluten = FontFamily(
    gluten(FontWeight.Normal),
    gluten(FontWeight.Medium),
    gluten(FontWeight.SemiBold)
)

// Escala de Material 3 con los mismos tamaños, interlineados e interletrados que tus estilos de Figma.
val AppTypography = Typography(
    displayLarge = TextStyle(fontFamily = SpicyRice, fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.02).em),
    displayMedium = TextStyle(fontFamily = SpicyRice, fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = (-0.02).em),
    displaySmall = TextStyle(fontFamily = SpicyRice, fontSize = 36.sp, lineHeight = 44.sp, letterSpacing = (-0.02).em),
    headlineLarge = TextStyle(fontFamily = SpicyRice, fontSize = 32.sp, lineHeight = 40.sp, letterSpacing = (-0.01).em),
    headlineMedium = TextStyle(fontFamily = SpicyRice, fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = (-0.01).em),
    headlineSmall = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.01.em),
    titleSmall = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.01.em),
    bodyLarge = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.01.em),
    labelMedium = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.01.em),
    labelSmall = TextStyle(fontFamily = Gluten, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.01.em)
)

// Estilo propio de los botones
val ButtonLabel = TextStyle(
    fontFamily = Gluten,
    fontWeight = FontWeight.SemiBold,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.01.em
)