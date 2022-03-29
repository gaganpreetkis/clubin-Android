package com.clubin.com.fragment.hosts.view

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.HostCreationDrinkFoodFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.AccountEditFragmentCallback
import com.clubin.com.tabbar.TabBarActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HostCreationDrinkFoodFragment : BaseDataBindingFragment<HostCreationDrinkFoodFragmentDataBinding>
    (R.layout.fragment_host_creation_drink_food),
    AccountEditFragmentCallback {

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

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HostCreationDrinkFoodFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.continueBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.addFragment(HostCreationRulesDurationFragment(), true)
            }
        }
        binding.backBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.removeFragment()
            }
        }
        binding.closeBtn.setOnClickListener {
            (activity as TabBarActivity).let {
                it.removeFragment()
            }
        }
        var alcoolDisable = false;
        binding.tvBoissonsOui.setOnClickListener {

            if (alcoolDisable) {
                alcoolDisable = false;
                binding.tvBoissonsOui.setTextColor(resources.getColor(R.color.green))
            } else {
                alcoolDisable = true
                binding.tvBoissonsOui.setTextColor(resources.getColor(R.color.dark_red))
            }
        }
        var NouritureDisable = false;
        binding.tvNourritureOui.setOnClickListener {
            if (NouritureDisable) {
                NouritureDisable = false;
                binding.tvNourritureOui.setTextColor(resources.getColor(R.color.green))
            } else {
                NouritureDisable = true
                binding.tvNourritureOui.setTextColor(resources.getColor(R.color.dark_red))
            }
        }
    }
}
/*

Screen :: HostCreationDrinkFoodView

title:: Que y'aura t'il à votre évènement ?
-----style: .ExtraBold, ofSize: 28

En cochant \"Non\", vous empechez toute présence de l'élément en question.
---style: .Medium, ofSize: 12

Boissons
style: .ExtraBold, ofSize: 28

ButtonEmptyComponent(text: noDrink ? "Non" : "Oui", foregroundColor: noDrink ?
 .red : Color.theme.accent,
----accent - 2CD0A8, 17 bold

alcoolPolicy::
text: "Alcool",  --- bold, 16
rightText: isForbiddenAlcool ? "Interdit" : "Autorisé", ------16 medium
image: arrow.2.squarepath

Nous vous rappelons que toute consommation de boisson alcoolisé est strictement prohibé par la loi pour les personnes de moins de 18 ans et implique la responsabilité du consommateur.
---style: .Regular, ofSize: 10 , scondary color

bringDrinkPolicy::
ButtonToggleSwitchComponent(text: "Amener sa boisson",
rightText: isNotBringingDrinks ? "Interdit" : "Autorisé",
accentColor: isNotBringingDrinks ? Color.special.lipstick D54667 : Color.theme.accent 2CD0A8 ,

createBudgetDrinks::
ButtonToggleSwitchComponent(text: isValidatedDrinkBudget ? "Cagnotte créé":"Créer une cagnotte", rightText: "", image:isValidatedDrinkBudget ? "checkmark": "chart.pie.fill", accentColor: isValidatedDrinkBudget ? Color.theme.blue : .white)

Créer une cagnotte signifie blabla lnaoianoeinf description a faire par alex.

Nourriture
style: .ExtraBold, ofSize: 28

ButtonEmptyComponent(text: noDrink ? "Non" : "Oui", foregroundColor: noDrink ? .red : Color.theme.accent,
----accent - 2CD0A8, 17 bold

bringFoodPolicy::
ButtonToggleSwitchComponent(text: "Amener à manger",
rightText: isNotBringingFood ? "Interdit" : "Autorisé",
accentColor: isNotBringingFood ? Color.special.lipstick : Color.theme.accent,

createBudgetFood::
ButtonToggleSwitchComponent(text: isValidatedFoodBudget ? "Cagnotte créé":"Créer une cagnotte", rightText: "", image:isValidatedFoodBudget ? "checkmark": "chart.pie.fill", accentColor: isValidatedFoodBudget ? Color.theme.blue : .white)

Créer une cagnotte signifie blabla lnaoianoeinf description a faire par alex
--.Regular, ofSize: 10

Continuer::
on click:: HostCreationPriceView
 */
