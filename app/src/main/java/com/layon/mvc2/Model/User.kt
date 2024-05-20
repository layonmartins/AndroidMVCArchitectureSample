package com.layon.mvc2.Model

import android.text.TextUtils
import android.util.Patterns
import androidx.core.util.PatternsCompat

class User(
    private val email: String?,
    private val password: String?
) : IUser {
    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isValid(): Int {
        if(getEmail()?.isEmpty() == true)
            return  0
        else if(!PatternsCompat.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  1
        else if(getPassword()?.isEmpty() == true)
            return 2
        else if(getPassword()?.length!! <=6)
            return 3
        else
            return -1;
    }
}