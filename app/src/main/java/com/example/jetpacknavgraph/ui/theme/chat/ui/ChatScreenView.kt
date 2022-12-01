package com.example.jetpacknavgraph.ui.theme.chat.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.jetpacknavgraph.model.User
import com.example.jetpacknavgraph.model.chat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalFoundationApi
@Composable
fun ChatScreenView(user: User, onBackIconClick: () -> Unit, onMessageSend: (String) -> Unit) {

    Scaffold(
        topBar = { ChatTopBar(user, onBackIconClick)                 },
        content = {  ChatsScrollView(chat.toList())} ,
        bottomBar = {  EditText(onMessageSend) }
    )
}