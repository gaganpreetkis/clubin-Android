package com.clubin.com.themeparty.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.ThemePartyActivityBinding
import com.clubin.com.themeparty.adapter.ThemePartyAdapter
import com.clubin.com.themeparty.model.ThemePartyModel
import com.clubin.com.themeparty.viewmodel.ThemePartyViewModel

class ThemePartyActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ThemePartyActivityBinding
    lateinit var vm: ThemePartyViewModel
    val list: MutableList<ThemePartyModel> = mutableListOf()
    var adapter: ThemePartyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.theme_party_activity)
        vm = ViewModelProvider(this).get(ThemePartyViewModel::class.java)
        binding.mview = vm

        adapter = ThemePartyAdapter(this, list)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        arrayOf(binding.downArrow).forEach { it.setOnClickListener(this) }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.downArrow -> {
                finish()
            }
        }
    }
}