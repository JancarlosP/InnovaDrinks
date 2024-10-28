package com.example.innovadrinks

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.innovadrinks.ui.theme.InnovaDrinksTheme
import com.example.innovadrinks.ui.theme.ui.CartScreen
import com.example.innovadrinks.ui.theme.ui.HomeScreen
import com.example.innovadrinks.ui.theme.ui.OrderScreen
import com.example.innovadrinks.ui.theme.ui.ProfileScreen
import com.example.innovadrinks.ui.theme.ui.PromotionsScreen
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InnovaDrinksTheme {
                SplashScreenContent()
            }
        }
    }
}

@Composable
fun SplashScreenContent() {
    LaunchedEffect(Unit) {
        delay(1000) // Retraso de 1 segundo
    }
    // Navegación
    MainScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf("home") }
    var showBottomNav by remember { mutableStateOf(false) } // Estado para controlar la visibilidad del BottomNavigation

    Scaffold(
        bottomBar = {
            if (showBottomNav) { // Solo mostrar el BottomNavigation si showBottomNav es true
                CustomBottomNavigation(navController) { selectedItem = it }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A)) // Aplica el color de fondo aquí
    ) { innerPadding ->
        NavHost(navController, startDestination = "login", Modifier.padding(innerPadding)) {
            composable("login") {
                LoginScreen(navController)
            }
            composable("home") {
                HomeScreen(onShowBottomNav = {
                    showBottomNav = true
                }) // Muestra el BottomNav al llegar a Home
            }
            composable("promotions") { PromotionsScreen() }
            composable("order") { OrderScreen() }
            composable("profile") { ProfileScreen() }
            composable("cart") { CartScreen(navController) } // Pasa el navController aquí
        }
    }
}

@Composable
fun CustomBottomNavigation(
    navController: NavHostController,
    onItemSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1A1A)), // Color de fondo negro para el BottomNavigation
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val items = listOf("home", "promotions", "order", "profile")
        val icons = listOf(
            Icons.Filled.Home,
            Icons.Filled.Star,
            Icons.Filled.List,
            Icons.Filled.Person
        )
        val labels = listOf("Inicio", "Promociones", "Pedidos", "Perfil")

        items.forEachIndexed { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = {
                    navController.navigate(item) {
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                    }
                    onItemSelected(item)
                }) {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = labels[index],
                        tint = Color.White // Cambia el color del icono a blanco
                    )
                }
                Text(
                    text = labels[index],
                    color = Color.White, // Cambia a blanco para el texto
                    fontWeight = FontWeight.Bold // Agrega esto para hacer el texto en negrita
                )
            }
        }
    }
}