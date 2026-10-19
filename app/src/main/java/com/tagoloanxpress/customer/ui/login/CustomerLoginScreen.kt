package com.tagoloanxpress.customer.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)
private val Cream = Color(0xFFFFFDF7)
private val Muted = Color(0xFF666666)

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
    val canSubmit = state.identifier.isNotBlank() && state.password.isNotBlank() && !state.isLoading
    Column(
        modifier.fillMaxSize().background(Cream).statusBarsPadding().navigationBarsPadding().imePadding()
            .verticalScroll(rememberScrollState()).padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 24.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack, "Back",
                Modifier.size(26.dp).clip(RoundedCornerShape(8.dp)).clickable(onClick = onBackClick).padding(2.dp),
                tint = Ink,
            )
            Spacer(Modifier.width(16.dp))
            Text("Customer Portal", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black, color = Ink))
        }
        Spacer(Modifier.height(12.dp))
        Box(
            Modifier.background(Amber, RoundedCornerShape(8.dp)).border(2.dp, Ink, RoundedCornerShape(8.dp))
                .padding(horizontal = 18.dp, vertical = 8.dp),
        ) { Text("TAGOLOAN XPRESS", style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Black, color = Ink)) }
        Spacer(Modifier.height(18.dp))
        Text("Welcome Back!", style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Black, color = Ink))
        Spacer(Modifier.height(8.dp))
        Text("Login to request errands and deliveries in Tagoloan.", textAlign = TextAlign.Center, color = Muted, fontSize = 14.sp)
        Spacer(Modifier.height(32.dp))
        if (state.errorMessage != null) {
            Text(state.errorMessage, Modifier.fillMaxWidth().background(Color(0xFFFDECEA), RoundedCornerShape(12.dp)).padding(12.dp), color = Color(0xFFD32F2F))
            Spacer(Modifier.height(16.dp))
        }
        LoginInput("Mobile Number or Email", state.identifier, onIdentifierChange, "09XX XXX XXXX", KeyboardType.Email, !state.isLoading)
        Spacer(Modifier.height(20.dp))
        LoginInput(
            "Password", state.password, onPasswordChange, "••••••••", KeyboardType.Password, !state.isLoading,
            if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        ) {
            IconButton(onClick = onTogglePasswordVisibility, Modifier.size(32.dp)) {
                Icon(if (state.isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff, "Toggle password", tint = Muted)
            }
        }
        Box(Modifier.fillMaxWidth()) {
            Text("Forgot Password?", Modifier.align(Alignment.CenterEnd).clickable(!state.isLoading, onClick = onForgotPasswordClick).padding(vertical = 4.dp), style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = Ink, textDecoration = TextDecoration.Underline))
        }
        Spacer(Modifier.height(24.dp))
        LoginButton("LOGIN AS CUSTOMER", canSubmit, state.isLoading, onLoginClick)
        Spacer(Modifier.height(28.dp))
        Text("Don't have a customer account?", color = Muted, fontSize = 13.sp)
        Spacer(Modifier.height(14.dp))
        Box(Modifier.fillMaxWidth().height(54.dp).clip(RoundedCornerShape(14.dp)).background(Color.White).border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable(!state.isLoading, onClick = onCreateAccountClick), contentAlignment = Alignment.Center) {
            Text("CREATE NEW ACCOUNT", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Ink))
        }
        Spacer(Modifier.weight(1f))
        Row(Modifier.padding(vertical = 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Icon(Icons.Filled.LocalShipping, null, tint = Color(0xFFB0B0B0), modifier = Modifier.size(16.dp))
            Spacer(Modifier.width(6.dp))
            Text("SECURED ERRANDS & DELIVERIES", color = Color(0xFFB0B0B0), fontSize = 11.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

@Composable
private fun LoginInput(label: String, value: String, onValueChange: (String) -> Unit, placeholder: String, keyboardType: KeyboardType, enabled: Boolean, transformation: VisualTransformation = VisualTransformation.None, trailing: (@Composable () -> Unit)? = null) {
    Column(Modifier.fillMaxWidth()) {
        Text(label, Modifier.padding(bottom = 8.dp), style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Ink))
        val shape = RoundedCornerShape(14.dp)
        BasicTextField(value, onValueChange, Modifier.fillMaxWidth(), enabled = enabled, singleLine = true, textStyle = TextStyle(fontSize = 16.sp, color = Ink), cursorBrush = SolidColor(Ink), visualTransformation = transformation, keyboardOptions = KeyboardOptions(keyboardType = keyboardType), decorationBox = { inner ->
            Row(Modifier.fillMaxWidth().height(56.dp).background(Color.White, shape).border(2.dp, Ink, shape).padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.weight(1f)) { if (value.isEmpty()) Text(placeholder, color = Color(0xFF9E9E9E), fontSize = 16.sp); inner() }
                trailing?.invoke()
            }
        })
    }
}

@Composable
private fun LoginButton(label: String, enabled: Boolean, loading: Boolean, onClick: () -> Unit) {
    val shape = RoundedCornerShape(14.dp)
    Box(Modifier.fillMaxWidth().padding(end = 4.dp, bottom = 4.dp).height(56.dp).drawBehind { drawRoundRect(Ink, androidx.compose.ui.geometry.Offset(3.dp.toPx(), 4.dp.toPx()), size, androidx.compose.ui.geometry.CornerRadius(14.dp.toPx())) }.clip(shape).background(if (enabled || loading) Amber else Amber.copy(.6f)).border(2.dp, Ink, shape).clickable(enabled, onClick = onClick), contentAlignment = Alignment.Center) {
        if (loading) CircularProgressIndicator(Modifier.size(24.dp), color = Ink, strokeWidth = 3.dp) else Text(label, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Black, color = Ink))
    }
}
