package com.tagoloanxpress.customer.ui.tracking

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerActiveTrackingScreen(
    itemName: String = "Minute Burger", quantity: Int = 2, budget: String = "200",
    instructions: String = "No onions", deliveryFee: Int = 60,
    onOrderCompleted: () -> Unit = {}, onNavigateHome: () -> Unit = {},
    onNavigateCreate: () -> Unit = {}, onNavigateHistory: () -> Unit = {},
    onNavigateProfile: () -> Unit = {}, onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var step by remember { mutableIntStateOf(1) }
    var showFallback by remember { mutableStateOf(false) }
    val title = when (step) { 1 -> "Heading to Store"; 2 -> "Purchasing Items"; else -> "Delivering to Mohon" }
    Box(modifier.fillMaxSize().background(Color(0xFFFAF6EC))) {
        Column(Modifier.fillMaxSize().padding(20.dp)) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                Column { Text("Active Pasugo #TGX-8921", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("Live GPS Tracking", fontSize = 11.sp) }
                Text("ACCEPTED", color = Color(0xFF1B8A4E), fontWeight = FontWeight.Black)
            }
            Spacer(Modifier.height(18.dp))
            Box(Modifier.fillMaxWidth().height(240.dp).background(Color(0xFFDCEAD8), RoundedCornerShape(18.dp)).border(2.dp, Color(0xFF1A1A1A), RoundedCornerShape(18.dp)), Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(Modifier.size(78.dp).background(Color(0xFFFFBD1F), CircleShape).border(2.dp, Color(0xFF1A1A1A), CircleShape), Alignment.Center) { Icon(Icons.Filled.TwoWheeler, null, Modifier.size(34.dp)) }
                    Spacer(Modifier.height(8.dp)); Text("Juan (Rider)", fontWeight = FontWeight.Black)
                }
            }
            Spacer(Modifier.height(18.dp))
            Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(16.dp)).border(2.dp, Color(0xFF1A1A1A), RoundedCornerShape(16.dp)).clickable { if (step < 3) step++ else onOrderCompleted() }.padding(16.dp)) {
                Text(title, fontSize = 17.sp, fontWeight = FontWeight.Black)
                Text("Step $step of 3 (Tap to advance)", fontSize = 12.sp)
                Spacer(Modifier.height(10.dp)); Box(Modifier.fillMaxWidth().height(8.dp).background(Color(0xFFE0DACB), RoundedCornerShape(4.dp))) { Box(Modifier.fillMaxWidth(step / 3f).height(8.dp).background(Color(0xFFFFBD1F), RoundedCornerShape(4.dp))) }
                Spacer(Modifier.height(12.dp)); Text("$itemName (x$quantity) • ₱$deliveryFee delivery fee", fontWeight = FontWeight.Bold); Text("\"$instructions\" • Budget ₱${budget.ifBlank { "200" }}", fontSize = 12.sp)
            }
            Spacer(Modifier.height(16.dp))
            Box(Modifier.fillMaxWidth().background(Color(0xFFFFBD1F), RoundedCornerShape(12.dp)).clickable { showFallback = true }.padding(14.dp), Alignment.Center) { Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.Phone, null, Modifier.size(18.dp)); Spacer(Modifier.size(6.dp)); Text("SMS / CALL FALLBACK (OFFLINE PROTOCOL)", fontWeight = FontWeight.Black) } }
            Spacer(Modifier.weight(1f))
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) { Text("Home", Modifier.clickable(onClick = onNavigateHome)); Text("Create", Modifier.clickable(onClick = onNavigateCreate)); Text("History", Modifier.clickable(onClick = onNavigateHistory)); Text("Profile", Modifier.clickable(onClick = onNavigateProfile)) }
        }
        if (showFallback) {
            Box(Modifier.fillMaxSize().background(Color.Black.copy(.55f)).padding(24.dp), Alignment.Center) { Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) { Text("2G / Offline SMS Protocol", fontWeight = FontWeight.Black); Spacer(Modifier.height(10.dp)); Text("Send an encrypted SMS status ping or call Rider Juan Dela Cruz."); Spacer(Modifier.height(16.dp)); Text("CLOSE", Modifier.clickable { showFallback = false }.padding(12.dp), fontWeight = FontWeight.Black) } }
        }
    }
}
