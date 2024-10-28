@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.innovadrinks.ui.theme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.innovadrinks.ui.theme.InnovaDrinksTheme

@Composable
fun HomeScreen(onShowBottomNav: () -> Unit) {
    // Muestra el Bottom Navigation cuando se carga la pantalla de inicio
    LaunchedEffect(Unit) {
        onShowBottomNav()
    }
    // Contenido de la pantalla de inicio
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido a Innova Drinks",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        // Aquí puedes agregar un botón para navegar a otra pantalla o realizar alguna acción
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
    InnovaDrinksTheme {
        Greeting("Android")
    }
}
