package com.tagoloanxpress.rider.ui.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RiderHistoryContent(trips: List<CompletedTrip>, onTrip: (String) -> Unit) {
    var filter by rememberSaveable { mutableStateOf("All Trips") }
    val today = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0) }.timeInMillis
    val week = Calendar.getInstance().apply { set(Calendar.DAY_OF_WEEK, firstDayOfWeek); set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0) }.timeInMillis
    val visible = trips.filter { filter == "All Trips" || it.completedAt >= if (filter == "Today") today else week }
    TxTitle("Delivery History")
    TxCaption("Rider Completed Errand Logs • This device")
    TxPanel(TxAmber) {
        TxRow("TOTAL COMPLETED PASUGO", "${trips.size} Deliveries")
        TxTitle(riderMoney(trips.sumOf { it.fee }))
        TxCaption("Total delivery fees earned. Product advances are reimbursements.")
    }
    Row(Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        listOf("All Trips", "Today", "This Week").forEach { option -> FilterChip(selected = filter == option, onClick = { filter = option }, label = { Text(option) }) }
    }
    if (visible.isEmpty()) TxPanel { TxTitle("No completed trips"); TxText("Completed deliveries matching this filter will appear here.") }
    visible.forEach { trip ->
        TxPanel {
            TxTitle("🍔 Food Delivery #${trip.id}")
            TxCaption("● Completed • ${tripDate(trip.completedAt)}")
            TxText("Neil Dairo • Zone 3, Mohon")
            TxPanel(Color(0xFFF6F4EC)) { TxText("Minute Burger, Poblacion"); TxCaption("↓ 2.0 km transit distance"); TxText("Zone 3, Mohon") }
            TxRow("Product handled", riderMoney(trip.productCost))
            TxRow("Fee earned", riderMoney(trip.fee))
            TxButton("VIEW TRIP RECEIPT") { onTrip(trip.id) }
        }
    }
}

@Composable
fun RiderTripScreen(trip: CompletedTrip, onBack: () -> Unit) {
    RiderPage("Trip Log #${trip.id}", onBack) {
        TxPanel {
            TxRow("● COMPLETED TRIP", tripDate(trip.completedAt))
            TxCaption("CUSTOMER"); TxTitle("Neil Dairo")
            HorizontalDivider()
            TxText("🍔 Minute Burger (x2)")
            TxCaption("PICKUP LOCATION"); TxText("Minute Burger, Poblacion, Tagoloan")
            TxCaption("DROP-OFF LOCATION"); TxText("Zone 3, Mohon, Tagoloan")
            TxCaption("Sample distance: 2.0 km")
            HorizontalDivider()
            TxRow("Actual receipt amount", riderMoney(trip.productCost))
            TxRow("Delivery fee earned", riderMoney(trip.fee))
            TxPanel(Color(0xFFFFF3D5)) { TxRow("TOTAL CASH COLLECTED", riderMoney(trip.total)) }
        }
        TxPanel(Color(0xFFFFF8E1)) {
            TxTitle("PROOF & DOCUMENTS")
            TxText("Store Receipt Photo"); LocalPhoto(trip.receipt, 220)
            TxText("Handover Photo"); LocalPhoto(trip.handover, 220)
        }
        TxCaption("Recorded locally • Not synced to an admin ledger.")
        TxButton("CLOSE TRIP DETAILS", white = true, onClick = onBack)
    }
}

private fun tripDate(time: Long): String = SimpleDateFormat("MMM d, yyyy • h:mm a", Locale.getDefault()).format(Date(time))
