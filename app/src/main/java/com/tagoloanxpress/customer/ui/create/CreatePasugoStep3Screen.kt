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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)
private val Muted = Color(0xFF666666)

data class DeliveryPreset(
    val chipLabel: String,
    val title: String,
    val subtitle: String,
    val distance: String,
    val estDropoff: String,
    val fee: String,
)

@Composable
fun CreatePasugoStep3Screen(
    selectedAddress: String = "Zone 3, Mohon, Tagoloan",
    onAddressChange: (String) -> Unit = {},
    onConfirmClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val presets = remember {
        listOf(
            DeliveryPreset("Home (Zone 3)", "Zone 3, Mohon, Tagoloan", "Near Mohon Covered Court, Blue Gate", "2.4 km", "12–15 min", "₱60.00"),
            DeliveryPreset("Office / Work", "Poblacion Municipal Complex", "Near Tagoloan Municipal Hall", "1.2 km", "8–10 min", "₱45.00"),
            DeliveryPreset("Mohon Plaza", "Mohon Barangay Plaza, Tagoloan", "Main Highway Frontage", "2.0 km", "10–12 min", "₱55.00"),
        )
    }
    var selectedIndex by remember { mutableStateOf(0) }
    var address by remember { mutableStateOf(selectedAddress) }
    val active = presets[selectedIndex]

    Column(modifier.fillMaxSize().background(Color(0xFFF3F6F1)).statusBarsPadding()) {
        Row(Modifier.fillMaxWidth().background(Color.White).padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", Modifier.size(28.dp).clickable(onClick = onBackClick))
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) { Text("Delivery Location (3/4)", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("Step 3 • Where should the rider deliver?", color = Muted, fontSize = 11.sp) }
            Box(Modifier.size(38.dp).background(Amber, CircleShape).border(2.dp, Ink, CircleShape), Alignment.Center) { Text("TX", fontWeight = FontWeight.Black) }
        }
        Box(Modifier.fillMaxWidth().height(8.dp).background(Color(0xFFE5E0D5))) { Box(Modifier.fillMaxWidth(.75f).height(8.dp).background(Amber)) }
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp)) {
            Row(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(16.dp)).border(2.dp, Ink, RoundedCornerShape(16.dp)).padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.Search, null); Spacer(Modifier.width(10.dp)); Column(Modifier.weight(1f)) { Text("SEARCH DELIVERY ADDRESS", color = Amber, fontSize = 9.sp, fontWeight = FontWeight.Black); Text(address, fontSize = 14.sp, fontWeight = FontWeight.Black) }
            }
            Spacer(Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                presets.forEachIndexed { index, preset ->
                    Text(preset.chipLabel, Modifier.background(if (index == selectedIndex) Amber else Color.White, RoundedCornerShape(20.dp)).border(1.dp, Ink, RoundedCornerShape(20.dp)).clickable { selectedIndex = index; address = preset.title; onAddressChange(address) }.padding(10.dp, 6.dp), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(24.dp))
            Box(Modifier.fillMaxWidth().height(300.dp).background(Color(0xFFDCEAD8), RoundedCornerShape(16.dp)).border(2.dp, Ink, RoundedCornerShape(16.dp)), Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) { Icon(Icons.Filled.LocationOn, "Destination", Modifier.size(60.dp), tint = Color(0xFFE53935)); Text("CUSTOMER DESTINATION", Modifier.background(Ink, RoundedCornerShape(20.dp)).padding(10.dp, 5.dp), color = Amber, fontSize = 10.sp, fontWeight = FontWeight.Black) }
            }
            Spacer(Modifier.height(16.dp))
            Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).border(2.dp, Ink, RoundedCornerShape(18.dp)).padding(16.dp)) {
                Text("SELECTED DELIVERY LOCATION", fontSize = 11.sp, fontWeight = FontWeight.Black)
                Spacer(Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.Home, null, Modifier.size(30.dp), tint = Amber); Spacer(Modifier.width(10.dp)); Column { Text(address.ifBlank { active.title }, fontSize = 15.sp, fontWeight = FontWeight.Black); Text(active.subtitle, color = Muted, fontSize = 11.sp) } }
                Spacer(Modifier.height(14.dp))
                Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(8.dp)) { Metric("DISTANCE", active.distance, Modifier.weight(1f)); Metric("EST. DROPOFF", active.estDropoff, Modifier.weight(1f)); Metric("DELIVERY FEE", active.fee, Modifier.weight(1f)) }
                Spacer(Modifier.height(14.dp))
                Box(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(14.dp)).border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable(onClick = onConfirmClick).padding(vertical = 15.dp), Alignment.Center) { Row(verticalAlignment = Alignment.CenterVertically) { Text("CONFIRM DELIVERY LOCATION", fontWeight = FontWeight.Black); Spacer(Modifier.width(8.dp)); Icon(Icons.AutoMirrored.Filled.ArrowForward, null, Modifier.size(18.dp)) } }
            }
        }
    }
}

@Composable private fun Metric(label: String, value: String, modifier: Modifier) { Column(modifier.background(Color(0xFFFFF8E7), RoundedCornerShape(10.dp)).border(1.dp, Ink, RoundedCornerShape(10.dp)).padding(7.dp), horizontalAlignment = Alignment.CenterHorizontally) { Text(label, color = Muted, fontSize = 8.sp, fontWeight = FontWeight.Bold); Text(value, fontSize = 12.sp, fontWeight = FontWeight.Black) } }
