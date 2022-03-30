package com.clubin.com.fragment.event.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
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
import com.clubin.com.fragment.eventdetail.view.EventDetailFragment
import com.clubin.com.fragment.message.view.MessageMainFragment
import com.clubin.com.tabbar.TabBarActivity
import com.clubin.com.themeparty.view.ThemePartyActivity

class EventFragment : Fragment(), View.OnClickListener {
    var  backPressedListener : BackPressedListener? = null
    private lateinit var vm: EventViewModel
    private lateinit var mContext: Context
    private lateinit var binding: EventFragmentBinding

    val list: MutableList<EventModel> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        if (context is BackPressedListener) {
            backPressedListener =  context as BackPressedListener
        } else {
            throw RuntimeException(context.toString() )
        }
    }
    fun setOnEventListener(listener: BackPressedListener) {
        this.backPressedListener = listener
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
        binding.ivFilter.setOnClickListener {
            backPressedListener?.onItemClick(1);
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        setupRecyclerViews()

        val tf = ResourcesCompat.getFont(mContext, R.font.montserrat_alternates_semibold)
        val searchText = binding.searchView.findViewById<View>(androidx.appcompat.R.id.search_src_text) as TextView
        searchText.typeface = tf
    }

    private fun setupClickListeners() {
        arrayOf(binding.messageView, binding.clubinNights, binding.clubinDiscovery).forEach { it.setOnClickListener(this) }
    }

    private fun setupRecyclerViews() {
        val adapter = EventAdapter(mContext, list, object : EventAdapter.EventClickListener{
            override fun onEventClick(pos: Int) {
                (activity as TabBarActivity)?.let {
                    it.addFragment(EventDetailFragment(), true)
                }
            }

        })
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
            binding.messageView -> {
                (activity as TabBarActivity)?.let {
                    it.addFragment(MessageMainFragment(), true)
                }
            }
        }
    }

    interface BackPressedListener{
        fun onItemClick(position: Int)
    }
}