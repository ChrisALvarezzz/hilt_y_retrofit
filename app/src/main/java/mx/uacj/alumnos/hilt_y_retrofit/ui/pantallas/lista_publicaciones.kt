package mx.uacj.alumnos.hilt_y_retrofit.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import mx.uacj.alumnos.hilt_y_retrofit.controladores.ControladorPublicaciones

@Composable
fun ListaPublicaciones(
        modificador: Modifier = Modifier,
        controlador_publicaciones: ControladorPublicaciones = hiltViewModel(),
        navegar_a_publicacion: () -> Unit = {}
) {
    val controlador_de_navegacion = rememberNavController(

    )
    controlador_publicaciones.obtener_publicaciones()

    if(controlador_publicaciones.publicaciones.value.size > 0){
        Column(modifier = Modifier.verticalScroll(rememberScrollState()).background(Color.Gray)){
            for (publicacion in controlador_publicaciones.publicaciones.value){
                Column (modifier = Modifier
                            .padding(20.dp)
                            .background(Color.White)
                            .clickable { controlador_publicaciones.seleccionar_publicacion(id = publicacion.id)
                            }){
                    Text("Publicacion: ${publicacion.title}", modifier = Modifier.padding(10.dp))
                    Text("${publicacion.body}", modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
    else{
        Text("Disculpa las molestias, pero estamos obteniendo las ultimas publicaciones. Favor de esperar")
    }

    Text(
        text = "Tenemos la modica cantidad de ${controlador_publicaciones.publicaciones.value.size} publicaciones",
        modifier = modificador
    )
}

@Preview
@Composable
fun Previsualizacion(){
    ListaPublicaciones()
}