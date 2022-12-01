package com.example.jetpacknavgraph.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.jetpacknavgraph.R
import kotlin.math.abs

typealias DRAWABLE = R.drawable
typealias COLOR = R.color
typealias STRING = R.string

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}


@Composable
fun Int.asPainter(): Painter = painterResource(id = this)

@Composable
fun Int.asColor(): Color = colorResource(id = this)

@Composable
fun Int.asDp(): Dp = Dp(LocalContext.current.resources.getDimension(this) / LocalDensity.current.density)

@Composable
fun Int.asBoolean(): Boolean = LocalContext.current.resources.getBoolean(this)