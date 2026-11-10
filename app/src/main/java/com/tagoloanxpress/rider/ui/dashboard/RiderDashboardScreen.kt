package com.tagoloanxpress.rider.ui.dashboard

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R
import com.tagoloanxpress.rider.ui.delivery.RiderActiveDeliveryScreen
import com.tagoloanxpress.rider.ui.delivery.RiderRequestDetailsScreen
import com.tagoloanxpress.rider.ui.receipt.RiderStoreReceiptScreen

private val Ink = Color(0xFF1B1C17)
private val Amber = Color(0xFFFEBC20)
private val Cream = Color(0xFFFBF9F1)
private val Muted = Color(0xFF504533)

@Composable
fun RiderDashboardScreen(onLogoutClick: () -> Unit) {
    var accepting by rememberSaveable { mutableStateOf(true) }
    var tab by rememberSaveable { mutableStateOf("Home") }
    var dialog by rememberSaveable { mutableStateOf<String?>(null) }
    var showRequestDetails by rememberSaveable { mutableStateOf(false) }
    var requestAccepted by rememberSaveable { mutableStateOf(false) }
    var requestDeclined by rememberSaveable { mutableStateOf(false) }
    var arrivedAtStore by rememberSaveable { mutableStateOf(false) }
    var showReceiptScreen by rememberSaveable { mutableStateOf(false) }
    var actualCostInput by rememberSaveable { mutableStateOf("") }
    var receiptUri by rememberSaveable { mutableStateOf<String?>(null) }
    var deliveryStarted by rememberSaveable { mutableStateOf(false) }
    var confirmedProductCostCentavos by rememberSaveable { mutableStateOf(0L) }

    if (showReceiptScreen) {
        RiderStoreReceiptScreen(
            actualCostInput = actualCostInput,
            onActualCostChange = { actualCostInput = it },
            receiptUri = receiptUri,
            onReceiptUriChange = { receiptUri = it },
            onBackClick = { showReceiptScreen = false },
            onStartDelivery = {
                confirmedProductCostCentavos = it
                deliveryStarted = true
                showReceiptScreen = false
                tab = "Active"
            },
        )
        return
    }
    if (showRequestDetails) {
        RiderRequestDetailsScreen(
            onBackClick = { showRequestDetails = false },
            onAccepted = {
                requestAccepted = true
                showRequestDetails = false
                tab = "Active"
            },
            onDeclined = {
                requestDeclined = true
                showRequestDetails = false
            },
        )
        return
    }
    BackHandler { if (tab == "Home") dialog = "Sign out" else tab = "Home" }
    Column(Modifier.fillMaxSize().background(Cream)) {
        Row(Modifier.fillMaxWidth().padding(16.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            Column { Text("RIDER PORTAL", fontSize = 18.sp, fontWeight = FontWeight.Bold); Text(tab, color = Muted, fontSize = 11.sp) }
            Image(painterResource(R.drawable.rider_dashboard_avatar), "Open rider profile", modifier = Modifier.size(36.dp).clip(CircleShape).border(2.dp, Amber, CircleShape).clickable { tab = "Profile" }, contentScale = ContentScale.Crop)
        }
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(horizontal = 16.dp, vertical = 4.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("UI DEMO • Sample rider and requests", fontSize = 11.sp, color = Muted)
            when (tab) {
                "Home" -> {
                    Identity()
                    Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(8.dp)) {
                        Stat("Earnings", "₱0.00", "Today", Modifier.weight(1f))
                        Stat("Completed", "0", "Deliveries", Modifier.weight(1f))
                        Stat("Score", "5.0", "Top Tier", Modifier.weight(1f), R.drawable.rd_star)
                    }
                    Availability(accepting, requestAccepted) { accepting = !accepting }
                    Requests(accepting, !requestAccepted && !requestDeclined) { showRequestDetails = true }
                    Tip()
                }
                "Requests" -> Requests(accepting, !requestAccepted && !requestDeclined) { showRequestDetails = true }
                "Active" -> if (requestAccepted) {
                    RiderActiveDeliveryScreen(
                        arrivedAtStore = arrivedAtStore,
                        deliveryStarted = deliveryStarted,
                        productCostCentavos = confirmedProductCostCentavos,
                        onArrivedAtStore = { arrivedAtStore = true },
                        onOpenReceipt = { showReceiptScreen = true },
                        onBackClick = { tab = "Home" },
                    )
                } else InfoCard("No active delivery", "You haven't accepted a request in this demo.")
                "History" -> InfoCard("No completed deliveries", "Delivery history will appear here when implemented.")
                "Profile" -> {
                    InfoCard("Juan • TX-RDR-8924", "Sample rider profile • Misamis Oriental")
                    Button({
                    requestAccepted = false
                    requestDeclined = false
                    arrivedAtStore = false
                    showReceiptScreen = false
                    actualCostInput = ""
                    receiptUri = null
                    deliveryStarted = false
                    confirmedProductCostCentavos = 0L
                    accepting = true
                    dialog = "Sign out"
                    }, colors = ButtonDefaults.buttonColors(containerColor = Ink)) { Text("SIGN OUT OF DEMO") }
                }
            }
        }
        Navigation(tab) { tab = it }
    }
    dialog?.let { title ->
        AlertDialog(
            onDismissRequest = { dialog = null },
            title = { Text(title) },
            text = { Text(if (title == "Sign out") "Return to the rider login screen?" else "Minute Burger\nQty: 2 Buy 1 Take 1 Packs\n\nPickup: Minute Burger, Tagoloan Poblacion\nDelivery: Zone 3, Mohon (near Chapel)\nDistance: 2.0 km • Estimated trip: 12 mins\nPayment: Cash on Delivery\nDelivery fee: ₱60.00\n\nSample request only.") },
            confirmButton = {
                TextButton({
                    dialog = null
                    if (title == "Sign out") {
                        requestAccepted = false
                        requestDeclined = false
                        arrivedAtStore = false
                        showReceiptScreen = false
                        actualCostInput = ""
                        receiptUri = null
                        deliveryStarted = false
                        confirmedProductCostCentavos = 0L
                        accepting = true
                        onLogoutClick()
                    }
                }) { Text(if (title == "Sign out") "Sign out" else "Close") }
            },
            dismissButton = { if (title == "Sign out") TextButton({ dialog = null }) { Text("Cancel") } },
        )
    }
}

