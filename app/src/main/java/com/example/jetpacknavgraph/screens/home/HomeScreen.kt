package com.example.jetpacknavgraph.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpacknavgraph.screens.nav_routes.NavRoutes
import com.example.jetpacknavgraph.ui.theme.nav_drawer.AnimatingFabContent
import com.example.jetpacknavgraph.ui.theme.toolbar.TopBar

@Composable
fun HomeScreen(controller: NavController,openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(title = "Home", buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer() })
        val scrollState = rememberScrollState()

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(rememberNestedScrollInteropConnection())
                .systemBarsPadding()
        ) {
            Surface {
                Column(modifier = Modifier
                    .fillMaxSize()) {
                    val userNameList= remember { mutableListOf("Java", "Android","Python","Kotlin","PHP", "Angular") }
                    LazyColumn {
                        items(userNameList.size) { index ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp).padding(10.dp),
                                shape = RoundedCornerShape(16.dp).copy(CornerSize(0))){
                                Text(text = userNameList[index], color = Color.Black, modifier = Modifier.padding(10.dp))
                            }
                        }
                    }

                }
//List will show here
                }
            HomeFab(controller)

        }


        }
    }
@Composable
fun HomeFab(controller: NavController) {
        FloatingActionButton(
            onClick = {controller.navigate(NavRoutes.WebViewScreen.path) },
            modifier = Modifier
                .padding(16.dp)
                .navigationBarsPadding()
                .height(48.dp)
                .widthIn(min = 48.dp),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        ) {
            AnimatingFabContent(
                icon = {
                    Icon(
                        imageVector =  Icons.Outlined.Search ,
                        contentDescription ="Search"
                    )
                }, text = {""},
                extended = true
            )
    }
}

