package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_security, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecurityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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

