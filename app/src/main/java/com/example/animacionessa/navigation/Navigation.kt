package com.example.animacionessa.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animacionessa.R
import com.example.animacionessa.ui.screens.AlphaAnimationScreen
import com.example.animacionessa.ui.screens.ColorAnimationScreen
import com.example.animacionessa.ui.screens.CounterAnimationScreen
import com.example.animacionessa.ui.screens.CrossfadeAnimationScreen
import com.example.animacionessa.ui.screens.ExpandableAnimationScreen
import com.example.animacionessa.ui.screens.HomeScreen
import com.example.animacionessa.ui.screens.SplashScreen
import com.example.animacionessa.ui.screens.VisibilityAnimationScreen
import java.nio.file.WatchEvent

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val isDarkTheme = isSystemInDarkTheme()
    val backgroundImage = if (isDarkTheme) R.drawable.app_bg_dark else R.drawable.app_bg_light

    val backStack by navController.currentBackStackEntryAsState()
    val rutaActual = backStack?.destination?.route
    val mostrarBarra = rutaActual != null && rutaActual != Routes.SplashScreen.route && rutaActual != Routes.HomeScreen.route

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                AnimatedVisibility(
                    visible = mostrarBarra,
                    enter = fadeIn(tween(700)) + expandVertically(tween(700)),
                    exit = fadeOut(tween(700)) + shrinkVertically(tween(700))
                ) {
                    if (mostrarBarra) {
                        BottomAppBar(
                            modifier = Modifier.fillMaxWidth().height(80.dp),
                            containerColor = MaterialTheme.colorScheme.primaryContainer,

                            ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .clickable{
                                        navController.popBackStack()
                                    }
                                    .padding(top=8.dp, bottom=12.dp, start =12.dp, end = 12.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        modifier = Modifier
                                            .padding(end = 12.dp)
                                            .size(40.dp)
                                        ,
                                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                        contentDescription = "",
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Text(
                                        text = "Volver",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        fontSize = 36.sp
                                    )
                                }
                            )

                        }
                    }
                }


            }
        ) { paddingValues ->
            NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                startDestination = Routes.SplashScreen.route
            ){
                composable(
                    route = Routes.SplashScreen.route
                ) {
                    SplashScreen(navController)
                }
                composable(
                    route = Routes.HomeScreen.route
                ) {
                    HomeScreen(navController)
                }
                composable(
                    route = Routes.AlphaAnimationScreen.route
                ) {
                    AlphaAnimationScreen()
                }
                composable(
                    route = Routes.ColorAnimationScreen.route
                ) {
                    ColorAnimationScreen()
                }
                composable(
                    route = Routes.VisibilityAnimationScreen.route
                ) {
                    VisibilityAnimationScreen()
                }
                composable(
                    route = Routes.CounterAnimationScreen.route
                ) {
                    CounterAnimationScreen()
                }
                composable(
                    route = Routes.CrossfadeAnimationScreen.route
                ) {
                    CrossfadeAnimationScreen()
                }
                composable(
                    route = Routes.ExpandableAnimationScreen.route
                ) {
                    ExpandableAnimationScreen()
                }

            }
        }
    }




}