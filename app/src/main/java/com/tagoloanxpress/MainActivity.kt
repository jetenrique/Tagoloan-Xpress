package com.tagoloanxpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep1Screen
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep1UiState
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep2Screen
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep3Screen
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep4Screen
import com.tagoloanxpress.customer.ui.create.PasugoLiveDispatchScreen
import com.tagoloanxpress.customer.ui.dashboard.CustomerDashboardScreen
import com.tagoloanxpress.customer.ui.history.CustomerHistoryScreen
import com.tagoloanxpress.customer.ui.login.CustomerLoginScreen
import com.tagoloanxpress.customer.ui.login.CustomerLoginUiState
import com.tagoloanxpress.customer.ui.register.CustomerRegistrationScreen
import com.tagoloanxpress.customer.ui.register.CustomerRegistrationUiState
import com.tagoloanxpress.customer.ui.profile.CustomerProfileScreen
import com.tagoloanxpress.customer.ui.receipt.CustomerReceiptReviewScreen
import com.tagoloanxpress.customer.ui.receipt.CustomerViewReceiptScreen
import com.tagoloanxpress.customer.ui.tracking.CustomerActiveTrackingScreen
import com.tagoloanxpress.ui.welcome.WelcomePortalScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { TagoloanApp() }
    }
}

