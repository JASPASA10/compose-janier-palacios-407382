import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigationMenu()
        }
    }
}

@Composable
fun MainNavigationMenu() {
    var currentScreen by remember { mutableStateOf("Inicio") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Mi Aplicación Compose") })
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { currentScreen = "Inicio" }) { Text("Inicio") }
                Button(onClick = { currentScreen = "Perfil" }) { Text("Perfil") }
                Button(onClick = { currentScreen = "Ajustes" }) { Text("Ajustes") }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ScreenContent(name = currentScreen)
        }
    }
}

@Composable
fun ScreenContent(name: String) {
    Text("Estás en la pantalla de: $name", style = MaterialTheme.typography.titleLarge)
}
