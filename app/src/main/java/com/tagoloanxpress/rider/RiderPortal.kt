package com.tagoloanxpress.rider

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.dashboard.RiderDashboardScreen
import com.tagoloanxpress.rider.ui.login.RiderLoginScreen
import com.tagoloanxpress.rider.ui.onboarding.*
import com.tagoloanxpress.rider.ui.shared.*

@Composable
fun RiderPortal(onExit: () -> Unit) {
    val context = LocalContext.current.applicationContext
    val store = remember(context) { RiderStore(context) }
    var route by rememberSaveable { mutableStateOf("login") }
    when (route) {
        "application" -> RiderApplicationScreen(store, { route = "pending" }, { route = "login" })
        "pending" -> RiderVerificationScreen(store, { route = "approved" }, { route = "login" })
        "approved" -> RiderApprovedScreen(store) { route = "login" }
        "setup" -> RiderProfileSetupScreen(store, { route = "dashboard" }, { route = "login" })
        "dashboard" -> when {
            store.state.approval != Approval.APPROVED -> RiderVerificationScreen(store, { route = "approved" }, { route = "login" })
            !store.state.profileReady -> RiderProfileSetupScreen(store, { route = "dashboard" }, { route = "login" })
            else -> RiderDashboardScreen(store) { route = "login" }
        }
        "recovery" -> RiderPage("Password Recovery", { route = "login" }) {
            TxPanel { TxTitle("Authentication is not connected"); TxText("The current app is a UI demo. Real password resets require the account backend. No recovery email or SMS has been sent.") }
            TxButton("RETURN TO RIDER LOGIN") { route = "login" }
        }
        else -> RiderLoginScreen(
            onBackClick = onExit,
            onDemoLoginClick = {
                route = when {
                    store.state.approval == Approval.PENDING -> "pending"
                    !store.state.profileReady -> "setup"
                    else -> "dashboard"
                }
            },
            onRegisterClick = { route = "application" },
            onForgotPasswordClick = { route = "recovery" },
        )
    }
}
