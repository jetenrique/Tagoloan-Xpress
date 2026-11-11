package com.tagoloanxpress.rider.ui.login

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.tagoloanxpress.ui.designsystem.TxRefreshLogin

@Composable
fun RiderLoginScreen(
    onBackClick: () -> Unit, onDemoLoginClick: () -> Unit,
    onRegisterClick: () -> Unit, onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var identifier by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visible by rememberSaveable { mutableStateOf(false) }
    TxRefreshLogin(rider = true, identifier = identifier, password = password,
        passwordVisible = visible, onIdentifierChange = { identifier = it },
        onPasswordChange = { password = it }, onTogglePassword = { visible = !visible },
        onLogin = { if (identifier.isNotBlank() && password.isNotBlank()) onDemoLoginClick() },
        onRegister = onRegisterClick, onForgot = onForgotPasswordClick,
        onBack = onBackClick, modifier = modifier)
}
