package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PasswordChangeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_change, container, false)
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
