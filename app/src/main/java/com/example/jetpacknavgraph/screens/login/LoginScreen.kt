package com.example.jetpacknavgraph.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpacknavgraph.R
import com.example.jetpacknavgraph.screens.nav_routes.NavRoutes
import com.example.jetpacknavgraph.ui.theme.ChatTheme

@Composable
fun LoginScreen(controller: NavController) {
    //val username = viewModel.username.observeAsState("")
    //val password = viewModel.password.observeAsState("")
    // val isError = viewModel.isError.observeAsState(false)
    val username = remember { mutableStateOf("Poonam") }
    val password = remember { mutableStateOf("123") }
    val isError = remember { mutableStateOf(false) }
    ChatTheme {
        androidx.compose.material.Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            LoginWindow(
                username = username.value,
                password = password.value,
                isLoginError = isError.value,
                onUsernameChanged = {""},
                onPasswordChanged ={""},
                login = {controller.navigate(NavRoutes.HomeScreen.path)},
                register = {controller.navigate(NavRoutes.RegisterScreen.path)}
            )
        }
    }
}
@Composable
fun LoginWindow(
    username: String,
    password: String,
    isLoginError: Boolean,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    register: () -> Unit
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

        AsyncImage(model = ContextCompat.getDrawable(context, R.drawable.compose_app_icon), contentDescription = "App logo",
            modifier = Modifier
                .padding(bottom = 32.dp).size(160.dp)
                .clickable {
                    onUsernameChanged("demo@example.com")
                    onPasswordChanged("P@ssw0rd12")
                })
        androidx.compose.material.OutlinedTextField(
            modifier = Modifier.semantics { contentDescription = "Username" },
            value = username,
            onValueChange = { onUsernameChanged(it) },
            label = { androidx.compose.material.Text("Username") },
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email
            )
        )
        androidx.compose.material.OutlinedTextField(
            modifier = Modifier
                .padding(top = 16.dp)
                .semantics { contentDescription = "Password" },
            value = password,
            onValueChange = { onPasswordChanged(it) },
            label = { androidx.compose.material.Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                login()
            })
        )
        androidx.compose.material.Button(modifier = Modifier
            .padding(top = 32.dp)
            .semantics { contentDescription = "Login" },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            onClick = {
                login()
            })
        {
            androidx.compose.material.Text(
                "Login",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(text = AnnotatedString("New User? Click here to register!"), onClick ={ register() } )
        if (isLoginError) {
            androidx.compose.material.Text(
                modifier = Modifier.padding(top = 20.dp),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.error,
                text = "Error"
            )
        }
    }
}



