package com.takobu.mytestapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.onesignal.OneSignal
import com.takobu.mytestapp.screen.LoginScreen
import com.takobu.mytestapp.screen.LogoutScreen

@Composable
fun AppContent() {

    val context = LocalContext.current
    val sharedPrefsManager = SharePrefsManager(context)
    var isLoggedIn by remember {
        mutableStateOf(sharedPrefsManager.getBoolean("is_login"))
    }

    LaunchedEffect(isLoggedIn) {
        //update tag is login
        OneSignal.User.addTags(
            mapOf(
                "is_login" to "$isLoggedIn"
            )
        )
    }

    if (isLoggedIn) {
        LogoutScreen(onLogout = {
            OneSignal.logout()
            isLoggedIn = false
            sharedPrefsManager.putBoolean(
                "is_login", false
            )
        })
    } else {
        LoginScreen(onLogin = {
            val userId = "user123"
            OneSignal.login(userId)
            isLoggedIn = true
            sharedPrefsManager.putBoolean(
                "is_login", true
            )
        })
    }
}