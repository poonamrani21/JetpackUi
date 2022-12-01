package com.example.jetpacknavgraph.model


import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.jetpacknavgraph.R
import com.example.jetpacknavgraph.ui.theme.compose_view.GridScreen
import com.example.jetpacknavgraph.ui.theme.compose_view.IGTVScreen

sealed class TabItem(
    @DrawableRes var icon: Int,
    var title: String,
    var screen: @Composable () -> Unit
) {
    @ExperimentalComposeUiApi
    object Grid : TabItem(R.drawable.ic_back_icon, "Grid", {
        GridScreen(
            listOf(
                Post(userImage =R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post =R.drawable.ic_back_icon),
            )
        )
    })

    object IGTV : TabItem(R.drawable.ic_back_icon, "IGTV", {
        IGTVScreen(
            listOf(
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_back_icon),
            )
        )
    })

    @ExperimentalComposeUiApi
    object Mention : TabItem(R.drawable.ic_back_icon, "Mention", {
        GridScreen(
            listOf(
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_star_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_star_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_star_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_star_icon),
                Post(userImage = R.drawable.ic_back_icon, userId = "", post = R.drawable.ic_star_icon)
            )
        )
    })
}