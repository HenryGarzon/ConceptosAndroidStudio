package com.henry.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.henry.holamundo.ui.theme.HolaMundoTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var greeting by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Ingress su nombre:")
        TextField(
            value = name,
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            greeting = "Hola ${name.text} bienvenido al mundo de desarrollo Android"
        }) {
            Text(text = "Enviar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = greeting)
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HolaMundoTheme {
        Greeting("Android")
    }
}
