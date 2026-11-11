package com.tagoloanxpress.ui.designsystem

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R

/** Figma 3:45 and 3:1464, sharing presentation while retaining caller-owned state. */
@Composable
fun TxRefreshLogin(
    rider: Boolean, identifier: String, password: String, passwordVisible: Boolean,
    onIdentifierChange: (String) -> Unit, onPasswordChange: (String) -> Unit,
    onTogglePassword: () -> Unit, onLogin: () -> Unit,
    onRegister: () -> Unit, onForgot: () -> Unit, onBack: () -> Unit,
    modifier: Modifier = Modifier, loading: Boolean = false, error: String? = null,
) {
    BackHandler(onBack = onBack)
    BoxWithConstraints(modifier.fillMaxSize().background(TxRefresh.Background)
        .safeDrawingPadding().imePadding()) {
        val viewportHeight = maxHeight
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
            .heightIn(min = viewportHeight), verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Row(Modifier.fillMaxWidth().height(if (rider) 56.dp else 116.dp).padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack, modifier = Modifier.size(40.dp)
                        .background(TxRefresh.Surface, CircleShape).border(1.dp, TxRefresh.Border, CircleShape)) {
                        TxRefreshAsset(R.drawable.txf_82c1c, 18f, description = "Back")
                    }
                    if (rider) Text("Rider portal", Modifier.padding(start = 12.dp),
                        fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Column(Modifier.padding(horizontal = 24.dp).padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(Modifier.size(56.dp).background(TxRefresh.Amber, TxRefresh.CardShape), Alignment.Center) {
                        TxRefreshAsset(if (rider) R.drawable.txf_9d05c else R.drawable.txf_2f607, 26f)
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(if (rider) "Welcome back, rider" else "Welcome back",
                        style = MaterialTheme.typography.headlineMedium)
                    Text(if (rider) "Log in to start accepting Pasugo requests."
                        else "Log in to request errands and deliveries in Tagoloan.",
                        style = MaterialTheme.typography.bodyMedium, color = TxRefresh.Muted)
                    Spacer(Modifier.height(28.dp))
                    if (error != null) Text(error, color = TxRefresh.Red, style = MaterialTheme.typography.bodySmall)
                    TxRefreshField(if (rider) "Mobile number" else "Mobile number or email",
                        identifier, onIdentifierChange, placeholder = "09XX XXX XXXX", enabled = !loading,
                        keyboardOptions = KeyboardOptions(keyboardType = if (rider) KeyboardType.Phone else KeyboardType.Email),
                        trailing = { TxRefreshAsset(R.drawable.txf_eede5, 18f) })
                    Spacer(Modifier.height(4.dp))
                    TxRefreshField("Password", password, onPasswordChange, placeholder = "••••••••", enabled = !loading,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        transformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailing = {
                            IconButton(onClick = onTogglePassword, enabled = !loading, modifier = Modifier.size(28.dp)) {
                                TxRefreshAsset(R.drawable.txf_eca05, 18f,
                                    description = if (passwordVisible) "Hide password" else "Show password")
                            }
                        })
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = onForgot, enabled = !loading, contentPadding = PaddingValues(0.dp)) {
                            Text("Forgot password?", color = TxRefresh.AmberText, fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold)
                        }
                    }
                    TxRefreshButton("Log in", onLogin,
                        enabled = identifier.isNotBlank() && password.isNotBlank(), loading = loading)
                    if (rider) Row(Modifier.fillMaxWidth().padding(top = 12.dp),
                        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        TxRefreshAsset(R.drawable.txf_6f4c2, 14f)
                        Spacer(Modifier.width(6.dp))
                        Text("New accounts are activated after Admin approval", fontSize = 12.sp, color = TxRefresh.Muted)
                    }
                }
            }
            Column(Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(top = 32.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (rider) "New to Tagoloan Xpress?" else "Don't have an account?",
                    fontSize = 13.sp, color = TxRefresh.Muted)
                TxRefreshButton(if (rider) "Apply as a rider" else "Create an account", onRegister,
                    secondary = true, enabled = !loading)
                if (rider) Text("Local demo · Authentication is not connected.",
                    fontSize = 11.sp, color = TxRefresh.Placeholder)
            }
        }
    }
}
