package com.tagoloanxpress.rider.ui.login

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R

private val RiderInk = Color(0xFF18181F)
private val RiderAmber = Color(0xFFFEBC20)
private val RiderCream = Color(0xFFFFFDF5)

@Composable
fun RiderLoginScreen(
    onBackClick: () -> Unit, onDemoLoginClick: () -> Unit,
    onRegisterClick: () -> Unit, onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var identifier by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var submitted by rememberSaveable { mutableStateOf(false) }
    var showHelp by rememberSaveable { mutableStateOf(false) }
    BackHandler(onBack = onBackClick)
    Column(modifier.fillMaxSize().background(RiderCream).safeDrawingPadding().imePadding()) {
        Row(Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 16.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            RiderIconButton(R.drawable.rider_back, "Back", onBackClick)
            Text("Rider Portal", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = RiderInk)
            RiderIconButton(R.drawable.rider_help, "Rider portal help") { showHelp = true }
        }
        HorizontalDivider(thickness = 2.dp, color = RiderInk)
        Box(Modifier.weight(1f)) {
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 20.dp, vertical = 24.dp)) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(Modifier.riderSurface(RiderAmber, 28).padding(horizontal = 18.dp, vertical = 10.dp)) { Text("🛵 TAGOLOAN XPRESS", fontWeight = FontWeight.Black, fontSize = 14.sp, letterSpacing = .7.sp) }
                    Spacer(Modifier.height(14.dp)); Text("Rider Sign In", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = RiderInk)
                    Spacer(Modifier.height(6.dp)); Text("Sign in to view and fulfill nearby Pasugo requests.", fontSize = 13.sp, color = Color(0xFF555555), textAlign = TextAlign.Center)
                }
                Spacer(Modifier.height(24.dp)); FieldLabel("Registered Mobile / Username")
                Spacer(Modifier.height(6.dp))
                RiderTextField(identifier, { identifier = it }, "Registered mobile or username", R.drawable.rider_phone, submitted && identifier.isBlank())
                if (submitted && identifier.isBlank()) ErrorText("Enter your mobile number or username.")
                Spacer(Modifier.height(14.dp))
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                    FieldLabel("Password")
                    TextButton(onClick = onForgotPasswordClick, contentPadding = PaddingValues(0.dp)) { Text("Forgot Password?", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, textDecoration = TextDecoration.Underline, color = RiderInk) }
                }
                RiderTextField(password, { password = it }, "Password", R.drawable.rider_lock, submitted && password.isEmpty(), if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), KeyboardOptions(keyboardType = KeyboardType.Password)) {
                    IconButton({ passwordVisible = !passwordVisible }) { Icon(painterResource(R.drawable.rider_eye), if (passwordVisible) "Hide password" else "Show password", Modifier.size(20.dp), tint = RiderInk) }
                }
                if (submitted && password.isEmpty()) ErrorText("Enter your password.")
                Spacer(Modifier.height(16.dp))
                Row(Modifier.fillMaxWidth().riderSurface(Color(0xFFFFF8E1), 12, Color(0xFFF9A825)).padding(16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("ℹ", fontSize = 20.sp); Text("Notice: New rider accounts require Admin Document Verification (OR/CR, Driver's License) before activation.", fontSize = 12.sp, lineHeight = 17.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                }
                Spacer(Modifier.height(32.dp))
                RiderActionButton("LOGIN AS RIDER", RiderAmber, { submitted = true; if (identifier.isNotBlank() && password.isNotEmpty()) onDemoLoginClick() }, R.drawable.rider_login_arrow)
                Spacer(Modifier.height(16.dp)); Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(12.dp), Alignment.CenterVertically) { HorizontalDivider(Modifier.weight(1f)); Text("NEW PARTNER", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.Gray); HorizontalDivider(Modifier.weight(1f)) }
                Spacer(Modifier.height(16.dp)); Text("Want to become a TAGOLOAN XPRESS Rider?", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color(0xFF555555), fontSize = 13.sp)
                Spacer(Modifier.height(10.dp)); RiderActionButton("📋 APPLY / REGISTER AS RIDER", Color.White, onRegisterClick)
            }
        }
    }
    if (showHelp) AlertDialog(onDismissRequest = { showHelp = false }, title = { Text("Rider Portal") }, text = { Text("Sign in with your registered mobile number or username. New riders must apply and submit documents for admin verification before activation.") }, confirmButton = { TextButton({ showHelp = false }) { Text("Got it") } })
}

@Composable private fun FieldLabel(text: String) = Text(text, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = RiderInk)
@Composable private fun ErrorText(text: String) = Text(text, color = MaterialTheme.colorScheme.error, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp))

@Composable
private fun RiderTextField(value: String, onValueChange: (String) -> Unit, label: String, @DrawableRes icon: Int, isError: Boolean, visualTransformation: VisualTransformation = VisualTransformation.None, keyboardOptions: KeyboardOptions = KeyboardOptions.Default, trailingIcon: @Composable (() -> Unit)? = null) {
    OutlinedTextField(value, onValueChange, Modifier.fillMaxWidth(), singleLine = true, shape = RoundedCornerShape(12.dp), isError = isError, placeholder = { Text(label, fontSize = 14.sp) }, leadingIcon = { Icon(painterResource(icon), label, Modifier.size(20.dp)) }, trailingIcon = trailingIcon, visualTransformation = visualTransformation, keyboardOptions = keyboardOptions, colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = Color.White, unfocusedContainerColor = Color.White, errorContainerColor = Color.White, focusedBorderColor = RiderInk, unfocusedBorderColor = RiderInk, focusedTextColor = RiderInk, unfocusedTextColor = RiderInk, cursorColor = RiderInk))
}

@Composable private fun RiderIconButton(@DrawableRes icon: Int, description: String, onClick: () -> Unit) = IconButton(onClick, Modifier.size(48.dp).riderSurface(Color.White, 12)) { Icon(painterResource(icon), description, Modifier.size(20.dp), tint = RiderInk) }

@Composable private fun RiderActionButton(text: String, color: Color, onClick: () -> Unit, @DrawableRes icon: Int? = null) {
    Button(onClick, Modifier.fillMaxWidth().heightIn(min = 52.dp).riderSurface(color, 16), shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = RiderInk), contentPadding = PaddingValues(12.dp)) {
        Text(text, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
        if (icon != null) { Spacer(Modifier.width(8.dp)); Icon(painterResource(icon), null, Modifier.size(20.dp)) }
    }
}

private fun Modifier.riderSurface(color: Color, radius: Int, borderColor: Color = RiderInk): Modifier {
    val shape = RoundedCornerShape(radius.dp)
    return drawBehind { drawRoundRect(RiderInk, Offset(2.dp.toPx(), 3.dp.toPx()), size, CornerRadius(radius.dp.toPx())) }.background(color, shape).border(2.dp, borderColor, shape)
}
