package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samad_talukder.seekmaxhomeassignment.R

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class MyApplicationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_applications, container, false)
    }

}