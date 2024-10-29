@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.innovadrinks.ui.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, onShowBottomNav: () -> Unit) {
    // Muestra el Bottom Navigation cuando se carga la pantalla de inicio
    LaunchedEffect(Unit) {
        onShowBottomNav() // Asegúrate de que esto se llame una sola vez
    }

    var searchQuery by remember { mutableStateOf("") } // Estado para el texto del TextField

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Delivery",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White // Cambia a blanco para que contraste
                        )
                        Text(
                            text = "Ciudad Sandino",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
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
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1A1A1A)) // Color de la barra superior
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF1A1A1A)) // Color de fondo
                .padding(16.dp), // Padding alrededor de la columna
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Barra de búsqueda
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
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.White // Color del texto ingresado
                ),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.White, // Color del texto ingresado
                    fontWeight = FontWeight.Bold, // Hace el texto en negrita
                    fontSize = 16.sp
                ),
                shape = RoundedCornerShape(16.dp), // Redondeo de esquinas
                modifier = Modifier.fillMaxWidth() // Hace que el TextField ocupe
            )

            // Espacio entre la barra de búsqueda y los botones
            Spacer(modifier = Modifier.height(16.dp))

            // Botones de Energizantes y Snacks
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Acción para Energizantes */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A92FF)),
                    shape = RoundedCornerShape(16.dp), // Redondeo de esquinas
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Energizantes", color = Color.White)
                }

                Spacer(modifier = Modifier.width(8.dp)) // Espacio entre los dos botones

                Button(
                    onClick = { /* Acción para Snacks */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF333333)),
                    shape = RoundedCornerShape(16.dp), // Redondeo de esquinas
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Snacks", color = Color.White)
                }
            }

            // Contenido de la pantalla de inicio
            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los botones y el contenido
            Text(
                text = "Bienvenido a Innova Drinks",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            // Aquí puedes agregar más botones o elementos de la UI
        }
    }
}
