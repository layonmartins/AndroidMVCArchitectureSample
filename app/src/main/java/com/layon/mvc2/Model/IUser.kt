package com.layon.mvc2.Model

interface IUser {
    fun getEmail(): String?
    fun getPassword(): String?
    fun isValid(): Int
}