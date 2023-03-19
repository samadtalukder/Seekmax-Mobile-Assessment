package com.samad_talukder.seekmaxhomeassignment.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.samad_talukder.seekmaxhomeassignment.ui.MainActivity
import com.samad_talukder.seekmaxhomeassignment.api.ApiResult
import com.samad_talukder.seekmaxhomeassignment.databinding.ActivityLoginBinding
import com.samad_talukder.seekmaxhomeassignment.domain.model.LoginRequest
import dagger.hilt.android.AndroidEntryPoint
import java.util.Objects.isNull

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val authViewModel: AuthViewModel by viewModels()
    private lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this

        if (!authViewModel.getTokenPref().isNullOrEmpty()){
            goToMainActivity()
        }

        binding.btnLogin.setOnClickListener {
            val userName = binding.edtUserName.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            observeLoginApi()
            callLoginApi(userName, password)
        }


    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun observeLoginApi() {
        authViewModel.loginResponse.observe(this) { response ->
            when (response) {
                is ApiResult.Loading -> {}

                is ApiResult.Success -> {

                    if (!isNull(response.data)) {
                        response.data.let {
                            authViewModel.setTokenPref(it.access_token)
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                    }
                }
                is ApiResult.Error -> {
                    Toast.makeText(this, "Error: ${response.errorMessage}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun callLoginApi(userName: String, password: String) {
        if (userName.isNotEmpty() && password.isNotEmpty()) {
            val loginRequest = LoginRequest(userName, password)
            authViewModel.login(this, loginRequest)
        } else {
            Snackbar.make(
                binding.root,
                "Please enter your username & password",
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }
}