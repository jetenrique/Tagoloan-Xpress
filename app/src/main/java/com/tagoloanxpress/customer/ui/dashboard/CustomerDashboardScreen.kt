package com.tagoloanxpress.customer.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R
import com.tagoloanxpress.ui.designsystem.*

/** Figma 3:257. Public callbacks match the existing customer destination. */
@Composable
fun CustomerDashboardScreen(
    customerName: String = "Neil Dairo",
    onCreatePasugoClick: () -> Unit = {},
    onTrackDeliveryClick: () -> Unit = {},
    onNavigateHistory: () -> Unit = {},
    onNavigateProfile: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize().background(TxRefresh.Background).safeDrawingPadding()) {
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Welcome back", color = TxRefresh.Muted, fontSize = 13.sp)
                Text(customerName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Box(Modifier.size(44.dp).background(TxRefresh.Amber, CircleShape)
                .clickable(onClick = onNavigateProfile), Alignment.Center) {
                val initials = customerName.trim().split(Regex("\\s+")).take(2).mapNotNull { it.firstOrNull() }.joinToString("")
                Text(initials, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        }
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 4.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Column(Modifier.fillMaxWidth().background(TxRefresh.Amber, androidx.compose.foundation.shape.RoundedCornerShape(20.dp)).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("What do you need?", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text("We'll buy or pick it up anywhere in Tagoloan.", fontSize = 14.sp, color = TxRefresh.AmberText)
                Spacer(Modifier.height(10.dp))
                TxRefreshButton("Create Pasugo", onCreatePasugoClick, dark = true,
                    leading = { TxRefreshAsset(R.drawable.txf_377ee, 16f) })
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Services", style = MaterialTheme.typography.titleMedium)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    listOf("Pabili" to R.drawable.txf_d5de6, "Padala" to R.drawable.txf_855ba,
                        "Pharmacy" to R.drawable.txf_63d52, "Bills" to R.drawable.txf_409e6).forEach { (label, icon) ->
                        Surface(modifier = Modifier.weight(1f).clickable(onClick = onCreatePasugoClick),
                            shape = TxRefresh.CardShape, color = TxRefresh.Surface,
                            border = androidx.compose.foundation.BorderStroke(1.dp, TxRefresh.Border)) {
                            Column(Modifier.padding(vertical = 14.dp), horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Box(Modifier.size(40.dp).background(TxRefresh.AmberTint, TxRefresh.FieldShape), Alignment.Center) {
                                    TxRefreshAsset(icon, 20f)
                                }
                                Text(label, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                            }
                        }
                    }
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text("Active request", Modifier.weight(1f), style = MaterialTheme.typography.titleMedium)
                    TextButton(onClick = onNavigateHistory, contentPadding = PaddingValues(0.dp)) {
                        Text("View all", fontSize = 13.sp, color = TxRefresh.AmberText)
                    }
                }
                // Retains the existing customer demo request. Do not use this as a backend record.
                TxRefreshCard {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Box(Modifier.size(40.dp).background(TxRefresh.AmberTint, TxRefresh.FieldShape), Alignment.Center) {
                            TxRefreshAsset(R.drawable.txf_ca607, 20f)
                        }
                        Column(Modifier.weight(1f)) {
                            Text("School supplies", style = MaterialTheme.typography.titleSmall)
                            Text("Gaisano Grand Mall · 2.4 km", fontSize = 12.sp, color = TxRefresh.Muted)
                        }
                        TxRefreshBadge("Waiting")
                    }
                    HorizontalDivider(color = TxRefresh.Border)
                    TxRefreshMoneyRow("Delivery fee", "₱60.00")
                    TxRefreshButton("Track delivery", onTrackDeliveryClick, secondary = true)
                }
            }
            Spacer(Modifier.height(8.dp))
        }
        TxRefreshBottomBar(
            items = listOf(
                TxRefreshNavItem("Home", R.drawable.txf_a4e09, 14.134f, 15.907f),
                TxRefreshNavItem("Create", R.drawable.txf_5555d, 18.706f, 18.706f),
                TxRefreshNavItem("Active", R.drawable.txf_445f3, 23f, 21f),
                TxRefreshNavItem("History", R.drawable.txf_2f9f6, 16.821f, 16.873f),
                TxRefreshNavItem("Profile", R.drawable.txf_9ca4e, 15.039f, 15.406f),
            ), selected = "Home",
            onSelect = { when (it) {
                "Create" -> onCreatePasugoClick()
                "Active" -> onTrackDeliveryClick()
                "History" -> onNavigateHistory()
                "Profile" -> onNavigateProfile()
            } },
        )
    }
}
