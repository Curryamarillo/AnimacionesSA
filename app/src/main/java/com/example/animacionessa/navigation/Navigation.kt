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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val isDarkTheme = isSystemInDarkTheme()
    val backgroundImage = if (isDarkTheme) R.drawable.app_bg_dark else R.drawable.app_bg_light

    // Estas variables se usan para saber donde estoy y enseñar o no el bottomNavBar
    val backStack by navController.currentBackStackEntryAsState()
    val rutaActual = backStack?.destination?.route
    val mostrarBarra: Boolean = rutaActual != null && rutaActual != Routes.SplashScreen.route && rutaActual != Routes.HomeScreen.route

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // He ubicado aquí el Scaffold para que se enseñe en las Activities de cada animación
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                // Como tenía un problema, la navbar salía antes que el contenido he resuelto esto
                // mediante un Animated Visibility.
                AnimatedVisibility(
                    visible = mostrarBarra,
                    enter = fadeIn(tween(700)) + expandVertically(tween(700)),
                    exit = fadeOut(tween(700)) + shrinkVertically(tween(700))
                ) {
                    if (mostrarBarra) {
                        TopNavBarCustom(
                            onBack = { navController.popBackStack() }
                        )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopNavBarCustom(onBack: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        title = {
            Row(
                modifier = Modifier
                    .clickable { onBack() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(40.dp)
                )
                Text(
                    text = stringResource(R.string.volver),
                    fontSize = 36.sp
                )
            }
        }
    )
}