@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.innovadrinks.ui.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") } // Estado para el texto del TextField

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Delivery",
                            fontSize = 15.sp,
                            fontWeight = Bold,
                            color = Color.White // Cambia a blanco para que contraste
                        )
                        Text(
                            text = "",
                            fontSize = 20.sp,
                            fontWeight = Bold,
                            color = Color.White // Cambia a blanco para que contraste
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("cart") // Navega a CartScreen
                    }) {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = "Carrito",
                            tint = Color.White
                        ) // Cambia a blanco
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1A1A1A)) // Cambia el color de la barra superior
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF1A1A1A)) // Aplica el color de fondo
        ) {
            Column(
                modifier = Modifier.padding(18.dp) // Agrega un padding alrededor de la columna
            ) {
                // Aquí se puede agregar el Search Bar
                TextField(
                    value = searchQuery, // Usa el estado mutable
                    onValueChange = { searchQuery = it }, // Actualiza el estado
                    placeholder = { Text(text = "¿De qué tienes ganas hoy?", color = Color.White) },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = Color.White)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFF333333), // Color para el TextField
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(16.dp), // Redondeo de esquinas
                    modifier = Modifier.fillMaxWidth() // Hace que el TextField ocupe todo el ancho disponible
                )
            }
        }
    }
}
