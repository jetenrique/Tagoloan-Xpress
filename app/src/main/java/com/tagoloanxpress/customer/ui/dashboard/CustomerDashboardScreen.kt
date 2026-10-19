package com.tagoloanxpress.customer.ui.dashboard

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)
private val Cream = Color(0xFFFFFDF7)
private val Muted = Color(0xFF525252)

@Composable
fun CustomerDashboardScreen(
    customerName: String = "Neil Dairo",
    onCreatePasugoClick: () -> Unit = {},
    onTrackDeliveryClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize().background(Cream).statusBarsPadding().navigationBarsPadding()) {
        Column(
            Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(horizontal = 20.dp),
        ) {
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                Text(
                    "TAGOLOAN XPRESS  PASUGO",
                    Modifier.background(Amber, RoundedCornerShape(8.dp))
                        .border(2.dp, Ink, RoundedCornerShape(8.dp)).padding(12.dp, 8.dp),
                    fontWeight = FontWeight.Black,
                )
                Box(Modifier.size(40.dp).background(Ink, CircleShape).border(2.dp, Amber, CircleShape))
            }
            Spacer(Modifier.height(24.dp))
            Text("WELCOME BACK 👋", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text(customerName, color = Ink, fontSize = 24.sp, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(16.dp))
            Column(
                Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(12.dp))
                    .border(2.dp, Ink, RoundedCornerShape(12.dp)).padding(20.dp),
            ) {
                Text("EXPRESS ON-DEMAND", Modifier.background(Ink, RoundedCornerShape(4.dp)).padding(8.dp, 4.dp), color = Amber, fontSize = 10.sp, fontWeight = FontWeight.Black)
                Spacer(Modifier.height(12.dp))
                Text("WHAT DO YOU NEED?", fontSize = 24.sp, fontWeight = FontWeight.Black)
                Text("Request items to be bought or picked up\nanywhere in Tagoloan.", fontSize = 13.sp)
                Spacer(Modifier.height(20.dp))
                Row(
                    Modifier.fillMaxWidth().background(Ink, RoundedCornerShape(8.dp))
                        .clickable(onClick = onCreatePasugoClick).padding(vertical = 14.dp),
                    Arrangement.Center, Alignment.CenterVertically,
                ) {
                    Icon(Icons.Filled.Add, null, tint = Amber, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("CREATE PASUGO", color = Amber, fontWeight = FontWeight.ExtraBold)
                }
            }
            Spacer(Modifier.height(24.dp))
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                listOf("Pabili", "Padala", "Pharmacy", "Bills / Pay").forEach { label ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(Modifier.size(70.dp).background(Color.White, RoundedCornerShape(12.dp)).border(2.dp, Ink, RoundedCornerShape(12.dp)), Alignment.Center) {
                            Text(label.take(1), fontSize = 22.sp, fontWeight = FontWeight.Black)
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(Modifier.height(28.dp))
            Text("Active Request", fontSize = 18.sp, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(12.dp))
            Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(12.dp)).border(2.dp, Ink, RoundedCornerShape(12.dp)).padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Receipt, null, modifier = Modifier.size(22.dp))
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text("School Supplies", fontSize = 16.sp, fontWeight = FontWeight.Black)
                        Text("Order #TXP-8924 • Gaisano Grand Mall", fontSize = 11.sp, color = Muted, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                    Text("WAITING FOR RIDER", fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(Modifier.height(16.dp))
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.LocationOn, null, modifier = Modifier.size(14.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Est. 2.4 km • Poblacion", fontSize = 12.sp, color = Muted)
                    }
                    Text("₱60.00", fontSize = 16.sp, fontWeight = FontWeight.Black)
                }
                Spacer(Modifier.height(16.dp))
                Box(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(8.dp)).border(2.dp, Ink, RoundedCornerShape(8.dp)).clickable(onClick = onTrackDeliveryClick).padding(vertical = 12.dp), Alignment.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.TwoWheeler, null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("TRACK DELIVERY", fontWeight = FontWeight.Black)
                    }
                }
            }
            Spacer(Modifier.height(32.dp))
        }
        HorizontalDivider()
        Row(Modifier.fillMaxWidth().padding(12.dp, 20.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            listOf("Home" to Icons.Filled.Home, "Active" to Icons.Filled.TwoWheeler, "Profile" to Icons.Filled.Person).forEach { (label, icon) ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(icon, label, tint = if (label == "Home") Ink else Muted, modifier = Modifier.size(24.dp))
                    Text(label, fontSize = 11.sp, color = if (label == "Home") Ink else Muted)
                }
            }
        }
    }
}
