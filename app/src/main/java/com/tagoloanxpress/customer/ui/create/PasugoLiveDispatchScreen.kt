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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)

@Composable
fun PasugoLiveDispatchScreen(
    itemName: String = "Minute Burger",
    quantity: Int = 2,
    instructions: String = "No onions, please.",
    budget: String = "200",
    deliveryFee: Int = 60,
    onTrackDeliveryNowClick: () -> Unit = {},
    onCancelRequestClick: () -> Unit = {},
    onCloseClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var assigned by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { delay(3000); assigned = true }
    Box(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).statusBarsPadding()) {
        Column(Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) { Column { Text("Request #TGX-8921", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("Pasugo Live Dispatch", fontSize = 11.sp) }; Icon(Icons.Filled.Close, "Close", Modifier.clickable(onClick = onCloseClick)) }
            Spacer(Modifier.height(24.dp))
            Column(Modifier.fillMaxWidth().background(Color(0xFFFCF7E6), RoundedCornerShape(20.dp)).border(2.dp, Ink, RoundedCornerShape(20.dp)).clickable { assigned = true }.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(90.dp).background(Amber, CircleShape).border(2.dp, Ink, CircleShape), Alignment.Center) { Icon(Icons.Filled.TwoWheeler, null, Modifier.size(32.dp)) }
                Spacer(Modifier.height(16.dp)); Text("WAITING FOR RIDER", Modifier.background(Amber, RoundedCornerShape(20.dp)).padding(14.dp, 6.dp), fontWeight = FontWeight.Black)
                Spacer(Modifier.height(14.dp)); Text("Broadcasting your request...", fontSize = 20.sp, fontWeight = FontWeight.Black); Text("Your Pasugo request has been posted to nearby approved riders in Tagoloan.")
                Spacer(Modifier.height(18.dp)); Text("6 active riders in range  •  Est. 1–3 mins", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(18.dp))
            Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(20.dp)).border(2.dp, Ink, RoundedCornerShape(20.dp)).padding(18.dp)) { Text("PASUGO SUMMARY", fontWeight = FontWeight.Black); Spacer(Modifier.height(12.dp)); Text("$itemName (x$quantity)", fontSize = 16.sp, fontWeight = FontWeight.Black); Text("\"$instructions\""); Spacer(Modifier.height(12.dp)); Text("Estimated budget: ₱${budget.toIntOrNull() ?: 200}"); Text("Delivery fee: ₱$deliveryFee") }
            Spacer(Modifier.weight(1f)); Box(Modifier.fillMaxWidth().border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable(onClick = onCancelRequestClick).padding(vertical = 14.dp), Alignment.Center) { Text("✕  CANCEL REQUEST", color = Color(0xFFD32F2F), fontWeight = FontWeight.Black) }
        }
        if (assigned) {
            Box(Modifier.fillMaxSize().background(Color.Black.copy(.55f)).padding(24.dp), Alignment.Center) {
                Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(24.dp)).border(2.dp, Ink, RoundedCornerShape(24.dp)).padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(Modifier.size(82.dp).background(Amber, CircleShape).border(2.dp, Ink, CircleShape), Alignment.Center) { Text("🛵", fontSize = 34.sp) }
                    Spacer(Modifier.height(14.dp)); Text("RIDER ASSIGNED!", color = Color(0xFF1B8A4E), fontWeight = FontWeight.Black); Spacer(Modifier.height(12.dp)); Text("Juan Dela Cruz accepted your Pasugo!", fontSize = 20.sp, fontWeight = FontWeight.Black)
                    Spacer(Modifier.height(14.dp)); Text("Your rider is now heading to $itemName."); Spacer(Modifier.height(18.dp)); Text("Juan Dela Cruz  •  Plate: ABC 1234", fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(18.dp)); Box(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(14.dp)).clickable(onClick = onTrackDeliveryNowClick).padding(vertical = 14.dp), Alignment.Center) { Text("TRACK DELIVERY NOW", fontWeight = FontWeight.Black) }
                    Spacer(Modifier.height(10.dp)); Box(Modifier.fillMaxWidth().border(2.dp, Ink, RoundedCornerShape(14.dp)).clickable { assigned = false }.padding(vertical = 12.dp), Alignment.Center) { Row(verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.Phone, null, Modifier.size(16.dp)); Spacer(Modifier.width(8.dp)); Text("CALL RIDER", fontWeight = FontWeight.Black) } }
                }
            }
        }
    }
}
