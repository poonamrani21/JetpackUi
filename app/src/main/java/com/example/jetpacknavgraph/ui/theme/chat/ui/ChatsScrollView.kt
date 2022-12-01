package com.example.jetpacknavgraph.ui.theme.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknavgraph.model.Conversation

@Composable
fun ChatsScrollView(chat: List<Conversation>) {
    LazyColumn(modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp,10.dp,10.dp,40.dp)) {
        itemsIndexed(items = chat) { _, item ->
            if (item.id == 2) setupReceipientChat(item) else setupMyChat(item)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun setupMyChat(chat: Conversation) {
   /* Box(
        modifier = Modifier.fillMaxWidth().background(Color(91, 122, 82, 205))
            .padding(80.dp, end = 10.dp)
    ) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = chat.chat,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }*/
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp), horizontalAlignment = Alignment.Start) {
        Card(
            modifier = Modifier.widthIn(max = 340.dp),
            shape = RoundedCornerShape(16.dp).copy(bottomStart = CornerSize(0)),
            colors = CardDefaults.cardColors(containerColor =MaterialTheme.colorScheme.primary ))
        {
            Text(
                modifier = Modifier.padding(8.dp),
                text =  chat.chat,
                color =MaterialTheme.colorScheme.onPrimary ) }
    }
}

@Composable
fun setupReceipientChat(chat: Conversation) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 4.dp), horizontalAlignment = Alignment.End) {
        Card(
            modifier = Modifier.widthIn(max = 340.dp),
            shape = RoundedCornerShape(16.dp).copy(bottomEnd = CornerSize(0)),
            colors = CardDefaults.cardColors(containerColor =MaterialTheme.colorScheme.secondary ))
        {
            Text(
                modifier = Modifier.padding(8.dp),
                text =  chat.chat,
                color =MaterialTheme.colorScheme.onPrimary ) }
    }
}
