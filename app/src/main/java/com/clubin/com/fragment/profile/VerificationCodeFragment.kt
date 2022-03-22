package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R
import com.clubin.com.databinding.TelePhoneEditFragmentDataBinding
import com.clubin.com.databinding.VerificationCodeFragmentDataBinding
import com.clubin.com.fragment.base.BaseDataBindingFragment
import com.clubin.com.fragment.profile.callbacks.ContactUsFragmentCallback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VerificationCodeFragment : BaseDataBindingFragment<VerificationCodeFragmentDataBinding>
    (R.layout.fragment_verification_code),
    ContactUsFragmentCallback {

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
            VerificationCodeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDataBindingCreated() {
        binding.button.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}

/*Screen:  AccountVerificationCodeView

Entrez votre *Code de confirmation*.
---- style: .Medium, ofSize: 16.  white

Code
-- Bold, ofSize: 18

Vérifier le code
--2CD0A8.   cornerRadius: 10.   white.     bold*/

