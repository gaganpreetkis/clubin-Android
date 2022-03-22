package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R
import com.clubin.com.databinding.NotificationFragmentDataBinding
import com.clubin.com.databinding.PasswordChangeFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.NotificationFragmentCallback
import com.clubin.com.fragment.profile.callbacks.PasswordChangeFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PasswordChangeFragment :  BaseDataBindingFragment<PasswordChangeFragmentDataBinding>
    (R.layout.fragment_password_change), PasswordChangeFragmentCallback {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun injectDaggerComponent() {
    }

    override fun onDataBindingCreated() {

    }


}

/*
Screen :
MenuPasswordChangeView
opens on click :: --- MenuView - Données et Sécurité --  Changer de mot de passe



image: "Paris", size: 90)

Ugo Lafosse
--- (style: .ExtraBold, ofSize: 28)

Envoyer le code par e-mail
----- style: .Medium, ofSize: 16)

user email
----style: .Medium, ofSize: 12)

on click
present :PasswordResetCodeView*/
