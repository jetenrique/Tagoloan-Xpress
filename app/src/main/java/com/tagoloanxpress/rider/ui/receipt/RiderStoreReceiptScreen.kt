package com.tagoloanxpress.rider.ui.receipt

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.util.Locale

private val Ink = Color(0xFF18181F)
private val Amber = Color(0xFFFEBC20)
private val Cream = Color(0xFFFFFDF5)

@Composable
fun RiderStoreReceiptScreen(
    actualCostInput: String,
    onActualCostChange: (String) -> Unit,
    receiptUri: String?,
    onReceiptUriChange: (String?) -> Unit,
    onBackClick: () -> Unit,
    onStartDelivery: (Long) -> Unit,
) {
    val context = LocalContext.current
    var pickerError by remember { mutableStateOf<String?>(null) }
    val amount = parseCentavos(actualCostInput)
    val invalidAmount = actualCostInput.isNotEmpty() && amount == null
    val total = amount?.plus(6000L)
    val preview by produceState<Bitmap?>(null, receiptUri) {
        value = receiptUri?.let { withContext(Dispatchers.IO) { readPreview(context, Uri.parse(it)) } }
    }
    val picker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            try {
                context.contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                pickerError = null
                onReceiptUriChange(uri.toString())
            } catch (_: SecurityException) {
                pickerError = "Couldn't retain access to this image. Choose another file."
            }
        }
    }
    BackHandler(onBack = onBackClick)
    Column(Modifier.fillMaxSize().background(Cream).safeDrawingPadding().imePadding()) {
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onBackClick) { ReceiptIcon(R.drawable.receipt_back) }
            Column(Modifier.weight(1f)) { Text("Store Purchase #TGX-8921", fontWeight = FontWeight.ExtraBold); Text("Order verification & billing", fontSize = 11.sp, color = Color.Gray) }
        }
        HorizontalDivider(thickness = 2.dp, color = Ink)
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text("✓ To Store   —   ② STEP 2: Buying   —   ③ Delivery", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Panel { Text("🍔 Minute Burger (x2 Packs)", fontWeight = FontWeight.Bold); Text("Customer: Neil Dairo • Mohon Zone 3", fontSize = 12.sp); MoneyRow("EST. BUDGET", money(20000L)) }
            Panel {
                Text("🏷 ENTER ACTUAL RECEIPT AMOUNT", fontWeight = FontWeight.ExtraBold)
                Text("ACTUAL PRODUCT COST (₱) • REQUIRED", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(actualCostInput, onActualCostChange, Modifier.fillMaxWidth(), singleLine = true, label = { Text("Actual product cost") }, placeholder = { Text("195.00") }, prefix = { Text("₱ ") }, suffix = { Text("PHP") }, isError = invalidAmount, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), shape = RoundedCornerShape(12.dp))
                if (invalidAmount) Text("Enter an amount above ₱0 and up to ₱999,999.99, with no more than two decimal places.", fontSize = 12.sp, color = MaterialTheme.colorScheme.error)
                Text("Estimated budget was ₱200.00. Enter exact receipt total.", fontSize = 11.sp, color = Color.Gray)
                HorizontalDivider()
                amount?.let { MoneyRow(if (it <= 20000L) "Customer savings on advance:" else "Above estimated budget:", if (it <= 20000L) "-${money(20000L - it)}" else "+${money(it - 20000L)}") }
            }
            Panel(Amber) {
                Text("📸 RECEIPT PHOTO • REQUIRED", fontWeight = FontWeight.ExtraBold)
                if (preview != null) Image(preview!!.asImageBitmap(), "Selected store receipt", Modifier.fillMaxWidth().height(180.dp), contentScale = ContentScale.Fit)
                else Text(if (receiptUri == null) "Choose a clear photo of the official store receipt." else "Loading receipt… If no preview appears, choose another image.", fontSize = 12.sp)
                OutlinedButton({ picker.launch(arrayOf("image/*")) }, Modifier.fillMaxWidth()) { ReceiptIcon(if (receiptUri == null) R.drawable.receipt_attached else R.drawable.receipt_replace, 14); Spacer(Modifier.width(8.dp)); Text(if (receiptUri == null) "SELECT RECEIPT PHOTO" else "REPLACE PHOTO") }
                pickerError?.let { Text(it, fontSize = 12.sp, color = MaterialTheme.colorScheme.error) }
            }
            Panel(Amber) { Text("PAYMENT BREAKDOWN (COD)", fontWeight = FontWeight.ExtraBold); MoneyRow("Actual Product Cost", amount?.let(::money) ?: "—"); MoneyRow("Fixed Delivery Fee", money(6000L)); HorizontalDivider(color = Ink); Text("TOTAL TO COLLECT FROM CUSTOMER", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold); Text(total?.let(::money) ?: "—", fontSize = 30.sp, fontWeight = FontWeight.Black); Text("DIRECT CASH PAYMENT UPON DROP-OFF", fontSize = 10.sp) }
            Text("💡 Keep the physical store receipt ready. The customer will inspect it upon delivery at Zone 3, Mohon.", fontSize = 12.sp)
            Text("UI demo • The photo is selected locally and is not uploaded.", fontSize = 11.sp, color = Color.Gray)
        }
        HorizontalDivider(thickness = 2.dp, color = Ink)
        Button(enabled = amount != null && preview != null, onClick = { amount?.let { if (preview != null) onStartDelivery(it) } }, modifier = Modifier.fillMaxWidth().padding(16.dp).heightIn(min = 54.dp), colors = ButtonDefaults.buttonColors(containerColor = Ink, contentColor = Amber), shape = RoundedCornerShape(16.dp)) { Text("START DELIVERY TO CUSTOMER", fontSize = 13.sp, fontWeight = FontWeight.ExtraBold); Spacer(Modifier.width(8.dp)); ReceiptIcon(R.drawable.receipt_next, 20) }
    }
}

@Composable private fun Panel(color: Color = Color.White, content: @Composable ColumnScope.() -> Unit) { Column(Modifier.fillMaxWidth().background(color, RoundedCornerShape(16.dp)).border(2.dp, Ink, RoundedCornerShape(16.dp)).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp), content = content) }
@Composable private fun MoneyRow(label: String, value: String) { Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) { Text(label, Modifier.weight(1f), fontSize = 12.sp, color = Ink); Text(value, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Ink) } }
@Composable private fun ReceiptIcon(@DrawableRes id: Int, size: Int = 20) { Image(painterResource(id), null, Modifier.size(size.dp)) }
private fun parseCentavos(input: String): Long? { val n = input.trim(); if (!Regex("""\d{1,6}(\.\d{1,2})?""").matches(n)) return null; return try { BigDecimal(n).movePointRight(2).longValueExact().takeIf { it in 1L..99999999L } } catch (_: ArithmeticException) { null } catch (_: NumberFormatException) { null } }
private fun money(c: Long): String = "₱" + String.format(Locale.US, "%,d.%02d", c / 100, c % 100)
private fun readPreview(context: Context, uri: Uri): Bitmap? {
    return try {
        val resolver = context.contentResolver
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        resolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it, null, bounds) }
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
        var sample = 1
        while (bounds.outWidth / sample > 1200 || bounds.outHeight / sample > 1200) sample *= 2
        resolver.openInputStream(uri)?.use {
            BitmapFactory.decodeStream(it, null, BitmapFactory.Options().apply { inSampleSize = sample })
        }
    } catch (_: Exception) {
        null
    }
}
