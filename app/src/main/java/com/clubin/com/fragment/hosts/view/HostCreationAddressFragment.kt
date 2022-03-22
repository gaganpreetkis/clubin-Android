package com.clubin.com.fragment.hosts.view

import android.content.Context
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
import com.clubin.com.databinding.HostCreationAddressFragmentBinding
import com.clubin.com.fragment.hosts.adapter.HostCreationAddressRegisteredAdapter
import com.clubin.com.fragment.hosts.adapter.HostCreationAddressResultAdapter
import com.clubin.com.fragment.hosts.viewmodel.HostCreationAddressViewModel

class HostCreationAddressFragment : Fragment() {

    private lateinit var mContext: Context
    val TAG = this::class.java.simpleName
    lateinit var vm: HostCreationAddressViewModel
    lateinit var binding: HostCreationAddressFragmentBinding
    var addressAdapter: HostCreationAddressResultAdapter? = null
    var registeredAdapter: HostCreationAddressRegisteredAdapter? = null
    val list: MutableList<String> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = activity.run {
            ViewModelProvider(this@HostCreationAddressFragment).get(HostCreationAddressViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.host_creation_address_fragment, container, false)
        binding.mview = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add("11 rue de l'harmonie")
        list.add("6 rue de la salpetriere")

        registeredAdapter = HostCreationAddressRegisteredAdapter(mContext, list)
        binding.alreadyRegisteredRecycler.layoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        binding.alreadyRegisteredRecycler.adapter = registeredAdapter

        addressAdapter = HostCreationAddressResultAdapter(mContext, list)
        binding.addressRecycler.layoutManager = LinearLayoutManager(mContext)
        binding.addressRecycler.adapter = addressAdapter
    }
}