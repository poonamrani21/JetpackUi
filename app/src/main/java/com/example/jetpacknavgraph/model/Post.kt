package com.example.jetpacknavgraph.model

import androidx.annotation.DrawableRes

data class Post(
    @DrawableRes val userImage: Int = 0,
    val userId: String = "",
    @DrawableRes val post: Int = 0
)