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

class SecurityFragment : Fragment() {
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
        val view = inflater!!.inflate(R.layout.fragment_security, container, false)
        val password: LinearLayout = view.findViewById<View>(R.id.ll_change_password) as LinearLayout
        password.setOnClickListener {
            fragmentChange(PasswordChangeFragment())
        }

        val confidential: LinearLayout = view.findViewById<View>(R.id.ll_confidential) as LinearLayout
        confidential.setOnClickListener {
            fragmentChange(ConfidentialFragment())
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
Screen :
MenuPrivacyView
opens on click :: --- MenuView - Données et Sécurité

nav title: Données et Sécurité

Row 1:
(image: "lock", name: "Confidentialité", chevron: "chevron.right",
---- .SemiBold, ofSize: 17)
----on click:: Confidentialité

Row 2:
image: "key", name: "Changer de mot de passe", chevron: "chevron.right"
---- .SemiBold, ofSize: 17)
----on click:: MenuPasswordChangeView


RoundedRectangle(cornerRadius: 15)
.stroke(Color.red, lineWidth: 3)

Supprimer mon compte
---   .semibold()
.body() -- (style: .Medium, ofSize: 16)
.foregroundColor(.red)

En faisant cela, Clubin supprimera définitivement toutes informations vous concernant.
- (style: .Medium, ofSize: 12) seconday color
*/

