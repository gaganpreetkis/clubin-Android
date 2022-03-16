package com.clubin.com.fragment.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.clubin.com.R


class ProfileFragment : Fragment() {

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_profile, container, false)
        val profileDetails: LinearLayout = view.findViewById<View>(R.id.ll_contactez) as LinearLayout
        profileDetails.setOnClickListener {
            fragmentChange(ContactUsFragment())
            //TabBarActivity.getInstance()!!.addFragment(ProfileDetailsFragment(),true);
        }

        val profile: LinearLayout = view.findViewById<View>(R.id.ll_profile) as LinearLayout
        profile.setOnClickListener {
            fragmentChange(ProfileDetailsFragment())
        }
        val notification: LinearLayout = view.findViewById<View>(R.id.ll_notification) as LinearLayout
        notification.setOnClickListener {
            fragmentChange(NotificationFragment())
        }
        val lock: LinearLayout = view.findViewById<View>(R.id.ll_lock) as LinearLayout
        lock.setOnClickListener {
            fragmentChange(SecurityFragment())
        }
        val payment: LinearLayout = view.findViewById<View>(R.id.ll_payment) as LinearLayout
        payment.setOnClickListener {
            fragmentChange(PaymentFragment())
        }
        val control: LinearLayout = view.findViewById<View>(R.id.ll_center) as LinearLayout
        control.setOnClickListener {
            fragmentChange(ControlCenterFragment())
        }
        val rate: LinearLayout = view.findViewById<View>(R.id.ll_noter) as LinearLayout
        rate.setOnClickListener {
            fragmentChange(RateReviewFragment())
        }
        return view;
    }

   private fun fragmentChange(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}


