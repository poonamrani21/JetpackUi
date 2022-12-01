package com.example.jetpacknavgraph.screens.nav_routes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacknavgraph.helper.DRAWABLE
import com.example.jetpacknavgraph.helper.asPainter
import com.example.jetpacknavgraph.ui.theme.ChatTheme

sealed class NavRoutes(val path:String) {
    object LoginScreen: NavRoutes("login_screen")
    object HomeScreen: NavRoutes("home_screen")
    object DetailsScreen: NavRoutes("details_screen")
    object RegisterScreen: NavRoutes("register_screen")
    object SplashScreen: NavRoutes("splash_screen")
    object UserProfileScreen: NavRoutes("user_profile_screen")
    object ChatScreenView: NavRoutes("chat")
    object WebViewScreen: NavRoutes("chat")
}
 val screens = listOf(
     NavRoutes.LoginScreen,
     NavRoutes.HomeScreen,
     NavRoutes.DetailsScreen,
     NavRoutes.RegisterScreen,
     NavRoutes.SplashScreen,
     NavRoutes.UserProfileScreen,
     NavRoutes.ChatScreenView,
     NavRoutes.WebViewScreen
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = DRAWABLE.ic_back_icon.asPainter(),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.path,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.path)
                }
            )
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    ChatTheme {
        Drawer{}
    }
}