package com.example.jetpacknavgraph.ui.theme.chat.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.jetpacknavgraph.helper.DRAWABLE
import com.example.jetpacknavgraph.helper.asPainter
import com.google.android.material.color.MaterialColors

@ExperimentalFoundationApi
@Composable
fun EditText(onMessageSend: (String) -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.background(MaterialTheme.colors.onSurface)){
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            OutlinedTextField(modifier = Modifier.weight(1f, true),value = textState.value,
                onValueChange = { textState.value = it }, colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedLabelColor = Color.White))
            Spacer(modifier = Modifier.height(12.dp))
            Image(painter = DRAWABLE.ic_baseline_send_24.asPainter(), contentDescription = "",
                modifier = Modifier.weight(0.10f,true))
        }
    }
}

