package com.cursosandroidant.auth

enum class AuthEvent {
    //succes
    USER_EXIST,
    //fail
    NOT_USER_EXIST,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM,
    LENGHT_PASSWORD_INCORRECT
}