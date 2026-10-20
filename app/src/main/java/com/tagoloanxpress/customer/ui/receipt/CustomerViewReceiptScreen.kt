package com.tagoloanxpress.customer.ui.receipt

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomerViewReceiptScreen(onCloseReceiptClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    var enlarged by remember { mutableStateOf(false) }
    Box(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).padding(20.dp)) {
        Column(Modifier.fillMaxSize()) { Text("Receipt #TGX-8921", fontSize = 20.sp, fontWeight = FontWeight.Black); Spacer(Modifier.height(18.dp)); Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(20.dp)).border(2.dp, Color(0xFF1A1A1A), RoundedCornerShape(20.dp)).padding(18.dp)) { Text("TAGOLOAN XPRESS", fontWeight = FontWeight.Black); Text("VERIFIED ERRAND TRANSACTION", color = Color(0xFF8B6508)); Spacer(Modifier.height(20.dp)); Text("Store Product Receipt   ₱195.00"); Text("Delivery Fee            ₱60.00"); Text("Cash Tendered           ₱500.00"); Text("Change Returned         ₱245.00"); Spacer(Modifier.height(16.dp)); Text("TOTAL CASH PAID TO RIDER   ₱255.00", fontSize = 18.sp, fontWeight = FontWeight.Black); Spacer(Modifier.height(20.dp)); Box(Modifier.fillMaxWidth().height(150.dp).background(Color(0xFF423D36), RoundedCornerShape(14.dp)).clickable { enlarged = true }, Alignment.Center) { Text("🧾 TAP TO ENLARGE RECEIPT", color = Color.White, fontWeight = FontWeight.Black) } }; Spacer(Modifier.weight(1f)); Text("CLOSE RECEIPT", Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(12.dp)).clickable(onClick = onCloseReceiptClick).padding(14.dp), fontWeight = FontWeight.Black) }
        if (enlarged) Box(Modifier.fillMaxSize().background(Color.Black.copy(.75f)).clickable { enlarged = false }.padding(24.dp), Alignment.Center) { Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(16.dp)).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) { Text("MINUTE BURGER - TAGOLOAN", fontWeight = FontWeight.Black); Spacer(Modifier.height(20.dp)); Text("2x Burger                 ₱150.00"); Text("2x Choco Malt              ₱45.00"); Text("TOTAL STORE RECEIPT       ₱195.00", fontWeight = FontWeight.Black); Spacer(Modifier.height(20.dp)); Text("CLOSE PREVIEW", color = Color(0xFF8B6508), fontWeight = FontWeight.Black) } }
    }
}
