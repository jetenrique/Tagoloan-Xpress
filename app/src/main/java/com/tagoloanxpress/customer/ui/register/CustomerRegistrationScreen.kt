package com.tagoloanxpress.customer.ui.register

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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFF7B519)
private val Ink = Color(0xFF1A1A1A)
private val Cream = Color(0xFFFAF6EC)
private val Muted = Color(0xFF635E54)

data class CustomerRegistrationUiState(
    val fullName: String = "", val mobileNumber: String = "", val email: String = "",
    val password: String = "", val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false, val isConfirmPasswordVisible: Boolean = false,
    val acceptedTerms: Boolean = true, val isLoading: Boolean = false, val errorMessage: String? = null,
)

@Composable
fun CustomerRegistrationScreen(
    state: CustomerRegistrationUiState,
    onFullNameChange: (String) -> Unit,
    onMobileNumberChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onToggleConfirmPasswordVisibility: () -> Unit,
    onAcceptedTermsChange: (Boolean) -> Unit,
    onTermsLinkClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onLoginHereClick: () -> Unit,
    onBackClick: () -> Unit,
    onProfileIconClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val canSubmit = state.fullName.isNotBlank() && state.mobileNumber.isNotBlank() &&
        state.password.isNotBlank() && state.password == state.confirmPassword &&
        state.acceptedTerms && !state.isLoading
    Column(modifier.fillMaxSize().background(Cream).statusBarsPadding().navigationBarsPadding()) {
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onBackClick) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Ink) }
            Text("Create Customer Account", Modifier.weight(1f), style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = Ink))
            Box(Modifier.size(36.dp).clip(RoundedCornerShape(20.dp)).background(Color(0xFF6E5000)).clickable(onClick = onProfileIconClick), contentAlignment = Alignment.Center) {
                Icon(Icons.Outlined.Person, "Account", tint = Color.White)
            }
        }
        HorizontalDivider(color = Color(0xFFEAE3D2))
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(20.dp))
            Row(Modifier.background(Amber, RoundedCornerShape(14.dp)).border(2.dp, Ink, RoundedCornerShape(14.dp)).padding(horizontal = 18.dp, vertical = 9.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("TAGOLOAN XPRESS", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black, color = Ink))
            }
            Text("PASUGO", Modifier.padding(start = 150.dp).background(Color(0xFFFFDEA6), RoundedCornerShape(50)).padding(horizontal = 10.dp, vertical = 3.dp), fontSize = 9.sp, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(16.dp))
            Text("Join TAGOLOAN XPRESS", style = TextStyle(fontSize = 23.sp, fontWeight = FontWeight.Black, color = Ink))
            Spacer(Modifier.height(6.dp))
            Text("Sign up to request fast Pasugo errands, food, and\nparcel deliveries.", color = Muted, fontSize = 13.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.height(18.dp))
            Box(Modifier.fillMaxWidth().height(132.dp).clip(RoundedCornerShape(16.dp)).background(Color(0xFF3D2A0B)), contentAlignment = Alignment.Center) {
                Icon(Icons.Filled.TwoWheeler, null, tint = Color.White.copy(.12f), modifier = Modifier.size(110.dp).align(Alignment.CenterEnd))
                Column(horizontalAlignment = Alignment.CenterHorizontally) { Text("WHAT DO YOU NEED?", color = Color(0xFFFFDEA6), fontSize = 11.sp); Text("AND WHERE SHOULD WE GET IT?", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Black) }
            }
            Spacer(Modifier.height(22.dp))
            RegisterInput("Full Name", state.fullName, onFullNameChange, "Neil Dairo", Icons.Outlined.Person, !state.isLoading)
            Spacer(Modifier.height(16.dp))
            RegisterInput("Mobile Number", state.mobileNumber, onMobileNumberChange, "917 123 4567", null, !state.isLoading, prefix = "PH   +63", keyboard = KeyboardType.Phone)
            Spacer(Modifier.height(16.dp))
            RegisterInput("Email Address (Optional for updates)", state.email, onEmailChange, "name@email.com", Icons.Outlined.Email, !state.isLoading, keyboard = KeyboardType.Email)
            Spacer(Modifier.height(16.dp))
            RegisterInput("Password", state.password, onPasswordChange, "••••••••", Icons.Outlined.Lock, !state.isLoading, if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation())
            Spacer(Modifier.height(16.dp))
            RegisterInput("Confirm Password", state.confirmPassword, onConfirmPasswordChange, "••••••••", Icons.Outlined.Lock, !state.isLoading, if (state.isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation())
            Spacer(Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth().background(Color(0xFFFCECD2), RoundedCornerShape(14.dp)).padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.NotificationsActive, null, tint = Ink, modifier = Modifier.size(24.dp)); Spacer(Modifier.width(10.dp)); Text("Your mobile number will be used for rapid delivery updates, SMS fallback, and direct rider dispatch calls.", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(18.dp))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                Box(Modifier.size(20.dp).background(if (state.acceptedTerms) Amber else Color.White, RoundedCornerShape(5.dp)).border(1.dp, Ink, RoundedCornerShape(5.dp)).clickable { onAcceptedTermsChange(!state.acceptedTerms) }, contentAlignment = Alignment.Center) { if (state.acceptedTerms) Icon(Icons.Filled.Check, "Checked", modifier = Modifier.size(14.dp), tint = Ink) }
                Spacer(Modifier.width(10.dp))
                val terms = buildAnnotatedString { append("I agree to the "); pushStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, textDecoration = TextDecoration.Underline, color = Ink)); append("Terms of Service"); pop(); append(" and acknowledge Tagoloan Express delivery policies.") }
                Text(terms, Modifier.weight(1f).clickable(onClick = onTermsLinkClick), color = Muted, fontSize = 12.sp)
            }
            Spacer(Modifier.height(22.dp))
            Box(Modifier.fillMaxWidth().height(54.dp).background(if (canSubmit || state.isLoading) Amber else Amber.copy(.55f), RoundedCornerShape(14.dp)).clickable(canSubmit, onClick = onCreateAccountClick), contentAlignment = Alignment.Center) {
                if (state.isLoading) CircularProgressIndicator(Modifier.size(24.dp), color = Ink) else Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) { Text("CREATE ACCOUNT", fontWeight = FontWeight.ExtraBold); Icon(Icons.AutoMirrored.Filled.ArrowForward, null, modifier = Modifier.size(18.dp)) }
            }
            Spacer(Modifier.height(24.dp)); Text("Already have an account?", color = Muted, fontSize = 13.sp); Spacer(Modifier.height(8.dp))
            Row(Modifier.clip(RoundedCornerShape(8.dp)).clickable(onClick = onLoginHereClick).padding(12.dp), verticalAlignment = Alignment.CenterVertically) { Text("LOGIN HERE", fontSize = 15.sp, fontWeight = FontWeight.Black, color = Color(0xFF6E5000), textDecoration = TextDecoration.Underline); Icon(Icons.AutoMirrored.Filled.Login, null, tint = Color(0xFF6E5000), modifier = Modifier.size(18.dp)) }
            Spacer(Modifier.height(28.dp))
        }
    }
}

