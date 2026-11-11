package com.tagoloanxpress.rider.ui.delivery

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.tagoloanxpress.R
import com.tagoloanxpress.ui.designsystem.TxRefresh
import java.util.Locale

private val Ink = TxRefresh.Ink
private val Amber = TxRefresh.Amber
private val Cream = TxRefresh.Background
private val Muted = TxRefresh.Muted

@Composable
fun RiderRequestDetailsScreen(onBackClick: () -> Unit, onAccepted: () -> Unit, onDeclined: () -> Unit) {
    var confirm by rememberSaveable { mutableStateOf(false) }
    BackHandler { if (confirm) confirm = false else onBackClick() }
    Column(Modifier.fillMaxSize().background(Cream).safeDrawingPadding()) {
        DeliveryHeader("Pasugo Details #TGX-8921", "NEW DISPATCH", onBackClick)
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text("UI DEMO • Sample request", fontSize = 11.sp, color = Muted)
            Panel {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(Modifier.size(44.dp).clip(CircleShape).background(Cream).border(2.dp, Ink, CircleShape), Alignment.Center) { Text("MS", fontWeight = FontWeight.Bold) }
                    Column(Modifier.weight(1f)) { Row(verticalAlignment = Alignment.CenterVertically) { Text("Neil Dairo", fontWeight = FontWeight.Bold); LocalIcon(R.drawable.delivery_verified, 14) }; Caption("Zone 3, Mohon (near Chapel)") }
                    Row(verticalAlignment = Alignment.CenterVertically) { Text("5.0", fontSize = 11.sp); LocalIcon(R.drawable.delivery_star, 12) }
                }
                HorizontalDivider()
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) { Caption("Cash on Delivery (COD)"); Caption("Verified Sender") }
            }
            Panel {
                Text("REQUEST ITEM BREAKDOWN", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text("🍔 Food Errand", Modifier.background(Amber, RoundedCornerShape(6.dp)).padding(6.dp), fontSize = 10.sp)
                Text("Minute Burger", fontWeight = FontWeight.ExtraBold); Caption("Qty: 2 Buy 1 Take 1 Packs")
                Notice("📝 Customer Note: \"No onions, please. Extra dressing if possible.\"")
                SummaryRow("Est. Item Purchase Advance:", "₱200.00")
                LocationBlock("PICKUP MERCHANT", "Minute Burger, Poblacion, Tagoloan", "Tagoloan Commercial Center", Amber)
                LocationBlock("DELIVERY DROP-OFF", "Zone 3, Mohon, Tagoloan", "Direct Drop-off · Near Mohon Chapel", Color(0xFF21C98E))
                SummaryRow("Sample distance: 2.0 km", "Est. ~12 mins")
            }
            Panel(Amber) { Text("GUARANTEED DELIVERY FEE", fontSize = 11.sp, fontWeight = FontWeight.Bold); Text("₱60.00", fontSize = 32.sp, fontWeight = FontWeight.Black); Text("100% RIDER PAYOUT", fontSize = 11.sp, fontWeight = FontWeight.Bold); Caption("✓ Guaranteed Payout · No commission deducted by platform"); Notice("⚠ System Rule: Accepting this request will automatically set your status to BUSY until delivery is marked completed.") }
            DeliveryButton("ACCEPT PASUGO REQUEST", R.drawable.delivery_accept) { confirm = true }
            TextButton(onClick = onDeclined, Modifier.fillMaxWidth()) { Text("DECLINE REQUEST", color = Muted) }
        }
    }
    if (confirm) Dialog(onDismissRequest = { confirm = false }) {
        Column(Modifier.fillMaxWidth().frame(Color.White, 24).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(Modifier.size(64.dp).frame(Amber, 32), Alignment.Center) { LocalIcon(R.drawable.delivery_scooter, 32) }
            Text("Accept This Pasugo?", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
            Text("Are you ready to head to Minute Burger to purchase this order?", textAlign = TextAlign.Center, color = Muted)
            SummaryRow("🍔 Order", "Minute Burger (x2)"); SummaryRow("Est. Product Cost", "₱200.00"); SummaryRow("Your Earnings", "+₱60.00")
            Notice("⚠ Your rider status will switch to BUSY upon acceptance.")
            DeliveryButton("YES, ACCEPT REQUEST", R.drawable.delivery_accept) { confirm = false; onAccepted() }
            DeliveryButton("BACK TO LIST", null, Color.White) { confirm = false; onBackClick() }
        }
    }
}

