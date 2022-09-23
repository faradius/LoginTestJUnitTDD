package com.cursosandroidant.auth



import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Assert
import org.junit.Test

class AuthHamcrestTest {


    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        //Interpretación: La afirmación que se espera es este valor y el resultado es
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val result = userAuthenticationTDD("at@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result) )
    }

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("at@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "123e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "123e")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    //Aqui se muestran varias formas diferentes de testear los nulos, debemos escoger una
    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        val result = userAuthenticationTDD(null, "1234")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
    }

    @Test
    fun login_nullPassword_returnsException(){
        Assert.assertThrows(AuthException::class.java) {
            println(userAuthenticationTDD("ant@gmail.com", null))
        }

    }

    //preferiblemente esta
    @Test
    fun login_nullForm_returnsException(){
        try {
            val result = userAuthenticationTDD(null,null)
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        }catch (e: Exception){
            //Se hace un cast para que sea la exception del tipo personalizado que estamos trabajando con la Clase AuthException que creamos
            (e as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent) )
            }
        }

    }


    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "12345")
        assertThat(AuthEvent.LENGHT_PASSWORD_INCORRECT, `is`(result))
    }


    @Test
    //que vamos hacer - con que datos - cual es son los valores esperados o que queremos que suceda
    fun checkNames_differentsUsers_match(){
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_noMatch(){
        val email = "ant@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)) )
    }

    @Test
    fun checkExist_newEmail_returnsString(){
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursosandroid.com"
        val emails = arrayOf(oldEmail,newEmail)
        //Comprobamos si esta el dato dentro de una colección de datos
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString(){
        val nextEmail = "alex@cursosandroid.com"
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursosandroid.com"
        val emails = arrayListOf(oldEmail,newEmail, nextEmail)
        val newemails = arrayListOf(newEmail, nextEmail)
        assertThat(newemails, everyItem(endsWith("cursosandroid.com")))

    }
}