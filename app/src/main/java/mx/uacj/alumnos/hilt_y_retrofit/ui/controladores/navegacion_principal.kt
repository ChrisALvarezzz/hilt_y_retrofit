package mx.uacj.alumnos.hilt_y_retrofit.ui.controladores

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.alumnos.hilt_y_retrofit.ui.pantallas.ListaPublicaciones
import org.w3c.dom.Text

@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier){
    val control_navegacion = rememberNavController()

    NavHost(navController = control_navegacion, startDestination = PantallaListaPublicaciones){
        composable<PantallaListaPublicaciones> {
            ListaPublicaciones(modificador, navegar_a_publicacion = {control_navegacion.navigate(PantallaPublicacion)})
        }
        composable<PantallaPublicacion> {
            Text("Te falta implementar esta pantalla")
        }
    }

}