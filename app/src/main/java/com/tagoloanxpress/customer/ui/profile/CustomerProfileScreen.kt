package com.tagoloanxpress.customer.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerProfileScreen(customerName: String = "Neil Dairo", mobileNumber: String = "0917 890 1234", email: String = "neil.dairo@email.com", onHistoryReceiptsClick: () -> Unit = {}, onLogoutClick: () -> Unit = {}, onNavigateHome: () -> Unit = {}, onNavigateRequests: () -> Unit = {}, onNavigateActive: () -> Unit = {}, onNavigateHistory: () -> Unit = {}, onBackClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).padding(20.dp)) {
        Text("Customer Profile", fontSize = 21.sp, fontWeight = FontWeight.Black); Spacer(Modifier.height(18.dp))
        Column(Modifier.fillMaxWidth().background(Color.White).padding(20.dp)) { Text(customerName, fontSize = 24.sp, fontWeight = FontWeight.Black); Text("👤 CUSTOMER", color = Color(0xFF8B6508), fontWeight = FontWeight.Bold); Text("📱 $mobileNumber"); Text("✉️ $email"); Text("18 Completed Pasugo", color = Color(0xFF8B6508), fontWeight = FontWeight.Black) }
        Spacer(Modifier.height(18.dp)); Column(Modifier.weight(1f).verticalScroll(rememberScrollState())) { listOf("📍 Saved Locations / Addresses" to {}, "📜 Pasugo History & Receipts" to onHistoryReceiptsClick, "🔒 Account Security & Password" to {}, "📞 Tagoloan Xpress Support & Help" to {}).forEach { (label, action) -> Text(label, Modifier.fillMaxWidth().background(Color.White).clickable(onClick = action).padding(16.dp), fontWeight = FontWeight.Bold); Spacer(Modifier.height(1.dp)) }; Spacer(Modifier.height(20.dp)); Text("🚪 LOG OUT OF CUSTOMER ACCOUNT", Modifier.fillMaxWidth().clickable(onClick = onLogoutClick).padding(16.dp), color = Color(0xFFD32F2F), fontWeight = FontWeight.Black) }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) { Text("Home", Modifier.clickable(onClick = onNavigateHome)); Text("Requests", Modifier.clickable(onClick = onNavigateRequests)); Text("Active", Modifier.clickable(onClick = onNavigateActive)); Text("History", Modifier.clickable(onClick = onNavigateHistory)) }
    }
}
