package com.example.innovadrinks.ui.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFF1A1A1A),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(0.dp)
            ), // Color de fondo para toda la pantalla
        verticalArrangement = Arrangement.Top // Alineación vertical al inicio
    ) {
        // Fila para la flecha a la izquierda y el texto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp), // Espaciado alrededor
            verticalAlignment = Alignment.CenterVertically // Alineación vertical centrada
        ) {
            // Flecha para regresar al Home
            IconButton(
                onClick = { navController.navigate("home") }, // Navegar a Home
                modifier = Modifier.padding(end = 16.dp) // Espaciado a la derecha para separar del texto
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color(0xFF1E88E5) // Color azul
                )
            }

            // Espaciador para ocupar el espacio restante
            Spacer(modifier = Modifier.weight(1f))

            // Texto centrado
            Text(
                text = "Tu Pedido",
                modifier = Modifier.fillMaxWidth(), // Para que el texto ocupe todo el ancho
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                color = Color.White // Color del texto (opcional)
            )
        }

        // Espacio adicional debajo de la fila, si lo deseas
        Spacer(modifier = Modifier.weight(1f))
    }
}
