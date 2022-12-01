package com.example.jetpacknavgraph.screens.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jetpacknavgraph.R
import com.example.jetpacknavgraph.screens.nav_routes.NavRoutes
import com.example.jetpacknavgraph.ui.theme.ChatTheme

@Composable
fun RegisterScreen(controller: NavController) {
    val email = remember { mutableStateOf("Poonam@gmail.com") }
    val username = remember { mutableStateOf("Poonam") }
    val password = remember { mutableStateOf("123") }
    val isError = remember { mutableStateOf(false) }
    ChatTheme {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            RegisterWindow(
                email = email.value,
                username = username.value,
                password = password.value,
                isLoginError = isError.value,
                onEmailChanged = {""},
                onUsernameChanged = {""},
                onPasswordChanged ={""},
                login = {controller.navigate(NavRoutes.LoginScreen.path)},
                home = {controller.navigate(NavRoutes.HomeScreen.path)}
            )
        }
    }
}
@Composable
fun RegisterWindow(
    email: String,
    username: String,
    password: String,
    isLoginError: Boolean,
    onEmailChanged: (String) -> Unit,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    home: () -> Unit
) {
    val context = LocalContext.current

    //hide the keyboard when we are done editing
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(model = ContextCompat.getDrawable(context, R.drawable.compose_app_icon),
            contentDescription = "App logo",
            modifier = Modifier
                .padding(bottom = 32.dp).size(160.dp)
                .clickable { onUsernameChanged("demo@example.com")
                    onPasswordChanged("P@ssw0rd12")
                })
        OutlinedTextField(
            modifier = Modifier.semantics { contentDescription = "Email" },
            value = email,
            onValueChange = { onEmailChanged(it) },
            label = { Text("Email") },
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(
            modifier = Modifier.semantics { contentDescription = "Username" },
            value = username,
            onValueChange = { onUsernameChanged(it) },
            label = { Text("Username") },
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp)
                .semantics { contentDescription = "Password" },
            value = password,
            onValueChange = { onPasswordChanged(it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                home()
            })
        )
        Button(modifier = Modifier
            .padding(top = 32.dp)
            .semantics { contentDescription = "Register" },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            onClick = {
                home()
            })
        {
            Text(
                "Register",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(text = AnnotatedString("Already have account? Click here to login"), onClick ={ login() } )
        if (isLoginError) {
            Text(
                modifier = Modifier.padding(top = 20.dp),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.error,
                text = "Error"
            )
        }
    }
}