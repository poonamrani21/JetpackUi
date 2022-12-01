package com.example.jetpacknavgraph.ui.theme.chat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpacknavgraph.R
import com.example.jetpacknavgraph.helper.DRAWABLE
import com.example.jetpacknavgraph.helper.asPainter
import com.example.jetpacknavgraph.model.User
import com.example.jetpacknavgraph.util.colorTopBar

@Composable
fun ChatTopBar(user: User, onBackIconClick: () -> Unit) {

    Column {
        TopAppBar(
            backgroundColor = colorTopBar(),
            navigationIcon = {
                IconButton(onClick = {
                    onBackIconClick()
                }) {
                    Icon(painter = DRAWABLE.ic_back_icon.asPainter(), contentDescription ="" ,
                        modifier = Modifier.padding(start = 8.dp),
                        tint = Color.White)
                }
            },
            actions = {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://dl.memuplay.com/new_market/img/com.vicman.newprofilepic.icon.2022-06-07-21-33-07.png")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_back_icon),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape).size(40.dp)
                )
            },
            title = {
                Text(
                    text = user.name,
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center)
                )
            }
        )
    }
}