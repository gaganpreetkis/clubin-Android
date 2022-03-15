package com.clubin.com.fragment.event.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class EventFragment : Fragment() {

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}

/*view 1: compte
---- border color - AccentColor - 2CD0A8, lineWidth: 3

@ugo_l
------ style: .Bold, ofSize: 22)

Ugo Lafosse, 22 ans
----- (style: .Medium, ofSize: 16)

Membre Clubin depuis 2020
------- (style: .Medium, ofSize: 12)

ImageCircleComponent(image: "Profil", size: 80)

title: "Centre de contrôle"
image: "checkmark.shield"
right arrow::chevron.right
on click ::  MenuControlCenterView screen (Ressources et Conseils)*/

/*View 2:  réglages
------ 29889A peacock

row 1:
image: "app.badge", name: "Notifications", chevron: "chevron.right"
---- style: .SemiBold, ofSize: 17
on click :: Notifications screen

row 2:
image: "lock", name: "Données et Sécurité", chevron: "chevron.right"
---- style: .SemiBold, ofSize: 17
on click :: Données et Sécurité screen

row 3:
image: "creditcard", name: "Paiement", chevron: "chevron.right"
---- style: .SemiBold, ofSize: 17
on click :: Paiement screen


View 3 :: infosAide
---- night color - 252D74

row 1:
name: "Contactez-nous", chevron: "chevron.right"
on click : Contactez-nous screen

row 2:
name: "Noter notre application", chevron: "chevron.right"
on click:: Donner votre avis screen

row 3 :
name: "Conditions générales", linkLabel: "arrow.up.right.square"
--link ::: https://www.youtube.com/

row 4 :
name: "Politique de confidentialité", linkLabel: "arrow.up.right.square"
--link ::: https://www.youtube.com/

row 5 :
name: "Aide", linkLabel: "arrow.up.right.square"
--link ::: https://www.youtube.com/


bottom lines::
Se déconnecter
----- style: .SemiBold, ofSize: 14)), color:: lipstick - D54667
----Image(systemName: "arrow.up.forward.square

V 1.0
--- font(.type(style: .SemiBold, ofSize: 14)*/
