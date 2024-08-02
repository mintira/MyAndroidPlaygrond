package com.takobu.mytestapp

import android.app.Application
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val ONESIGNAL_APP_ID = "21bf3bc2-d4c0-4729-8bf6-b7cd0bbcf3f0"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Verbose Logging set to help debug issues, remove before releasing your app.
        OneSignal.Debug.logLevel = LogLevel.VERBOSE

        // OneSignal Initialization
        OneSignal.initWithContext(this, ONESIGNAL_APP_ID)

        // Request permission for notifications
        CoroutineScope(Dispatchers.IO).launch {
            OneSignal.Notifications.requestPermission(false)
        }


//         Check device state and attempt to resubscribe if needed

    }
}
