# Proyecto Compose – Menú de Navegación con Scaffold

**Autor:** Janier Palacios  
**Código:** 407382  
**Curso:** Programación Móvil con Android  
**Repositorio:** compose-janier-palacios-407382

---

## Objetivo General
Implementar un **menú de navegación** usando **Jetpack Compose**, aplicando la estructura del componente **`Scaffold`**, que incluye barra superior, contenido central y barra inferior con botones.

---

## Estructura del Proyecto

| Rama | Descripción |
|------|--------------|
| `compose-activity-3-01` | Implementación del Scaffold básico |
| `compose-activity-3-02` | Añadir barra inferior (bottom bar) |
| `compose-activity-3-03` | Implementar navegación entre pantallas |
| `compose-activity-3-04` | Versión final con diseño completo |

---

## Código Base – `MainActivity.kt`

```kotlin
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
```

---

## Instrucciones de Uso

1. **Abrir el proyecto:** Importa el proyecto en Android Studio
2. **Ejecutar la aplicación:** Compila y ejecuta en un dispositivo o emulador
3. **Navegar entre pantallas:** Usa los botones de la barra inferior
4. **Observar la estructura:** Nota cómo el Scaffold organiza la interfaz

---

## Funcionalidades Implementadas

- ✅ **Scaffold completo:** Barra superior, contenido central y barra inferior
- ✅ **Navegación básica:** Cambio de pantallas usando estado local
- ✅ **Diseño responsivo:** Layout que se adapta al contenido
- ✅ **Material Design 3:** Componentes modernos y consistentes
- ✅ **Estructura modular:** Código organizado en composables reutilizables

---

## 📹 Video de Implementación

**IMPORTANTE:** Para completar la entrega, se requiere un video explicativo de máximo 5 minutos donde se demuestre:

1. **Explicación del Scaffold:** Cómo funciona la estructura de navegación
2. **Demostración de navegación:** Mostrar el cambio entre pantallas
3. **Análisis del código:** Explicar los composables y su funcionalidad
4. **Navegación entre ramas:** Explicar las diferencias entre cada rama del proyecto

**Enlace al video:** [Agregar aquí el enlace del video una vez subido a YouTube]

---

## Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación
- **Jetpack Compose** - Framework de UI moderna
- **Material Design 3** - Sistema de diseño
- **Scaffold** - Componente de estructura de navegación
- **State Management** - Gestión de estado con `remember`
