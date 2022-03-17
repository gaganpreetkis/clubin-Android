package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VirementsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_virements, container, false)
    }

}

/*
Screen :: Virements (MenuTransferView)
opens on click :: --- MenuView - Paiement - Virements

nav title: Virements

view 1: transferHeader

Où est mon argent ?
---- (style: .Medium, ofSize: 16)

Votre argent a été envoyé. Il arrivera sur votre compte bancaire dans les 5 jours ouvrés.
-----(style: .Medium, ofSize: 12) secondary color

- Divider - color - accent - 2CD0A8 cornerRadius(20)

- tableview - transferData
- cell

Text(transfer.name)
.headline()
Text(transfer.event)
.body()
Text(transfer.date)
.footnote()
.foregroundColor(.secondary)

Text(transfer.money)
.headline()
Text("Effectué le \n\(transfer.when)")
.footnote()
.foregroundColor(.secondary)


HeadlineFont - style: .Bold, ofSize: 22)
body - (style: .Medium, ofSize: 16)
footnote- style: .Medium, ofSize: 12)


Transfer model and dummy values
struct Transfer: Identifiable {
    var id = UUID()
    var name: String
    var pic: String
    var event: String
    var date: String
    var money: String
    var when: String
}


let transferData: [Transfer] = [
Transfer (name: "Paris", pic: "Paris", event: "Best Wine Party Ever", date: "29/10/2020", money: "18 €", when: "04/11/2020"),
Transfer (name: "Annie", pic: "Annie", event: "Big fiesta", date: "29/10/2020", money: "18 €", when: "04/11/2020"),
Transfer (name: "Alex", pic: "Alex", event: "DJ Period", date: "29/10/2020", money: "18 €", when: "04/11/2020")
]
*/

