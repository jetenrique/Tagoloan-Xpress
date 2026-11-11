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
import androidx.compose.foundation.layout.safeDrawingPadding
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
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*
import com.tagoloanxpress.rider.ui.delivery.RiderCompletionScreen
import com.tagoloanxpress.rider.ui.history.*
import com.tagoloanxpress.rider.ui.profile.*
import com.tagoloanxpress.rider.ui.messages.*
import com.tagoloanxpress.rider.ui.onboarding.RiderProfileSetupScreen
import com.tagoloanxpress.rider.ui.delivery.RiderActiveDeliveryScreen
import com.tagoloanxpress.rider.ui.delivery.RiderRequestDetailsScreen
import com.tagoloanxpress.rider.ui.receipt.RiderStoreReceiptScreen
import com.tagoloanxpress.ui.designsystem.TxRefresh

private val Ink = TxRefresh.Ink
private val Amber = TxRefresh.Amber
private val Cream = TxRefresh.Background
private val Muted = TxRefresh.Muted

@Composable
fun RiderDashboardScreen(store: RiderStore, onLogoutClick: () -> Unit) {
    val s = store.state
    var tab by rememberSaveable { mutableStateOf("Home") }
    var route by rememberSaveable { mutableStateOf("") }
    var showLogout by rememberSaveable { mutableStateOf(false) }
    var selectedTrip by rememberSaveable { mutableStateOf("") }

    when (route) {
        "receipt" -> {
            if (s.stage == DeliveryStage.BUYING) RiderStoreReceiptScreen(
                actualCostInput = s.draftCost,
                onActualCostChange = { value -> store.update { it.copy(draftCost = value) } },
                receiptUri = s.receipt.ifBlank { null },
                onReceiptUriChange = { value -> store.update { it.copy(receipt = value.orEmpty()) } },
                onBackClick = { route = "" },
                onStartDelivery = { cost -> store.update { it.startDelivery(cost) }; route = ""; tab = "Active" },
            ) else RiderPage("Confirmed Store Receipt", { route = "" }) {
                TxPanel { TxRow("Product cost", riderMoney(s.confirmedCost)); TxRow("Delivery fee", riderMoney(RiderState.FEE)); TxRow("COD total", riderMoney(s.total)); LocalPhoto(s.receipt, 320) }
                TxCaption("This confirmed receipt cannot be edited after starting delivery.")
            }
            return
        }
        "details" -> {
            RiderRequestDetailsScreen(
                onBackClick = { route = "" },
                onAccepted = { store.update { it.accept() }; route = ""; tab = "Active" },
                onDeclined = { store.update { if (it.available) it.copy(stage = DeliveryStage.DECLINED) else it }; route = "" },
            )
            return
        }
        "trip" -> {
            val trip = s.trips.find { it.id == selectedTrip }
            if (trip != null) RiderTripScreen(trip) { route = "" }
            else RiderPage("Trip unavailable", { route = "" }) { TxText("This trip is no longer recorded on this device.") }
            return
        }
        "vehicle" -> { RiderVehicleScreen(store) { route = "" }; return }
        "photo" -> { RiderProfileSetupScreen(store, { route = "" }, { route = "" }); return }
        "security" -> {
            RiderPage("Account Security", { route = "" }) {
                TxPanel { TxTitle("Demo account"); TxText("This prototype does not store a login password. Password changes and password recovery require the authentication backend."); TxCaption("Your photos and delivery records are stored on this device. Signing out keeps them for your next demo session.") }
                TxButton("BACK TO PROFILE", white = true) { route = "" }
            }
            return
        }
        "chat" -> { RiderChatScreen(store, { route = "" }, { route = "fallback" }); return }
        "fallback" -> { RiderFallbackScreen { route = if (s.busy) "chat" else "" }; return }
        "notifications" -> {
            RiderNotificationsScreen(store, { route = "" }, { route = "details" }, { route = ""; tab = if (s.busy) "Active" else "History" })
            return
        }
    }
    BackHandler { if (tab == "Home") showLogout = true else tab = "Home" }
    Column(Modifier.fillMaxSize().background(Cream).safeDrawingPadding()) {
        Row(Modifier.fillMaxWidth().padding(16.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) { Text("RIDER PORTAL", fontSize = 18.sp, fontWeight = FontWeight.Bold); Text(tab, color = Muted, fontSize = 11.sp) }
            TextButton(onClick = { route = "notifications" }) { Text(if (s.notificationsRead) "Alerts" else "Alerts •") }
            Image(painterResource(R.drawable.rider_dashboard_avatar), "Open rider profile", modifier = Modifier.size(36.dp).clip(CircleShape).border(2.dp, Amber, CircleShape).clickable { tab = "Profile" }, contentScale = ContentScale.Crop)
        }
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(horizontal = 16.dp, vertical = 4.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("UI DEMO • Records stay on this device", fontSize = 11.sp, color = Muted)
            when (tab) {
                "Home" -> {
                    Availability(s.accepting, s.busy) { store.update { if (!it.busy) it.copy(accepting = !it.accepting) else it } }
                    Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(8.dp)) {
                        Stat("Earnings", riderMoney(s.earnings), "Recorded fees", Modifier.weight(1f))
                        Stat("Completed", s.trips.size.toString(), "Deliveries", Modifier.weight(1f))
                        Stat("Score", "5.0", "Sample rating", Modifier.weight(1f), R.drawable.rd_star)
                    }
                    Requests(s.accepting, s.available) { route = "details" }
                    if (s.stage == DeliveryStage.DECLINED) TxButton("RESTORE DECLINED SAMPLE REQUEST", white = true) { store.update { it.copy(stage = DeliveryStage.AVAILABLE) } }
                }
                "Requests" -> Requests(s.accepting, s.available) { route = "details" }
                "Active" -> when {
                    s.stage == DeliveryStage.AT_CUSTOMER -> RiderCompletionScreen(store) { tab = "History" }
                    s.busy -> RiderActiveDeliveryScreen(
                        arrivedAtStore = s.stage != DeliveryStage.TO_STORE,
                        deliveryStarted = s.stage == DeliveryStage.DELIVERING,
                        productCostCentavos = s.confirmedCost,
                        onArrivedAtStore = { store.update { it.arriveAtStore() } },
                        onOpenReceipt = { route = "receipt" },
                        onBackClick = { tab = "Home" },
                        onArrivedAtCustomer = { store.update { it.arriveAtCustomer() } },
                        onOpenChat = { route = "chat" },
                        onOpenFallback = { route = "fallback" },
                    )
                    else -> InfoCard("No active delivery", "Accepted requests appear here. Completed trips are in History.")
                }
                "History" -> RiderHistoryContent(s.trips) { selectedTrip = it; route = "trip" }
                "Profile" -> RiderProfileContent(store, { tab = "History" }, { route = "vehicle" }, { route = "photo" }, { route = "security" }, { showLogout = true })
            }
            Spacer(Modifier.height(12.dp))
        }
        Navigation(tab) { tab = it }
    }
    if (showLogout) AlertDialog(
        onDismissRequest = { showLogout = false },
        title = { Text("Sign out?") },
        text = { Text("Return to rider login? Your delivery draft and completed trips will remain on this device.") },
        confirmButton = { TextButton(onClick = { showLogout = false; onLogoutClick() }) { Text("Sign out") } },
        dismissButton = { TextButton(onClick = { showLogout = false }) { Text("Cancel") } },
    )
}

@Composable private fun Identity(name: String, busy: Boolean, accepting: Boolean) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
        Row(Modifier.dashboardSurface(Amber, 24).padding(10.dp, 6.dp), verticalAlignment = Alignment.CenterVertically) { Asset(R.drawable.rd_badge, 14.dp, 14.dp); Text("TX-RDR-8924", fontSize = 11.sp, color = Muted) }
        Text("Misamis Oriental", Modifier.weight(1f), fontSize = 11.sp, color = Muted)
        Text(if (busy) "Busy" else if (accepting) "Shift Active" else "Off duty", fontSize = 11.sp, color = Muted)
    }
    Spacer(Modifier.height(8.dp)); Text("Maayong Adlaw, ${name.substringBefore(' ')}! 👋", fontSize = 18.sp, fontWeight = FontWeight.Bold); Text("Ready for Tagoloan express dispatches", fontSize = 11.sp, color = Muted)
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
private fun Modifier.dashboardSurface(color: Color, radius: Int): Modifier { val shape = RoundedCornerShape(radius.dp); return background(color, shape).border(1.dp, TxRefresh.Border, shape) }
