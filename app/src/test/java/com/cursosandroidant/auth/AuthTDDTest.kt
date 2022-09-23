package com.cursosandroidant.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Ignore
import org.junit.Test

class AuthTDDTest {
    //comandos:
    /*alt + insert = se utiliza para hacer testing a una clase
    * ctrl + shift = para renombrar variables
    * alt + flecha izquierda o derecha= pasar entre pestañas */

    //given: Dado que el sujeto a aprobar
    //when: Cuando con la acción o los estados actuales de nuestra prueba
    //then : entonces el resultado de nuestra prueba

    @Test
    // renombrando las funciones bajo la estructura given-when-then
    // fun loginUser_correctData_returnsSuccesEvent
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, result)
    }

    @Test
    // fun loginUser_wrongData_returnsSuccesEvent
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val result = userAuthenticationTDD("at@gmail.com", "1234")
        assertEquals(AuthEvent.NOT_USER_EXIST, result)
    }

    @Test
    // fun loginUser_emptyData_returnsSuccesEvent
    fun login_emptyEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, result)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("at@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, result)
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val result = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, result)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, result)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "123e")
        assertEquals(AuthEvent.INVALID_PASSWORD, result)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "123e")
        assertEquals(AuthEvent.INVALID_USER, result)
    }

    //Aqui se muestran varias formas diferentes de testear los nulos, debemos escoger una
    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        val result = userAuthenticationTDD(null, "1234")
        assertEquals(AuthEvent.NULL_EMAIL, result)
    }

    @Test
    fun login_nullPassword_returnsException(){
        assertThrows(AuthException::class.java){
            println(userAuthenticationTDD("ant@gmail.com", null))
        }

    }

    //preferiblemente esta
    @Test
    fun login_nullForm_returnsException(){
        try {
            val result = userAuthenticationTDD(null,null)
            assertEquals(AuthEvent.NULL_FORM, result)
        }catch (e: Exception){
            //Se hace un cast para que sea la exception del tipo personalizado que estamos trabajando con la Clase AuthException que creamos
            (e as? AuthException)?.let {
                assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }

    }

    //Para ignorar una prueba
    @Ignore("Falta definir un requisito del cliente")
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "12345")
        assertEquals(AuthEvent.LENGHT_PASSWORD_INCORRECT, result)
    }

    /*










        login_completeForm_errorLengthPassword_returnsFailEvent
*/

}