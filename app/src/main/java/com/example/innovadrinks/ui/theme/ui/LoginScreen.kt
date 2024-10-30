import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.innovadrinks.R

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Agregar el logo en la parte superior
        Image(
            painter = painterResource(id = R.drawable.innova_logo),
            contentDescription = "Innova Logo",
            modifier = Modifier
                .width(300.dp) // Ajustar el ancho
                .height(250.dp) // Ajustar la altura
        )

        // Botones y texto
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            // Botón de inicio de sesión con Email
            Button(
                onClick = {
                    // Navega a la pantalla de inicio y elimina la pantalla de login
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), // Aumenta la altura del botón
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
                shape = RoundedCornerShape(16.dp) // Cambia el radio de redondeo según necesites
            ) {
                Text(
                    text = "Iniciar sesión con Email",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = Bold
                )
            }

            // Botón de continuar con Google
            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp), // Aumenta la altura del botón
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp) // Cambia el radio de redondeo según necesites
            ) {
                Text(
                    text = "Continuar con Google",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = Bold
                )
            }

            // Texto de "¿No tienes cuenta?"
            Text(
                text = "¿No tienes cuenta?",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally) // Centra el texto horizontalmente
            )

            // Botón de registrarse
            Button(
                onClick = {
                    navController.navigate("register")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Regístrate",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
