package com.clubin.com.fragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clubin.com.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UserReviewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_review, container, false)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserReviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

/*
--- 4. UserReviewView
title: "Avis", seeMoreText: "Voir tout les avis"

----table - cell ---
ImageCircleComponent(image: "Profil", size: 50)
name --- (style: .Medium, ofSize: 16)
Image(systemName: "star.fill")
I bought this book to understand about the thought process in Ansel's mind. But was disappointed to see that all that has been explained is about the stories behind those photographs.
--- style: .SemiBold, ofSize: 13) secondary color*/
