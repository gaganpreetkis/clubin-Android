package com.clubin.com.fragment.profile.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R
import com.clubin.com.databinding.ContactUsFragmentDataBinding
import com.clubin.com.databinding.EmailChangeFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.ContactUsFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EmailChangeFragment : BaseDataBindingFragment<EmailChangeFragmentDataBinding>
    (R.layout.fragment_email_change),
    ContactUsFragmentCallback {
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
        binding.button.setOnClickListener {
            fragmentChange(VerificationCodeFragment())
        }
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}


/*
Screen: AccountVerificationEmailView
Title: Ajouter mon E-mail


Ajouter mon E-mail
--- (style: .ExtraBold, ofSize: 28)

Entrez votre *e-mail* à associer à ce compte pour recevoir votre code de validation"
--- style: .Medium, ofSize: 16

TextField : E-mail


Envoyer le code
---2CD0A8.   cornerRadius: 10.   white.     bold
---on click:: AccountVerificationCodeView screen */




