package com.tagoloanxpress.customer.ui.create

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)
private val Muted = Color(0xFF666666)

@Composable
fun CreatePasugoStep4Screen(
    itemName: String = "Minute Burger",
    quantity: Int = 2,
    instructions: String = "No onions, please.",
    budget: String = "200",
    paymentMethod: String = "Cash on Delivery (COD)",
    pickupTitle: String = "Minute Burger, Poblacion",
    pickupSubtitle: String = "National Highway, Tagoloan Plaza area",
    deliveryTitle: String = "Zone 3, Mohon",
    deliverySubtitle: String = "Near Mohon Covered Court, Blue Gate, Tagoloan",
    deliveryFee: Int = 60,
    onPostRequestConfirmed: () -> Unit = {},
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var showModal by remember { mutableStateOf(false) }
    val productBudget = budget.toIntOrNull() ?: 200
    Column(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).statusBarsPadding()) {
        Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", Modifier.clickable(onClick = onBackClick)); Spacer(Modifier.padding(6.dp)); Text("Pasugo Summary (4/4)", fontSize = 18.sp, fontWeight = FontWeight.Black) }
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(horizontal = 20.dp)) {
            Text("PASUGO DETAILS", Modifier.background(Amber, RoundedCornerShape(8.dp)).padding(10.dp), fontWeight = FontWeight.Black)
            Spacer(Modifier.height(14.dp))
            SummaryRow("Item", "$itemName (Qty: $quantity)")
            SummaryRow("Instructions", instructions)
            SummaryRow("Product Budget", "₱$productBudget.00")
            SummaryRow("Payment", paymentMethod)
            HorizontalDivider(Modifier.padding(vertical = 12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.LocationOn, null, tint = Color.Red); Spacer(Modifier.padding(4.dp)); Column { Text("PICKUP POINT", color = Color.Red, fontSize = 10.sp, fontWeight = FontWeight.Black); Text(pickupTitle, fontWeight = FontWeight.Black); Text(pickupSubtitle, color = Muted, fontSize = 11.sp) } }
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.Home, null, tint = Amber); Spacer(Modifier.padding(4.dp)); Column { Text("DROP-OFF DESTINATION", color = Color(0xFFB55A00), fontSize = 10.sp, fontWeight = FontWeight.Black); Text(deliveryTitle, fontWeight = FontWeight.Black); Text(deliverySubtitle, color = Muted, fontSize = 11.sp) } }
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(16.dp)).border(2.dp, Ink, RoundedCornerShape(16.dp)).padding(16.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) { Text("CALCULATED DELIVERY FEE", fontWeight = FontWeight.Black); Text("₱$deliveryFee.00", fontSize = 24.sp, fontWeight = FontWeight.Black) }
            Spacer(Modifier.height(16.dp))
            Text("Estimated Total on Arrival: ₱${productBudget + deliveryFee}.00", Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(12.dp)).padding(16.dp), fontWeight = FontWeight.Black)
            Spacer(Modifier.height(24.dp))
        }
        Box(Modifier.fillMaxWidth().padding(20.dp).background(Amber, RoundedCornerShape(14.dp)).border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable { showModal = true }.padding(vertical = 16.dp), Alignment.Center) { Row(verticalAlignment = Alignment.CenterVertically) { Text("SUBMIT PASUGO REQUEST", fontWeight = FontWeight.Black); Spacer(Modifier.padding(4.dp)); Icon(Icons.AutoMirrored.Filled.ArrowForward, null) } }
    }
    if (showModal) {
        Box(Modifier.fillMaxSize().background(Color.Black.copy(.55f)).padding(24.dp), Alignment.Center) {
            Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(24.dp)).border(2.dp, Ink, RoundedCornerShape(24.dp)).padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Confirm Pasugo Request?", fontSize = 20.sp, fontWeight = FontWeight.Black)
                Spacer(Modifier.height(10.dp)); Text("Your request for $itemName will be posted to nearby approved riders.", color = Muted)
                Spacer(Modifier.height(16.dp)); Box(Modifier.fillMaxWidth().background(Color(0xFFFAF7F0), RoundedCornerShape(12.dp)).padding(14.dp)) { Text("📍 Pickup: $pickupTitle\n🏠 Delivery: $deliveryTitle\n\nTotal Fee: ₱$deliveryFee.00", fontWeight = FontWeight.Bold) }
                Spacer(Modifier.height(18.dp)); Box(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(14.dp)).clickable { showModal = false; onPostRequestConfirmed() }.padding(vertical = 14.dp), Alignment.Center) { Text("YES, POST REQUEST", fontWeight = FontWeight.Black) }
                Spacer(Modifier.height(10.dp)); Box(Modifier.fillMaxWidth().border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable { showModal = false }.padding(vertical = 12.dp), Alignment.Center) { Text("REVIEW DETAILS AGAIN", fontWeight = FontWeight.Black) }
            }
        }
    }
}

@Composable private fun SummaryRow(label: String, value: String) { Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), Arrangement.SpaceBetween) { Text(label, color = Muted); Text(value, fontWeight = FontWeight.Bold) } }