@Composable
private fun TagoloanApp() {
    var screen by remember { mutableStateOf("welcome") }
    var login by remember { mutableStateOf(CustomerLoginUiState()) }
    var registration by remember { mutableStateOf(CustomerRegistrationUiState()) }
    var step1 by remember { mutableStateOf(CreatePasugoStep1UiState()) }
    var deliveryAddress by remember { mutableStateOf("Zone 3, Mohon, Tagoloan") }

    when (screen) {
        "welcome" -> WelcomePortalScreen(
            onCustomerClick = { screen = "customer_login" },
            onRiderClick = {},
            onAdminClick = {},
        )
        "customer_login" -> CustomerLoginScreen(
            state = login,
            onIdentifierChange = { login = login.copy(identifier = it) },
            onPasswordChange = { login = login.copy(password = it) },
            onTogglePasswordVisibility = { login = login.copy(isPasswordVisible = !login.isPasswordVisible) },
            onLoginClick = { screen = "customer_dashboard" },
            onForgotPasswordClick = {},
            onCreateAccountClick = { screen = "customer_register" },
            onBackClick = { screen = "welcome" },
        )
        "customer_register" -> CustomerRegistrationScreen(
            state = registration,
            onFullNameChange = { registration = registration.copy(fullName = it) },
            onMobileNumberChange = { registration = registration.copy(mobileNumber = it) },
            onEmailChange = { registration = registration.copy(email = it) },
            onPasswordChange = { registration = registration.copy(password = it) },
            onConfirmPasswordChange = { registration = registration.copy(confirmPassword = it) },
            onTogglePasswordVisibility = { registration = registration.copy(isPasswordVisible = !registration.isPasswordVisible) },
            onToggleConfirmPasswordVisibility = { registration = registration.copy(isConfirmPasswordVisible = !registration.isConfirmPasswordVisible) },
            onAcceptedTermsChange = { registration = registration.copy(acceptedTerms = it) },
            onTermsLinkClick = {},
            onCreateAccountClick = { screen = "customer_dashboard" },
            onLoginHereClick = { screen = "customer_login" },
            onBackClick = { screen = "customer_login" },
            onProfileIconClick = {},
        )
        "customer_dashboard" -> CustomerDashboardScreen(
            customerName = registration.fullName.ifBlank { "Neil Dairo" },
            onCreatePasugoClick = { screen = "pasugo_step_1" },
            onTrackDeliveryClick = { screen = "pasugo_live_dispatch" },
            onNavigateHistory = { screen = "customer_history" },
            onNavigateProfile = { screen = "customer_profile" },
        )
        "pasugo_step_1" -> CreatePasugoStep1Screen(
            state = step1,
            onCategorySelect = { step1 = step1.copy(selectedCategory = it) },
            onItemNameChange = { step1 = step1.copy(itemName = it) },
            onQuantityChange = { step1 = step1.copy(quantity = it) },
            onInstructionsChange = { step1 = step1.copy(instructions = it) },
            onBudgetChange = { step1 = step1.copy(budget = it) },
            onPaymentSelect = { step1 = step1.copy(selectedPayment = it) },
            onNextClick = { screen = "pasugo_step_2" },
            onBackClick = { screen = "customer_dashboard" },
        )
        "pasugo_step_2" -> CreatePasugoStep2Screen(
            onConfirmClick = { screen = "pasugo_step_3" },
            onBackClick = { screen = "pasugo_step_1" },
        )
        "pasugo_step_3" -> CreatePasugoStep3Screen(
            selectedAddress = deliveryAddress,
            onAddressChange = { deliveryAddress = it },
            onConfirmClick = { screen = "pasugo_step_4" },
            onBackClick = { screen = "pasugo_step_2" },
        )
        "pasugo_step_4" -> CreatePasugoStep4Screen(
            itemName = step1.itemName,
            quantity = step1.quantity,
            instructions = step1.instructions,
            budget = step1.budget,
            paymentMethod = if (step1.selectedPayment == "GCash") "GCash" else "Cash on Delivery (COD)",
            deliveryTitle = deliveryAddress,
            onPostRequestConfirmed = { screen = "pasugo_live_dispatch" },
            onBackClick = { screen = "pasugo_step_3" },
        )
        "pasugo_live_dispatch" -> PasugoLiveDispatchScreen(
            itemName = step1.itemName,
            quantity = step1.quantity,
            instructions = step1.instructions,
            budget = step1.budget,
            onTrackDeliveryNowClick = { screen = "customer_tracking" },
            onCancelRequestClick = { screen = "customer_dashboard" },
            onCloseClick = { screen = "customer_dashboard" },
        )
        "customer_tracking" -> CustomerActiveTrackingScreen(
            itemName = step1.itemName, quantity = step1.quantity, budget = step1.budget,
            instructions = step1.instructions,
            onOrderCompleted = { screen = "customer_receipt_review" },
            onNavigateHome = { screen = "customer_dashboard" },
            onNavigateCreate = { screen = "pasugo_step_1" },
            onNavigateHistory = { screen = "customer_history" },
            onNavigateProfile = { screen = "customer_profile" },
            onBackClick = { screen = "customer_dashboard" },
        )
        "customer_receipt_review" -> CustomerReceiptReviewScreen(
            itemName = step1.itemName,
            quantity = step1.quantity,
            onViewDetailedReceiptClick = { screen = "customer_receipt" },
            onSubmitAndReturnHome = { screen = "customer_dashboard" },
        )
        "customer_receipt" -> CustomerViewReceiptScreen(onCloseReceiptClick = { screen = "customer_history" })
        "customer_history" -> CustomerHistoryScreen(
            onViewReceiptClick = { screen = "customer_receipt" },
            onNavigateHome = { screen = "customer_dashboard" },
            onNavigateCreate = { screen = "pasugo_step_1" },
            onNavigateActive = { screen = "customer_tracking" },
            onNavigateProfile = { screen = "customer_profile" },
            onBackClick = { screen = "customer_dashboard" },
        )
        "customer_profile" -> CustomerProfileScreen(
            customerName = registration.fullName.ifBlank { "Neil Dairo" },
            onHistoryReceiptsClick = { screen = "customer_history" },
            onLogoutClick = { screen = "welcome" },
            onNavigateHome = { screen = "customer_dashboard" },
            onNavigateRequests = { screen = "pasugo_step_1" },
            onNavigateActive = { screen = "customer_tracking" },
            onNavigateHistory = { screen = "customer_history" },
            onBackClick = { screen = "customer_dashboard" },
        )
    }
}
