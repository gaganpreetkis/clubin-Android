package com.clubin.com.fragment.event.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clubin.com.R
import com.clubin.com.databinding.EventFragmentBinding
import com.clubin.com.fragment.event.adapter.EventAdapter
import com.clubin.com.fragment.event.model.EventModel
import com.clubin.com.fragment.event.viewmodel.EventViewModel
import com.clubin.com.themeparty.view.ThemePartyActivity

class EventFragment : Fragment(), View.OnClickListener {

    private lateinit var vm: EventViewModel
    private lateinit var mContext: Context
    private lateinit var binding: EventFragmentBinding

    val list: MutableList<EventModel> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity?.run {
            ViewModelProvider(this@EventFragment).get(EventViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.event_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        setupRecyclerViews()
    }

    private fun setupClickListeners() {
        binding.clubinNights.setOnClickListener(this)
        binding.clubinDiscovery.setOnClickListener(this)
    }

    private fun setupRecyclerViews() {
        val adapter = EventAdapter(mContext, list)
        var layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)

        binding.populairesRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.arriveRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.milleRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.discoveriesRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.newHostsRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.goodVibesRecycler.layoutManager = layoutManager
        layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.bestHostsRecycler.layoutManager = layoutManager

        binding.populairesRecycler.adapter = adapter
        binding.arriveRecycler.adapter = adapter
        binding.milleRecycler.adapter = adapter
        binding.discoveriesRecycler.adapter = adapter
        binding.newHostsRecycler.adapter = adapter
        binding.goodVibesRecycler.adapter = adapter
        binding.bestHostsRecycler.adapter = adapter

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.clubinNights -> {
                val intent = Intent(mContext, ThemePartyActivity::class.java)
                startActivity(intent)
            }
            binding.clubinDiscovery -> {
                val intent = Intent(mContext, ThemePartyActivity::class.java)
                startActivity(intent)
            }
        }
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
