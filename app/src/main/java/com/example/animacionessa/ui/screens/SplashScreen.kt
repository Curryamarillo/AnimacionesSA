package com.example.animacionessa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animacionessa.R
import com.example.animacionessa.navigation.Routes
import com.example.animacionessa.ui.theme.splash
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


@Composable
fun SplashScreen(navController: NavController) {
    val isDarkTheme = isSystemInDarkTheme()

    val backgroundImage = if (!isDarkTheme) R.drawable.splash_bg_light else R.drawable.splash_bg_dark

    LaunchedEffect(key1 = true) {
        delay(5.seconds)
        navController.popBackStack()
        navController.navigate(Routes.HomeScreen.route)
    }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = stringResource(R.string.background_image_light),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.offset(y = 50.dp),
                    text = "Bienvenidos",
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.spicy_rice)),
                    color = MaterialTheme.splash.titleFront,
                    style = MaterialTheme.typography.displayLarge.copy(
                        shadow = Shadow(
                            color = MaterialTheme.splash.titleBack,
                            offset = Offset(8f, 8f),
                            blurRadius = 2f
                        )
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    modifier = Modifier
                        .size(280.dp)
                        .offset(y = (-45).dp),
                    painter = painterResource(R.drawable.transparent_logo),
                    contentDescription = null
                )
            }
        }
    }
