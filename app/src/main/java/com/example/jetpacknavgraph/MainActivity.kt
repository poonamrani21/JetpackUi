package com.example.jetpacknavgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpacknavgraph.screens.details.DetailsScreen
import com.example.jetpacknavgraph.screens.home.HomeScreen
import com.example.jetpacknavgraph.screens.login.LoginScreen
import com.example.jetpacknavgraph.screens.nav_routes.Drawer
import com.example.jetpacknavgraph.screens.nav_routes.NavRoutes
import com.example.jetpacknavgraph.screens.register.RegisterScreen
import com.example.jetpacknavgraph.screens.splash.SplashScreen
import com.example.jetpacknavgraph.screens.user_profile.UserProfileScreen
import com.example.jetpacknavgraph.ui.theme.ChatTheme
import com.example.jetpacknavgraph.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.rememberDrawerState
import com.example.jetpacknavgraph.model.User
import com.example.jetpacknavgraph.screens.webview.WebViewScreen
import com.example.jetpacknavgraph.ui.theme.chat.ui.ChatScreenView
import com.example.jetpacknavgraph.ui.theme.nav_drawer.JetchatDrawerContent

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatTheme {
                AppMainScreen()
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class,
        ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class
    )
    @Composable
    fun AppMainScreen() {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colors.background) {
          val drawerState = rememberDrawerState(initialValue = Closed)

            val scope = rememberCoroutineScope()
            val openDrawer = { scope.launch { drawerState.open() } }
            ModalNavigationDrawer(drawerState = drawerState,
                drawerContent = { ModalDrawerSheet { JetchatDrawerContent(onClickEvent = { navController.graph.startDestinationId }) } },
                content = {NavHost(navController = navController, startDestination = NavRoutes.SplashScreen.path) {
                    composable(NavRoutes.SplashScreen.path) { SplashScreen(navController )}
                    composable(NavRoutes.LoginScreen.path) { LoginScreen(navController )}
                    composable(NavRoutes.ChatScreenView.path) {  ChatScreenView(User(2, "Poonam", "userImage"), {}) {}}
                    composable(NavRoutes.RegisterScreen.path) { RegisterScreen(navController ) }
                    composable(NavRoutes.HomeScreen.path) { HomeScreen(navController,openDrawer = { openDrawer() }) }
                    composable(NavRoutes.UserProfileScreen.path) { UserProfileScreen(navController,openDrawer = { openDrawer() }) }
                    composable(NavRoutes.WebViewScreen.path) { WebViewScreen(navController) }
                    composable(NavRoutes.DetailsScreen.path) { DetailsScreen( navController,openDrawer = { openDrawer() }) } }
                }
            ) }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() { ChatTheme { AppMainScreen() } }
}