@Composable
private fun RegisterInput(label: String, value: String, onValueChange: (String) -> Unit, placeholder: String, icon: androidx.compose.ui.graphics.vector.ImageVector?, enabled: Boolean, transformation: VisualTransformation = VisualTransformation.None, prefix: String? = null, keyboard: KeyboardType = KeyboardType.Text) {
    Column(Modifier.fillMaxWidth()) {
        Text(label, Modifier.padding(bottom = 6.dp), fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
        val shape = RoundedCornerShape(14.dp)
        BasicTextField(value, onValueChange, Modifier.fillMaxWidth(), enabled = enabled, singleLine = true, textStyle = TextStyle(fontSize = 15.sp, color = Ink), cursorBrush = SolidColor(Ink), visualTransformation = transformation, keyboardOptions = KeyboardOptions(keyboardType = keyboard), decorationBox = { inner ->
            Row(Modifier.fillMaxWidth().height(54.dp).background(Color.White, shape).border(1.dp, Color(0xFFEDE8DC), shape).padding(horizontal = 14.dp), verticalAlignment = Alignment.CenterVertically) {
                if (prefix != null) Text(prefix, Modifier.background(Color(0xFFEEEAE0), RoundedCornerShape(10.dp)).padding(10.dp), fontWeight = FontWeight.ExtraBold)
                else if (icon != null) Icon(icon, null, tint = Color(0xFF6E5000), modifier = Modifier.size(20.dp))
                if (prefix != null || icon != null) Spacer(Modifier.width(12.dp))
                Box(Modifier.weight(1f)) { if (value.isEmpty()) Text(placeholder, color = Color(0xFF9E998E), fontSize = 15.sp); inner() }
            }
        })
    }
}
