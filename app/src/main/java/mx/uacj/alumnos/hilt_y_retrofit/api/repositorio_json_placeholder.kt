package mx.uacj.alumnos.hilt_y_retrofit.api

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Constructor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServidorJSONPlaceholder{
    @Provides
    @Singleton
    fun crea_consultas_de_servicio(constructor: Retrofit.Builder): JSONPlaceholder{
        return constructor
            .build()
            .create(JSONPlaceholder::class.java)
    }

    // cualquier cosa que requiera conexion llamara a crea_consultas_de_servicios(provee_conexion_al_placeholder)

    @Provides
    @Singleton
    fun provee_conexion_al_placeholder(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
    }
}