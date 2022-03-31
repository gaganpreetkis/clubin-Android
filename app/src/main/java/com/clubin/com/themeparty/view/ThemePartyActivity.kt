package com.clubin.com.themeparty.view

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.clubin.com.R
import com.clubin.com.databinding.ThemePartyActivityBinding
import com.clubin.com.fragment.event.view.BottomSheetClockFragment
import com.clubin.com.fragment.event.view.BottomSheetFilterFragment
import com.clubin.com.themeparty.adapter.ThemePartyAdapter
import com.clubin.com.themeparty.model.ThemePartyModel
import com.clubin.com.themeparty.viewmodel.ThemePartyViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.bottomsheet.BottomSheetDialog




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

        arrayOf(binding.downArrow, binding.llFilter, binding.llClock).forEach { it.setOnClickListener(this) }
    }


    override fun onClick(p0: View?) {
        when (p0) {
            binding.downArrow -> {
                finish()
            }
            binding.llFilter -> {
                val fragment = BottomSheetFilterFragment()
                fragment.show(supportFragmentManager,fragment::class.java.simpleName)
             /*   val d = dialog as BottomSheetDialog
                val bottomSheet = d.findViewById<View>(R.id.) as FrameLayout
                val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED*/
            }
            binding.llClock -> {
                val fragment = BottomSheetClockFragment()
                fragment.show(supportFragmentManager, fragment::class.java.simpleName)
            }
        }
    }


}