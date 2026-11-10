package com.tagoloanxpress.rider.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tagoloanxpress.R
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*

@Composable
fun RiderProfileContent(store: RiderStore, onHistory: () -> Unit, onEdit: () -> Unit, onPhoto: () -> Unit, onSecurity: () -> Unit, onLogout: () -> Unit) {
    val s = store.state
    TxTitle("Rider Profile")
    TxCaption("Tagoloan Pasugo Fleet • Local UI demo")
    TxPanel {
        if (s.photo.isNotBlank()) LocalPhoto(s.photo, 105)
        else Image(painterResource(R.drawable.fg_3_4288_imgjuandelacruzrider), "Sample rider portrait", Modifier.size(105.dp).align(Alignment.CenterHorizontally))
        TxTitle(s.name)
        TxText("🛵 Plate: ${s.plate} • ${s.mobile}")
        TxText("● ${if (s.approval == Approval.APPROVED) "APPROVED RIDER (DEMO)" else "PENDING VERIFICATION"}")
        HorizontalDivider()
        TxRow("RATING", "5.0 ★ (sample)")
        TxRow("DELIVERIES", s.trips.size.toString())
        TxRow("FLEET HUB", "Tagoloan")
    }
    TxPanel {
        TxText("📄 License & OR/CR")
        TxCaption(if (s.documents.all { it.isNotBlank() }) "Documents selected on this device" else "Sample accreditation • No real verification performed")
        TxRow("System Status", if (s.busy) "BUSY" else if (s.accepting) "Available for Pasugo" else "Off duty")
    }
    TxPanel {
        TxButton("UPDATE VEHICLE & DOCUMENTS", white = true, onClick = onEdit)
        TxButton("UPDATE PROFILE PICTURE", white = true, onClick = onPhoto)
        TxButton("COMPLETED PASUGO HISTORY", white = true, onClick = onHistory)
        TxButton("ACCOUNT SECURITY", white = true, onClick = onSecurity)
    }
    TxButton("LOG OUT OF RIDER ACCOUNT", white = true, onClick = onLogout)
}

@Composable
fun RiderVehicleScreen(store: RiderStore, onBack: () -> Unit) {
    var vehicle by rememberSaveable { mutableStateOf(store.state.vehicle) }
    var plate by rememberSaveable { mutableStateOf(store.state.plate) }
    RiderPage("Vehicle & Documents", onBack) {
        TxPanel {
            OutlinedTextField(vehicle, { vehicle = it.take(80) }, Modifier.fillMaxWidth(), label = { Text("Motorcycle model") }, singleLine = true)
            OutlinedTextField(plate, { plate = it.take(20) }, Modifier.fillMaxWidth(), label = { Text("Plate number") }, singleLine = true)
        }
        listOf("OR / CR Document", "Driver's License", "Other Requirements / Clearance").forEachIndexed { index, label ->
            TxPanel { PhotoSelector(label, store.state.documents[index], { uri -> store.update { s -> s.copy(documents = s.documents.toMutableList().apply { set(index, uri) }) } }, camera = false) }
        }
        TxCaption("Local document photos only. Renewals must be reverified when the admin backend is connected.")
        TxButton("SAVE VEHICLE DETAILS", enabled = vehicle.isNotBlank() && plate.isNotBlank()) {
            store.update { it.copy(vehicle = vehicle.trim(), plate = plate.trim()) }; onBack()
        }
    }
}
