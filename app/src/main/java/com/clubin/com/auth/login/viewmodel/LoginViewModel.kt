package com.clubin.com.auth.login.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clubin.com.auth.login.model.LoginModel

class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    private var userMutableLiveData: MutableLiveData<LoginModel>? = null
    val user: MutableLiveData<LoginModel>?
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData<LoginModel>()
            }
            return userMutableLiveData
        }

    fun onClick(view: View?) {
        val loginUser = EmailAddress.value?.let { Password.value?.let { it1 -> LoginModel(it, it1) } }
        userMutableLiveData!!.setValue(loginUser)
    }
}