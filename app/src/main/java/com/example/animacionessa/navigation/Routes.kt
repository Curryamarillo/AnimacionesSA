package com.example.animacionessa.navigation

sealed class Routes(val route: String) {
    object SplashScreen: Routes(route = "splash_screen")
    object HomeScreen: Routes(route = "home_screen")
    object AlphaAnimationScreen: Routes(route = "alpha_screen")
    object ColorAnimationScreen: Routes(route = "color_screen")
    object CounterAnimationScreen: Routes(route = "counter_screen")
    object CrossfadeAnimationScreen: Routes(route = "crossfade_screen")
    object ExpandableAnimationScreen: Routes(route = "expandable_screen")

    object VisibilityAnimationScreen: Routes(route = "visibility_screen")

}