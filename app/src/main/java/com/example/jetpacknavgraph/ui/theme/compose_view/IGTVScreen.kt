package com.example.jetpacknavgraph.ui.theme.compose_view
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.jetpacknavgraph.helper.asPainter
import com.example.jetpacknavgraph.model.Post

@Composable
fun IGTVScreen(posts: List<Post> = emptyList()) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        items(posts.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEachIndexed { index, item ->
                    Image(
                        painter = item.post.asPainter(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillParentMaxWidth(0.5F)
                            .aspectRatio(0.75F)
                            .padding(
                                start =  4.dp,
                                end = 8.dp,
                                top = 8.dp,).clip(shape = RoundedCornerShape(16.dp))/*.padding(
                                start = if (isEven(index)) 8.dp else 4.dp,
                                end = if (isEven(index)) 4.dp else 8.dp,
                                top = 8.dp,).clip(shape = RoundedCornerShape(16.dp))*/
                    )
                }
            }
        }
    }
}