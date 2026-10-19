package com.tagoloanxpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep1Screen
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep1UiState
import com.tagoloanxpress.customer.ui.create.CreatePasugoStep2Screen
import com.tagoloanxpress.customer.ui.dashboard.CustomerDashboardScreen
import com.tagoloanxpress.customer.ui.login.CustomerLoginScreen
import com.tagoloanxpress.customer.ui.login.CustomerLoginUiState
import com.tagoloanxpress.customer.ui.register.CustomerRegistrationScreen
import com.tagoloanxpress.customer.ui.register.CustomerRegistrationUiState
import com.tagoloanxpress.ui.welcome.WelcomePortalScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentScreen by remember { mutableStateOf("welcome") }

            var loginState by remember { mutableStateOf(CustomerLoginUiState()) }
            var registerState by remember { mutableStateOf(CustomerRegistrationUiState()) }
            var step1State by remember { mutableStateOf(CreatePasugoStep1UiState()) }

            when (currentScreen) {
                "welcome" -> {
                    WelcomePortalScreen(
                        onCustomerClick = { currentScreen = "customer_login" },
                        onRiderClick = {},
                        onAdminClick = {}
                    )
                }
                "customer_login" -> {
                    CustomerLoginScreen(
                        state = loginState,
                        onIdentifierChange = { loginState = loginState.copy(identifier = it) },
                        onPasswordChange = { loginState = loginState.copy(password = it) },
                        onTogglePasswordVisibility = { loginState = loginState.copy(isPasswordVisible = !loginState.isPasswordVisible) },
                        onLoginClick = { currentScreen = "customer_dashboard" },
                        onForgotPasswordClick = {},
                        onCreateAccountClick = { currentScreen = "customer_register" },
                        onBackClick = { currentScreen = "welcome" }
                    )
                }
                "customer_register" -> {
                    CustomerRegistrationScreen(
                        state = registerState,
                        onFullNameChange = { registerState = registerState.copy(fullName = it) },
                        onMobileNumberChange = { registerState = registerState.copy(mobileNumber = it) },
                        onEmailChange = { registerState = registerState.copy(email = it) },
                        onPasswordChange = { registerState = registerState.copy(password = it) },
                        onConfirmPasswordChange = { registerState = registerState.copy(confirmPassword = it) },
                        onTogglePasswordVisibility = { registerState = registerState.copy(isPasswordVisible = !registerState.isPasswordVisible) },
                        onToggleConfirmPasswordVisibility = { registerState = registerState.copy(isConfirmPasswordVisible = !registerState.isConfirmPasswordVisible) },
                        onAcceptedTermsChange = { registerState = registerState.copy(acceptedTerms = it) },
                        onTermsLinkClick = {},
                        onCreateAccountClick = { currentScreen = "customer_dashboard" },
                        onLoginHereClick = { currentScreen = "customer_login" },
                        onBackClick = { currentScreen = "customer_login" },
                        onProfileIconClick = {}
                    )
                }
                "customer_dashboard" -> {
                    CustomerDashboardScreen(
                        customerName = if (registerState.fullName.isNotBlank()) registerState.fullName else "Neil Dairo",
                        onCreatePasugoClick = { currentScreen = "pasugo_step_1" },
                        onTrackDeliveryClick = {}
                    )
                }
                "pasugo_step_1" -> {
                    CreatePasugoStep1Screen(
                        state = step1State,
                        onCategorySelect = { step1State = step1State.copy(selectedCategory = it) },
                        onItemNameChange = { step1State = step1State.copy(itemName = it) },
                        onQuantityChange = { step1State = step1State.copy(quantity = it) },
                        onInstructionsChange = { step1State = step1State.copy(instructions = it) },
                        onBudgetChange = { step1State = step1State.copy(budget = it) },
                        onPaymentSelect = { step1State = step1State.copy(selectedPayment = it) },
                        onNextClick = { currentScreen = "pasugo_step_2" },
                        onBackClick = { currentScreen = "customer_dashboard" }
                    )
                }
                "pasugo_step_2" -> {
                    CreatePasugoStep2Screen(
                        onConfirmClick = { currentScreen = "customer_dashboard" },
                        onBackClick = { currentScreen = "pasugo_step_1" }
                    )
                }
            }
        }
    }
}