package com.samad_talukder.seekmaxhomeassignment.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.samad_talukder.seekmaxhomeassignment.databinding.FragmentMyProfileBinding
import com.samad_talukder.seekmaxhomeassignment.ui.auth.AuthViewModel
import com.samad_talukder.seekmaxhomeassignment.ui.auth.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

@AndroidEntryPoint
class MyProfileFragment : Fragment() {
    private lateinit var binding: FragmentMyProfileBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvLogout.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            authViewModel.clearTokenPref()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

}