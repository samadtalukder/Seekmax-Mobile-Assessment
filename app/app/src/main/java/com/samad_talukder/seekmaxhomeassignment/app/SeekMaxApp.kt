package com.samad_talukder.seekmaxhomeassignment.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom application class for the SeekMax app. Extends [Application] and is
 * annotated with [HiltAndroidApp] to enable Hilt dependency injection.
*/

@HiltAndroidApp
class SeekMaxApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}