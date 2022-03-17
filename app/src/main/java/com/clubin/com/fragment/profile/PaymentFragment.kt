package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.clubin.com.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PaymentFragment : Fragment() {
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
        val view = inflater!!.inflate(R.layout.fragment_payment, container, false)


        val virement: LinearLayout = view.findViewById<View>(R.id.ll_virements) as LinearLayout
        virement.setOnClickListener {
            fragmentChange(VirementsFragment());
        }

        val preferences: LinearLayout = view.findViewById<View>(R.id.ll_préférences) as LinearLayout
        preferences.setOnClickListener {
            fragmentChange(PreferencesFragment());
        }

        val history: LinearLayout = view.findViewById<View>(R.id.ll_historique) as LinearLayout
        history.setOnClickListener {
            fragmentChange(PaymentHistoryFragment());
        }

        return view;

    }

    private fun fragmentChange(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

/*
Screen:: MenuPaymentView
opens on click :: --- MenuView - Paiement

nav title: Paiement

row 1:
name: "Virements", chevron: "chevron.right"
---- style: .SemiBold, ofSize: 17
on click :: Virements

row 2:
Historique des paiements
---- style: .SemiBold, ofSize: 17
on click :: Paiements

row 3:
Préférences de paiement / RIB
---- style: .SemiBold, ofSize: 17
on click :: Préférences*/
