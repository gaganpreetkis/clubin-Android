package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.clubin.com.R
import com.clubin.com.databinding.PreferencesFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.PreferencesFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PreferencesFragment : BaseDataBindingFragment<PreferencesFragmentDataBinding>
    (R.layout.fragment_preferences),
    PreferencesFragmentCallback{
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_preferences, container, false)
        val complete: LinearLayout = view.findViewById<View>(R.id.ll_complete) as LinearLayout
        complete.setOnClickListener {
            fragmentChange(CardBanFragment())
        }

        return view
    }


    override fun onDataBindingCreated() {

    }
}

/*
Screen :: Préférences (MenuTransferPreferencesView)
opens on click :: --- MenuView - Paiement - Préférences de paiement / RIB


nav title: Paiements

view 1: Sur quel compte souhaitez-vous recevoir l'argent disponible ?")
.footnote()

Row 1:
image: "building.columns", name: "Compte bancaire (par défaut)", chevron: "chevron.right"
on click:: Mon RIB screen

Row 2:
image: "p.circle", name: "Paypal (arrive bientôt)", chevron: "chevron.right")
on click:: ( nothing yet )*/
