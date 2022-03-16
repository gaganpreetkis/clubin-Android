package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ContactUsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_contact_us, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactUsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
/*
Screen :: MenuContactView
opens on click :: --- MenuView - Contactez-nous

nav title: Contactez-nous

Support Client
----(style: .Medium, ofSize: 15


Link("**Envoyez-nous un e-mail**", destination: URL(string: "mailto:contact@club-in.com")!)

Posez votre question ou donnez nous vos recommendations, nous vous répondrons en 1 jours ouvrés.
----style: .Medium, ofSize: 12) secondary color

Link("**Appelez-nous**", destination: URL(string: "tel:0644163540")!)

Seulement en cas d'**urgence*, de signalement de *malfonction dans l'app* ou de *réclamation lié au paiement**
----style: .Medium, ofSize: 12) secondary color*/
