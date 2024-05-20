package com.layon.mvc2.Controller

import com.layon.mvc2.View.ILoginView
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginControllerTest {

    lateinit var loginView : LoginView
    lateinit var loginController : LoginController

    @Before
    fun before() {
        loginView = LoginView()
        loginController = LoginController(loginView)
    }

    @Test
    fun test_OnLogin_emptyEmail_error() {
        val email = ""
        val pass = "12345678"
        loginController.OnLogin(email, pass)
        val expected = "OnLoginError: Please enter Email"
        Assert.assertEquals(expected, loginView.messagedPrinted)
    }

    @Test
    fun test_OnLogin_invalidEmail_error() {
        val email = "login"
        val pass = "12345678"
        loginController.OnLogin(email, pass)
        val expected = "OnLoginError: Please enter a valid Email"
        Assert.assertEquals(expected, loginView.messagedPrinted)
    }

    @Test
    fun test_OnLogin_emptyPassword_error() {
        val email = "login@email.com"
        val pass = ""
        loginController.OnLogin(email, pass)
        val expected = "OnLoginError: Please enter a Password"
        Assert.assertEquals(expected, loginView.messagedPrinted)
    }

    @Test
    fun test_OnLogin_invalidPassword_error() {
        val email = "login@email.com"
        val pass = "123"
        loginController.OnLogin(email, pass)
        val expected = "OnLoginError: Please enter a password greater the 6 char"
        Assert.assertEquals(expected, loginView.messagedPrinted)
    }

    @Test
    fun test_OnLogin_success() {
        val email = "login@email.com"
        val pass = "12345678"
        loginController.OnLogin(email, pass)
        val expected = "OnLoginSuccess: Login Successfully"
        Assert.assertEquals(expected, loginView.messagedPrinted)
    }

}

// Util class for test without MainActivity reference
class LoginView : ILoginView {
    var messagedPrinted : String = ""
    override fun OnLoginSuccess(message: String?) {
        messagedPrinted = "OnLoginSuccess: $message"
    }
    override fun OnLoginError(message: String?) {
        messagedPrinted = "OnLoginError: $message"
    }

}