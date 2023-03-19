package com.samad_talukder.seekmaxhomeassignment.utils

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class AuthTokenManager(private val sharedPref: SharedPref) {

    fun getToken(): String? {
        return sharedPref.token
    }

    fun saveToken(token: String) {
        sharedPref.token = token
    }

    fun deleteToken() {
        sharedPref.token = null
    }
}