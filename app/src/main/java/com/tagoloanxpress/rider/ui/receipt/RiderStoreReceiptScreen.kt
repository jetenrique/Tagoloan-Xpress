package com.tagoloanxpress.rider.ui.receipt

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*

@Composable
fun RiderStoreReceiptScreen(
    actualCostInput: String,
    onActualCostChange: (String) -> Unit,
    receiptUri: String?,
    onReceiptUriChange: (String?) -> Unit,
    onBackClick: () -> Unit,
    onStartDelivery: (Long) -> Unit,
) {
    val amount = parseRiderCentavos(actualCostInput)
    val uri = receiptUri.orEmpty()
    val preview = rememberImagePreview(uri)
    RiderPage("Store Purchase #TGX-8921", onBackClick) {
        TxCaption("Order verification & billing • STEP 2: At Store (Buying)")
        TxPanel {
            TxTitle("🍔 Minute Burger (x2 Packs)")
            TxCaption("Customer: Neil Dairo • Mohon Zone 3")
            TxRow("EST. BUDGET", riderMoney(20000))
        }
        TxPanel {
            TxTitle("ENTER ACTUAL RECEIPT AMOUNT")
            OutlinedTextField(
                actualCostInput, onActualCostChange, Modifier.fillMaxWidth(),
                singleLine = true, label = { Text("Actual Product Cost (₱)") },
                placeholder = { Text("195.00") }, prefix = { Text("₱ ") }, suffix = { Text("PHP") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                isError = actualCostInput.isNotEmpty() && amount == null,
            )
            if (actualCostInput.isNotEmpty() && amount == null) Text("Enter ₱0.01–₱999,999.99 with at most two decimal places.", color = MaterialTheme.colorScheme.error)
            TxCaption("Estimated budget was ₱200.00. Enter the exact receipt total.")
            amount?.let { cost ->
                TxRow(if (cost <= 20000) "Customer savings on advance" else "Above estimated budget", riderMoney(kotlin.math.abs(20000 - cost)))
                if (cost > 20000) TxCaption("Confirm any extra cost with the customer before proceeding.")
            }
        }
        TxPanel(TxCream) { PhotoSelector("UPLOAD RECEIPT PHOTO", uri, { onReceiptUriChange(it) }) }
        TxPanel(TxAmber) {
            TxTitle("PAYMENT BREAKDOWN (COD)")
            TxRow("Actual Product Cost", amount?.let(::riderMoney) ?: "—")
            TxRow("Fixed Delivery Fee", riderMoney(RiderState.FEE))
            HorizontalDivider()
            TxTitle("TOTAL TO COLLECT FROM CUSTOMER")
            TxTitle(amount?.let { riderMoney(it + RiderState.FEE) } ?: "—")
            TxCaption("DIRECT CASH PAYMENT UPON DROP-OFF")
        }
        TxText("Keep the physical store receipt ready. The customer will inspect it upon delivery at Zone 3, Mohon.")
        TxButton("START DELIVERY TO CUSTOMER", enabled = amount != null && preview.bitmap != null && !preview.loading) {
            amount?.let { if (preview.bitmap != null) onStartDelivery(it) }
        }
        TxCaption("UI demo • Selected photos are copied to this app's private storage, not uploaded.")
    }
}
