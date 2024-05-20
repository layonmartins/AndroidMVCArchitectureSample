package com.layon.mvc2.Controller

import com.layon.mvc2.Model.User
import com.layon.mvc2.View.ILoginView

class LoginController(
    private val loginView: ILoginView
) : ILoginController {
    override fun OnLogin(email: String?, password: String?) {
        val user = User(email, password)
        val loginCode = user.isValid()

        when (loginCode) {
            0 -> loginView.OnLoginError("Please enter Email")
            1 -> loginView.OnLoginError("Please enter a valid Email")
            2 -> loginView.OnLoginError("Please enter a Password")
            3 -> loginView.OnLoginError("Please enter a password greater the 6 char")
            else -> loginView.OnLoginSucess("Login Sucessfull")
        }
    }
}