@Composable
fun RiderActiveDeliveryScreen(
    arrivedAtStore: Boolean,
    deliveryStarted: Boolean,
    productCostCentavos: Long,
    onArrivedAtStore: () -> Unit,
    onOpenReceipt: () -> Unit,
    onBackClick: () -> Unit,
    onArrivedAtCustomer: () -> Unit,
    onOpenChat: () -> Unit,
    onOpenFallback: () -> Unit,
) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        DeliveryHeader("Active Pasugo #TGX-8921", "● BUSY", onBackClick)
        val totalCentavos = (if (deliveryStarted) productCostCentavos else 20000L) + 6000L
        Panel(Color(0xFFECEAE2)) { Text(if (deliveryStarted) "Heading to customer" else "Route preview", fontSize = 18.sp, fontWeight = FontWeight.Bold); Caption("Map and GPS will be connected later."); LocationBlock("PICKUP", "Minute Burger, Poblacion", "Sample ETA: 4 min", Amber); LocationBlock("DROP-OFF", "Zone 3, Mohon", "Total: 2.0 km • COD: ${deliveryMoney(totalCentavos)}", Color(0xFF21C98E)) }
        Panel {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) { Image(painterResource(R.drawable.delivery_customer), "Neil Dairo", contentScale = ContentScale.Crop, modifier = Modifier.size(44.dp).clip(CircleShape)); Column(Modifier.weight(1f)) { Text("Neil Dairo", fontWeight = FontWeight.Bold); Caption("CUSTOMER"); Caption("Zone 3, Mohon (near Chapel)") }; Text("+₱60.00", fontWeight = FontWeight.ExtraBold, color = Color(0xFF008F64)) }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { OutlinedButton(onOpenChat, Modifier.weight(1f)) { Text("💬 CHAT") }; Button(onOpenFallback, Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Amber, contentColor = Ink)) { Text("📞 CALL") } }
        }
        Panel { Text("🍔 Minute Burger (x2 Packs)", fontWeight = FontWeight.Bold); Caption(if (deliveryStarted) "Product cost: ${deliveryMoney(productCostCentavos)} • Cash on Delivery" else "Advance: ₱200.00 • Cash on Delivery"); SummaryRow("Collect from customer", if (deliveryStarted) deliveryMoney(totalCentavos) else "₱260.00"); if (deliveryStarted) DeliveryButton("VIEW RECEIPT", R.drawable.receipt_next) { onOpenReceipt() } }
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) { Text("1 To Store", color = if (!arrivedAtStore && !deliveryStarted) Ink else Muted, fontWeight = FontWeight.Bold, fontSize = 12.sp); Text("2 Buying", color = if (arrivedAtStore && !deliveryStarted) Ink else Muted, fontWeight = FontWeight.Bold, fontSize = 12.sp); Text("3 Deliver", color = if (deliveryStarted) Ink else Muted, fontWeight = FontWeight.Bold, fontSize = 12.sp) }
        Notice(if (deliveryStarted) "● STEP 3: Heading to customer" else if (arrivedAtStore) "● STEP 2: At store — purchase items and upload receipt." else "● STEP 1: Heading to Pickup Store")
        if (!deliveryStarted) DeliveryButton(if (arrivedAtStore) "CONTINUE TO RECEIPT" else "MARK AS ARRIVED AT STORE", null, Ink) { if (arrivedAtStore) onOpenReceipt() else onArrivedAtStore() }
        if (deliveryStarted) DeliveryButton("MARK AS ARRIVED AT CUSTOMER", null, Ink, onArrivedAtCustomer)
        Caption("UI demo • Status changes stay on this device.")
    }
}

@Composable private fun DeliveryHeader(title: String, badge: String, onBack: () -> Unit) { Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) { IconButton(onBack) { LocalIcon(R.drawable.delivery_back, 24) }; Text(title, Modifier.weight(1f), fontSize = 16.sp, fontWeight = FontWeight.Bold); Text(badge, Modifier.background(if (badge.contains("BUSY")) Color(0xFFFFEBEE) else Amber, RoundedCornerShape(20.dp)).padding(10.dp, 6.dp), color = if (badge.contains("BUSY")) Color(0xFFC62828) else Ink, fontSize = 10.sp, fontWeight = FontWeight.Bold) } }
@Composable private fun Panel(color: Color = Color.White, content: @Composable ColumnScope.() -> Unit) { Column(Modifier.fillMaxWidth().frame(color, 16).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp), content = content) }
@Composable private fun DeliveryButton(text: String, @DrawableRes icon: Int? = null, color: Color = Amber, onClick: () -> Unit) { Button(onClick, Modifier.fillMaxWidth().heightIn(min = 52.dp).frame(color, 16), shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = if (color == Ink) Amber else Ink)) { Text(text, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold); if (icon != null) { Spacer(Modifier.width(8.dp)); LocalIcon(icon, 20) } } }
@Composable private fun SummaryRow(label: String, value: String) { Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) { Text(label, fontSize = 12.sp, color = Muted); Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold) } }
@Composable private fun LocationBlock(label: String, title: String, subtitle: String, dot: Color) { Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) { Box(Modifier.padding(top = 3.dp).size(12.dp).background(dot, CircleShape).border(2.dp, Ink, CircleShape)); Column { Caption(label); Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold); Caption(subtitle) } } }
@Composable private fun Notice(text: String) { Text(text, Modifier.fillMaxWidth().background(Color(0xFFFFF8E1), RoundedCornerShape(12.dp)).border(1.dp, Amber, RoundedCornerShape(12.dp)).padding(12.dp), fontSize = 12.sp, color = Ink) }
@Composable private fun Caption(text: String) { Text(text, fontSize = 11.sp, color = Muted) }
@Composable private fun LocalIcon(@DrawableRes id: Int, size: Int) { Image(painterResource(id), null, Modifier.size(size.dp)) }
private fun Modifier.frame(color: Color, radius: Int): Modifier { val shape = RoundedCornerShape(radius.dp); return background(color, shape).border(1.dp, TxRefresh.Border, shape) }
private fun deliveryMoney(centavos: Long): String = "₱" + String.format(Locale.US, "%,d.%02d", centavos / 100, centavos % 100)
