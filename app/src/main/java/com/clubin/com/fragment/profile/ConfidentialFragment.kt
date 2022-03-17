package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ConfidentialFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_confidential, container, false)
    }

}

/*
Screen :
MenuPrivacyDetailsView
opens on click :: --- MenuView - Données et Sécurité --  Confidentialité

nav title: Confidentialité

view 1::
Nous respectons vos données
---- (style: .Medium, ofSize: 15)

Le respect de vos données est essentiel. Nos partenaires et
nous utilisons des informationn non sensibles de votre appareil (dont ID publicitaires, adresses MAC ou IP, données de géolocalisation) et profil utilisateur (dont donnnées démographiques lorsque cette information est disponible) afin d'améliorer votre expérience sur notre service, assurer son bon fonctionnement
 et vous proposer des contenus personnalisés. Pour en savoir plus sur les données personnelles que nous utilisons et les traitements que
 nous réalisons, vous pouvez consulter notre Politique de confidentialité.
------style: .Medium, ofSize: 12
------ link :: Politique de confidentialité ----- "shorturl.at/hkyEW" -----66D6FF

view 2::

labelText: "Localisation", LabelImage: "mappin.and.ellipse"

Pour activer/désactiver la localisation, rendez-vous dans Réglages > Clubin > Notifications.
---style: .Medium, ofSize: 12) ---- accent

EN ACTIVANT LA LOCALISATION VOUS AUTORISEZ
---style: .Medium, ofSize: 12) - secondary

L'utilisation des données de géolocalisation précise

View 3:

"Data", LabelImage: "antenna.radiowaves.left.and.right"

EN ACCEPTANT NOTRE RGPD VOUS AUTORISEZ
---style: .Medium, ofSize: 12) secondary color

Analysez activement les caractéristiques du terminal pour l'identification
Créer un profil pour afficher un contenu personnalisé
Stocker et/ou accéder accéder à des informations sur un terminal
------ (style: .Medium, ofSize: 16)

View 4:

"Marketing", LabelImage: "externaldrive.badge.person.crop")

EN ACCEPTANT NOTRE RGPD VOUS AUTORISEZ

Développer et améliorer les produits
Mesurer les performances du contenu
Sélectionner du contenu personnalisé
*/
