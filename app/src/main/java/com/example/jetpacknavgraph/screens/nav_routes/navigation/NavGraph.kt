package com.example.jetpacknavgraph.screens.nav_routes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpacknavgraph.screens.details.DetailsScreen
import com.example.jetpacknavgraph.screens.home.HomeScreen
import com.example.jetpacknavgraph.screens.login.LoginScreen
import com.example.jetpacknavgraph.screens.nav_routes.NavRoutes
import com.example.jetpacknavgraph.screens.register.RegisterScreen
import com.example.jetpacknavgraph.screens.splash.SplashScreen
import com.example.jetpacknavgraph.screens.user_profile.UserProfileScreen
import com.example.jetpacknavgraph.screens.webview.WebViewScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
@Composable
fun  NavGraph(controller: NavHostController,openDrawer: () -> Unit) {
    NavHost(navController = controller, startDestination =NavRoutes.SplashScreen.path){
        composable(route = NavRoutes.SplashScreen.path){ SplashScreen(controller) }
        composable(route = NavRoutes.LoginScreen.path){ LoginScreen(controller) }
        composable(route = NavRoutes.RegisterScreen.path){ RegisterScreen(controller) }
        composable(route = NavRoutes.HomeScreen.path){ HomeScreen(controller, openDrawer = openDrawer) }
        composable(route = NavRoutes.UserProfileScreen.path){ UserProfileScreen(controller,openDrawer = openDrawer) }
        composable(route = NavRoutes.DetailsScreen.path){ DetailsScreen(controller,openDrawer = openDrawer) }
        composable(route = NavRoutes.WebViewScreen.path){ WebViewScreen(controller) }
    }
}


