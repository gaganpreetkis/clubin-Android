package com.clubin.com.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ControlCenterFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_control_center, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ControlCenterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

/*
Screen :
MenuControlCenterView

opens on click :: --- MenuView - Centre de contrôle

nav title: Centre de contrôle

view 1::
Ressources et Conseils
---- style: .Bold, ofSize: 22)

Gestes de premiers secours
-----backgroundColor: .red, width: 140, height: 140, fontSize: 20, font: .Bold

Vol - Casse ?
----foregroundColor: .white, backgroundColor: .purple, width: 140, height: 140, fontSize: 20, font: .Bold)
Que faire en cas de Vol ou Casse ?
------(style: .Medium, ofSize: 12)

Incendie
---- foregroundColor: .white, backgroundColor: .orange, width: 140, height: 140, fontSize: 20, font: .Bold)
Les mesures à suivre
------(style: .Medium, ofSize: 12)

Litiges / Violence
---- foregroundColor: .white, backgroundColor: .blue, width: 140, height: 140, fontSize: 20, font: .Bold)
Que faire en cas de problème avec une/des personnes dans la soirée ?
------(style: .Medium, ofSize: 12)



view 2:

Centre de sécurité
---- style: .Bold, ofSize: 22

La Sécurité selon Clubin

Obtenez l’assistance, les outils et les informations dont vous avez besoin.*/
