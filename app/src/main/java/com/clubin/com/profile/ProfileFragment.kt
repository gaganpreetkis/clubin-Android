package com.clubin.com.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.clubin.com.R
import com.clubin.com.tabbar.TabBarActivity




class ProfileFragment : Fragment() {

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_profile, container, false)
        val imageView: LinearLayout = view.findViewById<View>(R.id.view_center) as LinearLayout
        imageView.setOnClickListener{
            TabBarActivity.mInstance!!.addFragment(ProfileDetailsFragment(),true);
        }
        return view;
    }
}


