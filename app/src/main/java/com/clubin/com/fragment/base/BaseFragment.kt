package com.clubin.com.fragment.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.clubin.com.R


abstract class BaseFragment(@LayoutRes private val screenLayoutId: Int) : Fragment() {
    lateinit var alertDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        processArguments(arguments)
        // injectDaggerComponent()
        registerBackPressListener()

    }

    abstract fun injectDaggerComponent()

    open fun processArguments(arguments: Bundle?) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        restoreInstanceState(savedInstanceState)
        return inflater.inflate(screenLayoutId, container, false)
    }

    open fun restoreInstanceState(savedInstanceState: Bundle?) {
    }

    protected fun show() {
        alertDialog.show()
    }

    protected fun dismiss() {
        alertDialog.let {
            alertDialog.dismiss()
        }
    }

    protected fun fragmentChange(fragment: Fragment) {
        val trans = requireActivity().supportFragmentManager.beginTransaction()
        trans.setCustomAnimations(
            R.anim.slide_in_from_right,
            R.anim.slide_out_to_right,
            R.anim.slide_in_from_right,
            R.anim.slide_out_to_right)
        trans.add(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
        requireActivity().supportFragmentManager.executePendingTransactions()
    }
    // region Navigation
    /**
     * This function is called in the onCreate() of the Base fragment. This will enable the child fragments
     * to receive onBackPress callback and will be cleaner than routing it via the holding activity
     *
     * Ref: https://developer.android.com/guide/navigation/navigation-custom-back
     */
    private fun registerBackPressListener() {
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val consumedInChildFragment = onBackPress()
                    if (!consumedInChildFragment) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })
    }


    open fun onBackPress(): Boolean = false
    // endregion Navigation
}