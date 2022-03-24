package com.clubin.com.auth.signup.views

import android.os.Bundle
import com.clubin.com.R
import com.clubin.com.databinding.SignUpEmailFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.AccountEditFragmentCallback


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SignUpEmailFragment : BaseDataBindingFragment<SignUpEmailFragmentDataBinding>
    (R.layout.fragment_sign_up_email), AccountEditFragmentCallback {
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
            SignUpEmailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.button.setOnClickListener {
            fragmentChange(SignUpPasswordFragment())
        }
    }
}