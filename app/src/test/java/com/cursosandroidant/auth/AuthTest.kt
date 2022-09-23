package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthTest {

    //El nombre de la función se divide en tres partes, la acción a ejecutar, que escenario queremos evaluar, y que es lo que debe pasar,
    /*Es decir:
     la acción a ejecutar: es un logueo de un usuario
     que escenerario evaluamos: que se llene toodo el formulario completo del login
     lo que debe pasar: es devolvernos un true*/

    /*TDD es un ciclo de testing para evaluar nuestras pruebas es decir tenemos que crear tres escenarios, los cuales son:
    * 1.- Crear una prueba que falle
    * 2.- Hacer que el test pase
    * 3.- por ultimo, refactorizar el codigo o agregar codigo que cubra los diferentes escenarios que pueda pasar en la aplicacion durante las pruebas
    *
    * el ciclo se repite una y otra vez hasta terminar de validar las diferentes funcionalidades*/

    @Test
    fun login_complete_returnsTrue(){
        val result = userAuthentication("ant@gmail.com", "1234")
        assertTrue(result)
    }

    @Test
    fun login_complete_returnsFalse(){
        val result = userAuthentication("nt@gmail.com", "1234")
        assertFalse(result)
    }

    @Test
    fun login_emptyEmail_returnsFalse(){
        val result = userAuthentication("", "1234")
        assertFalse(result)
    }

   /* - TDD -

    @Test
    fun login_nullEmail_returnsFalse(){
        val result = userAuthenticationTDD(null, "1234")
        assertFalse(result)
    }

    @Test
    fun login_nullPassword_returnsFalse(){
        val result = userAuthenticationTDD("ant@gmail.com", null)
        assertFalse(result)
    }*/

}