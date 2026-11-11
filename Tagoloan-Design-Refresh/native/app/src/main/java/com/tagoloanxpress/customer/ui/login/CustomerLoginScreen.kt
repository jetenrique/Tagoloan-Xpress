package com.tagoloanxpress.customer.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tagoloanxpress.ui.designsystem.TxRefreshLogin

data class CustomerLoginUiState(
    val identifier: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)

@Composable
fun CustomerLoginScreen(
    state: CustomerLoginUiState,
    onIdentifierChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TxRefreshLogin(rider = false, identifier = state.identifier, password = state.password,
        passwordVisible = state.isPasswordVisible, onIdentifierChange = onIdentifierChange,
        onPasswordChange = onPasswordChange, onTogglePassword = onTogglePasswordVisibility,
        onLogin = onLoginClick, onRegister = onCreateAccountClick,
        onForgot = onForgotPasswordClick, onBack = onBackClick,
        modifier = modifier, loading = state.isLoading, error = state.errorMessage)
}
