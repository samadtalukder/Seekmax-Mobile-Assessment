package com.samad_talukder.seekmaxhomeassignment.utils

/**
 * Class responsible for managing the authentication token of the user.
 * @param sharedPref Instance of [SharedPref] to handle the shared preferences.
 */

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