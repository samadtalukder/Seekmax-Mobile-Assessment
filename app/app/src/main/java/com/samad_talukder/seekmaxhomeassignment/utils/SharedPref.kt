package com.samad_talukder.seekmaxhomeassignment.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.samad_talukder.seekmaxhomeassignment.utils.Constants.PREFS_KEY_TOKEN
import com.samad_talukder.seekmaxhomeassignment.utils.Constants.PREFS_NAME
import javax.inject.Inject

/**
 * Created by Samad Talukder on 18 March 2023.
 * github.com/samadtalukder
 **/

class SharedPref @Inject constructor(application: Application) {

    private val preferences = application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var token: String?
        get() = preferences.getString(PREFS_KEY_TOKEN, null)
        set(value) = preferences.edit().putString(PREFS_KEY_TOKEN, value).apply()

    fun clear() {
        preferences.edit().clear().apply()
    }

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }


}