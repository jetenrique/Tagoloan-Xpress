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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
fun CustomerReceiptReviewScreen(itemName: String = "Minute Burger", quantity: Int = 2, storeReceiptAmount: Int = 195, deliveryFee: Int = 60, onViewDetailedReceiptClick: () -> Unit = {}, onSubmitAndReturnHome: () -> Unit = {}, onCloseClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    var stars by remember { mutableIntStateOf(5) }; var comment by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize().background(Color(0xFFFAF7F0)).padding(20.dp)) {
        Text("Receipt & Review", fontSize = 20.sp, fontWeight = FontWeight.Black); Spacer(Modifier.height(20.dp)); Text("Pasugo Completed!", fontSize = 24.sp, fontWeight = FontWeight.Black)
        Spacer(Modifier.height(16.dp)); Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).border(2.dp, Color(0xFF1A1A1A), RoundedCornerShape(18.dp)).padding(16.dp)) { Text("FINAL PAYMENT SUMMARY", fontWeight = FontWeight.Black); Spacer(Modifier.height(12.dp)); Text("$itemName (${quantity}x Packs) • ₱$storeReceiptAmount.00", Modifier.clickable(onClick = onViewDetailedReceiptClick), fontWeight = FontWeight.Bold); Text("Delivery fee • ₱$deliveryFee.00"); Text("Total paid in cash • ₱${storeReceiptAmount + deliveryFee}.00", fontWeight = FontWeight.Black) }
        Spacer(Modifier.height(16.dp)); Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(18.dp)).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) { Text("Rate Your Rider", fontSize = 17.sp, fontWeight = FontWeight.Black); Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { (1..5).forEach { star -> Icon(Icons.Filled.Star, "$star Stars", Modifier.size(40.dp).clickable { stars = star }, tint = if (star <= stars) Color(0xFFFFBD1F) else Color.LightGray) } }; Text("$stars.0 • Excellent Service", fontWeight = FontWeight.Bold); Spacer(Modifier.height(12.dp)); BasicTextField(comment, { comment = it }, Modifier.fillMaxWidth().height(70.dp).border(1.dp, Color.Black, RoundedCornerShape(10.dp)).padding(10.dp)) }
        Spacer(Modifier.weight(1f)); Box(Modifier.fillMaxWidth().background(Color(0xFFFFBD1F), RoundedCornerShape(14.dp)).clickable(onClick = onSubmitAndReturnHome).padding(16.dp), Alignment.Center) { Text("SUBMIT FEEDBACK & RETURN HOME", fontWeight = FontWeight.Black) }
    }
}
