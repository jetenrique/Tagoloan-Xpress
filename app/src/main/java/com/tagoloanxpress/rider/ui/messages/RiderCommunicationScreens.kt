package com.tagoloanxpress.rider.ui.messages

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*

@Composable
fun RiderChatScreen(store: RiderStore, onBack: () -> Unit, onFallback: () -> Unit) {
    var draft by rememberSaveable { mutableStateOf("") }
    val s = store.state
    val scroll = rememberScrollState()
    LaunchedEffect(s.messages.size) { scroll.animateScrollTo(scroll.maxValue) }
    fun send(text: String) {
        if (text.isNotBlank() && store.state.busy) {
            store.update { it.copy(messages = (it.messages + text.trim().take(1000)).takeLast(100)) }
            draft = ""
        }
    }
    BackHandler(onBack = onBack)
    Column(Modifier.fillMaxSize().background(TxCream).safeDrawingPadding().imePadding()) {
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { TxAsset(R.drawable.fg_3_5368_imgsvg1, "Back") }
            Column(Modifier.weight(1f)) { TxTitle("Neil Dairo"); TxCaption("CUSTOMER • Zone 3, Mohon") }
            TextButton(onClick = onFallback) { Text("CALL") }
        }
        TxText("#TGX-8921 • Minute Burger → Zone 3 Mohon")
        Column(Modifier.weight(1f).verticalScroll(scroll).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            TxCaption("UI DEMO • Messages are stored only on this device. No delivery or encryption service is connected.")
            TxPanel { TxText("Neil Dairo (sample customer)"); TxText("Please make sure no onions on the double cheeseburger. Thank you!") }
            s.messages.forEach { message ->
                TxPanel(TxAmber) { TxCaption("You (Rider) • Saved locally"); TxText(message) }
            }
            TxPanel { TxText("🍔 MINUTE BURGER (2 ITEMS)"); TxCaption("Special: No onions, extra dressing") }
        }
        TxCaption("⚡ QUICK RIDER UPDATES • Tap to add to demo conversation")
        Row(Modifier.horizontalScroll(rememberScrollState()).padding(horizontal = 12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("I'm at the store", "Traffic delay", "Heading to drop-off", "Arrived outside").forEach { update ->
                OutlinedButton(enabled = s.busy, onClick = { send(update) }) { Text(update, fontSize = 11.sp) }
            }
        }
        TextButton(onClick = onFallback, modifier = Modifier.fillMaxWidth()) { Text("SMS / CALL FALLBACK →") }
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(draft, { draft = it.take(1000) }, Modifier.weight(1f), label = { Text("Type a message…") }, maxLines = 3)
            IconButton(enabled = draft.isNotBlank() && s.busy, onClick = { send(draft) }) { TxAsset(R.drawable.fg_3_5368_imgsvg5, "Add message", 22f) }
        }
    }
}

@Composable
fun RiderFallbackScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    var phone by rememberSaveable { mutableStateOf("") }
    var message by rememberSaveable { mutableStateOf("TAGOLOAN XPRESS: Rider update for Pasugo #TGX-8921. Please contact me about your delivery.") }
    var error by remember { mutableStateOf("") }
    val normalized = phone.replace(" ", "").replace("-", "")
    val valid = Regex("""\+?\d{10,15}""").matches(normalized)
    fun launch(intent: Intent) {
        try { context.startActivity(intent); error = "" }
        catch (_: ActivityNotFoundException) { error = "No compatible phone or SMS app is installed." }
        catch (_: SecurityException) { error = "Android could not open this action." }
    }
    RiderPage("Offline Fallback Options", onBack) {
        TxAsset(R.drawable.fg_3_5644_imgcontainer, width = 48f)
        TxTitle("SMS & CELLULAR FALLBACK")
        TxText("Use these options when app data is unavailable. This preview does not monitor your connection or send messages automatically.")
        TxPanel {
            TxTitle("ACTIVE ERRAND: #TGX-8921")
            TxText("Send Direct SMS Message")
            TxCaption("Opens the native SMS composer. You review and send the message yourself.")
            TxText("Direct Cellular Phone Call")
            TxCaption("Opens the dialer. No call is placed automatically.")
        }
        OutlinedTextField(phone, { phone = it.take(22) }, Modifier.fillMaxWidth(), label = { Text("Recipient phone number") }, singleLine = true)
        TxCaption("Enter a number you intend to contact. The sample customer has no live phone number.")
        OutlinedTextField(message, { message = it.take(1000) }, Modifier.fillMaxWidth(), label = { Text("SMS draft") }, minLines = 3)
        TxButton("LAUNCH NATIVE SMS MESSENGER", enabled = valid && message.isNotBlank()) {
            launch(Intent(Intent.ACTION_SENDTO, Uri.fromParts("smsto", normalized, null)).putExtra("sms_body", message))
        }
        TxButton("OPEN CELLULAR DIALER", enabled = valid, white = true) { launch(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", normalized, null))) }
        TxButton("RETURN TO APP CHAT", white = true, onClick = onBack)
        if (error.isNotEmpty()) Text(error, color = MaterialTheme.colorScheme.error)
        TxCaption("Carrier rates may apply. No SMS gateway or connectivity failover is implemented.")
    }
}

@Composable
fun RiderNotificationsScreen(store: RiderStore, onBack: () -> Unit, onRequest: () -> Unit, onActive: () -> Unit) {
    val s = store.state
    RiderPage("Rider Notifications", onBack) {
        TxCaption("In-app preview • No FCM push or lock-screen service connected")
        TxButton(if (s.notificationsRead) "ALL NOTIFICATIONS READ" else "MARK ALL AS READ", enabled = !s.notificationsRead, white = true) {
            store.update { it.copy(notificationsRead = true) }
        }
        TxPanel {
            TxAsset(R.drawable.fg_3_6067_imgcontainer7)
            TxCaption(if (s.available) "Action Required • Sample dispatch" else "Sample dispatch • No longer available")
            TxTitle("New Pasugo Errand Request")
            TxText("A customer nearby in Poblacion, Tagoloan submitted an express errand. Review the request before accepting.")
            TxButton("VIEW REQUEST", enabled = s.available, onClick = onRequest)
        }
        TxPanel {
            TxTitle(if (s.stage == DeliveryStage.COMPLETED) "Delivery Completed" else "Proof of Handover Required")
            TxText(if (s.stage == DeliveryStage.COMPLETED) "The completed demo delivery is available in History." else "At the customer's location, select a handover photo and confirm the receipt and full cash collection.")
            TxButton("VIEW DELIVERY", enabled = s.busy || s.stage == DeliveryStage.COMPLETED, onClick = onActive)
        }
        TxPanel {
            TxAsset(R.drawable.fg_3_6067_imgcontainer12)
            TxTitle("Admin Notice: Operations Dispatch Update")
            TxText("Sample advisory: road repairs near Tagoloan Public Plaza. Check local conditions before choosing a route.")
            TxCaption("Illustrative design content, not a verified traffic alert.")
        }
    }
}
