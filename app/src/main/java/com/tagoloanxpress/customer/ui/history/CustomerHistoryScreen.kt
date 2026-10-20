package com.tagoloanxpress.customer.ui.history

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerHistoryScreen(onViewReceiptClick: () -> Unit = {}, onNavigateHome: () -> Unit = {}, onNavigateCreate: () -> Unit = {}, onNavigateActive: () -> Unit = {}, onNavigateProfile: () -> Unit = {}, onBackClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    var filter by remember { mutableStateOf("All Orders") }
    Column(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).padding(20.dp)) {
        Text("Pasugo History", fontSize = 21.sp, fontWeight = FontWeight.Black); Text("Customer Records & Receipts", fontSize = 12.sp)
        Spacer(Modifier.height(16.dp)); Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { listOf("All Orders" to "14", "Completed" to "12", "Cancelled" to "2").forEach { (label, count) -> Text("$label $count", Modifier.background(if (filter == label) Color(0xFFFFBD1F) else Color.White).clickable { filter = label }.padding(10.dp), fontWeight = FontWeight.Bold) } }
        Spacer(Modifier.height(16.dp)); Column(Modifier.weight(1f).verticalScroll(rememberScrollState())) { listOf("🍔 Food Request #TGX-8921", "🛒 Grocery Request #TGX-8740", "📦 Parcel Errand #TGX-8511").forEach { title -> Column(Modifier.fillMaxWidth().background(Color.White).padding(16.dp)) { Text(title, fontWeight = FontWeight.Black); Text("Sept 17, 2026 • Poblacion to Mohon"); Spacer(Modifier.height(10.dp)); Text(if (title.contains("Parcel")) "Cancelled" else "Completed"); if (!title.contains("Parcel")) Text("📄 VIEW RECEIPT DETAILS", Modifier.clickable(onClick = onViewReceiptClick).padding(top = 10.dp), color = Color(0xFF8B6508), fontWeight = FontWeight.Black) }; Spacer(Modifier.height(12.dp)) } }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) { Text("Home", Modifier.clickable(onClick = onNavigateHome)); Text("Create", Modifier.clickable(onClick = onNavigateCreate)); Text("Active", Modifier.clickable(onClick = onNavigateActive)); Text("Profile", Modifier.clickable(onClick = onNavigateProfile)) }
    }
}
