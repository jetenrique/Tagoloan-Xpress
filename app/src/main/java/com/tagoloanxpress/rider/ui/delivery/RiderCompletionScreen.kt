package com.tagoloanxpress.rider.ui.delivery

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.tagoloanxpress.R
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*

/** Plain content. The dashboard owns scrolling. */
@Composable
fun RiderCompletionScreen(store: RiderStore, onCompleted: () -> Unit) {
    val s = store.state
    val handover = rememberImagePreview(s.handover)
    val receipt = rememberImagePreview(s.receipt)
    TxCaption("✓ To Store   →   ✓ Bought   →   AT CUSTOMER")
    TxPanel(Color(0xFFF5F3EB)) {
        TxCaption("ARRIVED AT DESTINATION • #${RiderState.REQUEST_ID}")
        TxTitle("Zone 3, Mohon, Tagoloan")
        TxText("Deliver to Neil Dairo • Near Mohon Chapel")
        TxText("Minute Burger (2x Buy 1 Take 1 Packs)")
    }
    TxPanel(TxAmber) {
        TxCaption("COLLECT FROM CUSTOMER • CASH (COD)")
        Text(riderMoney(s.total), fontSize = 32.sp, fontWeight = FontWeight.Black, color = TxInk)
        TxRow("Store receipt amount", riderMoney(s.confirmedCost))
        TxRow("Standard delivery fee", riderMoney(RiderState.FEE))
        HorizontalDivider(color = TxInk)
        TxCaption("Demo rider earnings: ${riderMoney(RiderState.FEE)}. No wallet transfer is performed.")
    }
    TxPanel {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TxAsset(R.drawable.fg_3_3017_imgcontainer6)
            TxText("Photo with package or customer")
        }
        PhotoSelector("Proof of Handover", s.handover, { photo -> store.update { it.copy(handover = photo) } })
    }
    TxPanel {
        TxTitle("COMPLETION VERIFICATION")
        Row {
            Checkbox(s.receiptHandedOver, { checked -> store.update { it.copy(receiptHandedOver = checked) } })
            Column(Modifier.weight(1f)) {
                TxText("Physical Store Receipt Handed Over")
                TxCaption("${riderMoney(s.confirmedCost)} Minute Burger slip surrendered")
            }
        }
        Row {
            Checkbox(s.cashCollected, { checked -> store.update { it.copy(cashCollected = checked) } })
            Column(Modifier.weight(1f)) {
                TxText("Full Cash Payment Collected")
                TxCaption("Exact ${riderMoney(s.total)} received and confirmed")
            }
        }
    }
    TxButton("COMPLETE PASUGO & GO ONLINE", enabled = s.canComplete && handover.bitmap != null && receipt.bitmap != null) {
        store.update { it.complete(System.currentTimeMillis()) }
        if (store.state.stage == DeliveryStage.COMPLETED) onCompleted()
    }
    TxCaption("The demo records one completed trip and returns you online. A new dispatch requires backend integration.")
}