@Composable private fun Identity() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
        Row(Modifier.dashboardSurface(Amber, 24).padding(10.dp, 6.dp), verticalAlignment = Alignment.CenterVertically) { Asset(R.drawable.rd_badge, 14.dp, 14.dp); Text("TX-RDR-8924", fontSize = 11.sp, color = Muted) }
        Text("Misamis Oriental", Modifier.weight(1f), fontSize = 11.sp, color = Muted)
        Text("Shift Active", fontSize = 11.sp, color = Muted)
    }
    Spacer(Modifier.height(8.dp)); Text("Maayong Adlaw, Juan! 👋", fontSize = 18.sp, fontWeight = FontWeight.Bold); Text("Ready for Tagoloan express dispatches", fontSize = 11.sp, color = Muted)
}

@Composable private fun Stat(label: String, value: String, caption: String, modifier: Modifier, @DrawableRes icon: Int? = null) {
    Column(modifier.dashboardSurface(Color.White, 12).padding(10.dp)) { Text(label, fontSize = 11.sp, color = Muted); Row(verticalAlignment = Alignment.CenterVertically) { Text(value, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold); if (icon != null) Asset(icon, 14.dp, 13.dp) }; Text(caption, fontSize = 10.sp, color = Muted) }
}

@Composable private fun Availability(accepting: Boolean, busy: Boolean, toggle: () -> Unit) {
    Column(Modifier.fillMaxWidth().dashboardSurface(if (accepting) Color(0xFFE8F5E9) else Color(0xFFF0EEE6), 16).padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(if (busy) "SYSTEM: BUSY" else if (accepting) "SYSTEM: AVAILABLE" else "SYSTEM: OFFLINE", fontSize = 12.sp, fontWeight = FontWeight.Black, color = if (busy) Color(0xFFC62828) else if (accepting) Color(0xFF2E7D32) else Muted)
            if (!busy) TextButton(toggle) { Text(if (accepting) "Accepting" else "Go online", color = Ink, fontSize = 11.sp) }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) { Asset(R.drawable.rd_available, 17.dp, 19.dp); Text(if (busy) "You have an active delivery." else if (accepting) "You are active and approved. Nearby Pasugo requests in Poblacion, Mohon, and Casinglot will appear here automatically." else "You are offline. Go online to preview nearby requests.", fontSize = 12.sp, color = Ink, modifier = Modifier.weight(1f)) }
    }
}

