package devandroid.tambori.authapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import devandroid.tambori.authapp.ui.theme.AuthAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    AuthScreen()

                }

            }

        }
    }
}

@Composable
fun AuthScreen(modifier: Modifier = Modifier) {
    Column {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(value = username, onValueChange = { newvalue ->
            username = newvalue
        })
        TextField(value = "", onValueChange = {
            password = it
        },
            visualTransformation = PasswordVisualTransformation())
        Button(onClick = {/*TODO*/ }) {
            Text(text = "Entre")
        }
    }
}

@Preview
@Composable
private fun AuthScreenPreview() {
    AuthAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AuthScreen()
        }
    }
}