@Composable private fun Requests(accepting: Boolean, requestAvailable: Boolean, details: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) { Text("Available Requests", fontSize = 18.sp, fontWeight = FontWeight.ExtraBold); Row(Modifier.dashboardSurface(Amber, 24).padding(10.dp, 5.dp), verticalAlignment = Alignment.CenterVertically) { Asset(R.drawable.rd_nearby, 10.dp, 10.dp); Text(if (accepting && requestAvailable) "1 Nearby" else "0 Nearby", fontSize = 11.sp) } }
        if (!accepting) { InfoCard("You're offline", "Go online from Home to see requests."); return }
        if (!requestAvailable) { InfoCard("No available requests", "There are no pending Pasugo requests in this demo."); return }
        Column(Modifier.fillMaxWidth().dashboardSurface(Color.White, 16).padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) { Text("🍔 Food Errand", Modifier.dashboardSurface(Amber, 24).padding(12.dp, 6.dp), fontSize = 11.sp, fontWeight = FontWeight.Bold); Row(verticalAlignment = Alignment.CenterVertically) { Asset(R.drawable.rd_clock, 12.dp, 12.dp); Text("3 mins ago", fontSize = 11.sp, color = Muted) } }
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) { Column(Modifier.weight(1f)) { Text("Minute Burger", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("Qty: 2 Buy 1 Take 1 Packs", Modifier.background(Color(0xFFF0EEE6)).padding(4.dp), fontSize = 11.sp) }; Box(Modifier.size(44.dp).dashboardSurface(Color(0xFFFFEED4), 12), Alignment.Center) { Asset(R.drawable.rd_food, 22.dp, 22.dp) } }
            Column(Modifier.fillMaxWidth().dashboardSurface(Color(0xFFF6F4EC), 12).padding(12.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) { Address(R.drawable.rd_pickup, "PICKUP MERCHANT", "Minute Burger, Tagoloan Poblacion"); Address(R.drawable.rd_dropoff, "DELIVERY ADDRESS • 2.0 km away", "Zone 3, Mohon (near Chapel)"); HorizontalDivider(color = Color(0xFFD4C4AC)); Row(verticalAlignment = Alignment.CenterVertically) { Asset(R.drawable.rd_trip, 13.dp, 9.dp); Text("Est. ~12 mins trip", Modifier.weight(1f), fontSize = 11.sp, color = Muted); Text("Cash on Delivery", fontSize = 11.sp, color = Muted) } }
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) { Column(Modifier.weight(1f)) { Text("Guaranteed Delivery Fee", fontSize = 11.sp, color = Muted); Text("100% Rider Payout", fontSize = 11.sp, color = Color(0xFF2E7D32)) }; Text("₱60.00", fontSize = 32.sp, fontWeight = FontWeight.Black) }
            Button(details, Modifier.fillMaxWidth().height(48.dp).dashboardSurface(Amber, 12), colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Ink), shape = RoundedCornerShape(12.dp)) { Text("VIEW REQUEST DETAILS", fontWeight = FontWeight.ExtraBold) }
        }
    }
}

@Composable private fun Address(@DrawableRes icon: Int, label: String, address: String) { Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) { Asset(icon, 8.dp, 8.dp); Column { Text(label, fontSize = 10.sp, color = Muted); Text(address, fontSize = 14.sp, fontWeight = FontWeight.Bold) } } }
@Composable private fun Tip() { Row(Modifier.fillMaxWidth().dashboardSurface(Color(0xFFF0EEE6), 12).padding(13.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) { Asset(R.drawable.rd_tip, 13.dp, 17.dp); Text("Rider Tip: Stay within the Poblacion & Natumolan commercial triangle during lunchtime (11 AM - 1:30 PM) for priority delivery queueing.", fontSize = 12.sp, color = Muted) } }
@Composable private fun InfoCard(title: String, body: String) { Column(Modifier.fillMaxWidth().dashboardSurface(Color.White, 16).padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { Text(title, fontWeight = FontWeight.Bold); Text(body, fontSize = 13.sp, color = Muted) } }
@Composable private fun Navigation(selected: String, onSelect: (String) -> Unit) { Row(Modifier.fillMaxWidth().background(Color.White).padding(vertical = 8.dp)) { listOf("Home" to R.drawable.rd_home, "Requests" to R.drawable.rd_requests, "Active" to R.drawable.rd_active, "History" to R.drawable.rd_history, "Profile" to R.drawable.rd_profile).forEach { (label, icon) -> Column(Modifier.weight(1f).clickable { onSelect(label) }, horizontalAlignment = Alignment.CenterHorizontally) { Box(Modifier.size(40.dp, 28.dp).background(if (selected == label) Amber else Color.Transparent, CircleShape), Alignment.Center) { Asset(icon, 18.dp, 16.dp) }; Text(label, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Muted) } } } }
@Composable private fun Asset(@DrawableRes id: Int, width: androidx.compose.ui.unit.Dp, height: androidx.compose.ui.unit.Dp) { Image(painterResource(id), null, Modifier.size(width, height)) }
private fun Modifier.dashboardSurface(color: Color, radius: Int): Modifier { val shape = RoundedCornerShape(radius.dp); return drawBehind { drawRoundRect(Ink, Offset(2.dp.toPx(), 3.dp.toPx()), size, CornerRadius(radius.dp.toPx())) }.background(color, shape).border(2.dp, Ink, shape) }
