package com.tagoloanxpress.customer.ui.create

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Amber = Color(0xFFFFBD1F)
private val Ink = Color(0xFF1A1A1A)
private val Muted = Color(0xFF666666)

@Composable
fun CreatePasugoStep2Screen(onConfirmClick: () -> Unit = {}, onBackClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().background(Color.White).statusBarsPadding()) {
        Row(Modifier.fillMaxWidth().padding(20.dp, 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", Modifier.size(28.dp).clickable(onClick = onBackClick)); Spacer(Modifier.width(12.dp)); Column(Modifier.weight(1f)) { Text("Pickup Location (2/4)", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("Step 2 • Where should the rider purchase/pickup?", color = Muted, fontSize = 11.sp) }; Box(Modifier.size(36.dp).background(Amber, CircleShape), Alignment.Center) { Text("TX", fontWeight = FontWeight.Black) }
        }
        HorizontalDivider(color = Ink, thickness = 2.dp)
        Box(Modifier.weight(1f).fillMaxWidth()) {
            MapCanvas()
            Column(Modifier.padding(16.dp)) {
                Row(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(24.dp)).border(2.dp, Ink, RoundedCornerShape(24.dp)).padding(16.dp, 12.dp), verticalAlignment = Alignment.CenterVertically) { Icon(Icons.Filled.Search, null, Modifier.size(24.dp)); Spacer(Modifier.width(12.dp)); Column(Modifier.weight(1f)) { Text("SEARCH ESTABLISHMENT", color = Amber, fontSize = 10.sp, fontWeight = FontWeight.Bold); Text("Minute Burger - Tagoloan Branch", fontSize = 15.sp, fontWeight = FontWeight.Black) }; Icon(Icons.Filled.Close, "Clear", Modifier.size(20.dp), tint = Muted) }
                Spacer(Modifier.height(12.dp)); Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { Chip("Minute Burger", true); Chip("Jollibee Tagoloan", false); Chip("Gaisano Supermarket", false) }
            }
            Icon(Icons.Filled.LocationOn, "Pickup", tint = Color(0xFFE53935), modifier = Modifier.align(Alignment.Center).offset(y = (-30).dp).size(60.dp))
            Column(Modifier.align(Alignment.BottomStart).padding(16.dp)) { Box(Modifier.background(Color.White, RoundedCornerShape(12.dp)).border(2.dp, Ink, RoundedCornerShape(12.dp))) { Column { Icon(Icons.Filled.Add, "Zoom In", Modifier.padding(12.dp).size(24.dp)); HorizontalDivider(color = Ink); Icon(Icons.Filled.Remove, "Zoom Out", Modifier.padding(12.dp).size(24.dp)) } } }
            Box(Modifier.align(Alignment.BottomEnd).padding(16.dp)) { Box(Modifier.size(56.dp).background(Color.White, CircleShape).border(2.dp, Ink, CircleShape), Alignment.Center) { Icon(Icons.Filled.GpsFixed, "My Location") } }
        }
        Column(Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(24.dp)).border(2.dp, Ink, RoundedCornerShape(24.dp)).padding(24.dp)) {
            Box(Modifier.align(Alignment.CenterHorizontally).width(40.dp).height(4.dp).background(Color.LightGray, RoundedCornerShape(2.dp))); Spacer(Modifier.height(20.dp))
            Text("SELECTED PICKUP LOCATION", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Black); Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) { Box(Modifier.size(48.dp).background(Color(0xFFFAF6EC), RoundedCornerShape(12.dp)), Alignment.Center) { Icon(Icons.Outlined.Fastfood, null, tint = Color(0xFFD68A22)) }; Spacer(Modifier.width(12.dp)); Column { Text("Minute Burger - Tagoloan", fontSize = 18.sp, fontWeight = FontWeight.Black); Text("National Highway, Poblacion, Tagoloan, Misamis Oriental", color = Muted, fontSize = 11.sp) } }
            Spacer(Modifier.height(20.dp)); Text("📈 Est. 1.8 km away   🟢 Open 24/7   P40 Base Rider Fee", color = Muted, fontSize = 10.sp); Spacer(Modifier.height(20.dp))
            Box(Modifier.fillMaxWidth().background(Amber, RoundedCornerShape(12.dp)).border(2.dp, Ink, RoundedCornerShape(12.dp)).clickable(onClick = onConfirmClick).padding(vertical = 16.dp), Alignment.Center) { Row(verticalAlignment = Alignment.CenterVertically) { Text("CONFIRM PICKUP LOCATION", fontSize = 15.sp, fontWeight = FontWeight.Black); Spacer(Modifier.width(8.dp)); Icon(Icons.AutoMirrored.Filled.ArrowForward, null, Modifier.size(20.dp)) } }
        }
    }
}

@Composable private fun Chip(label: String, selected: Boolean) { Text(label, Modifier.background(if (selected) Amber else Color.White, RoundedCornerShape(16.dp)).border(1.dp, Ink, RoundedCornerShape(16.dp)).padding(12.dp, 6.dp), fontSize = 11.sp, fontWeight = FontWeight.Bold) }
@Composable private fun MapCanvas() { Canvas(Modifier.fillMaxSize().background(Color(0xFFE8F1EC))) { drawLine(Color(0xFFFFE699), Offset(0f, size.height * .4f), Offset(size.width, size.height * .6f), 40f); drawPath(Path().apply { moveTo(0f, size.height * .2f); quadraticBezierTo(size.width * .3f, size.height * .3f, size.width * .4f, 0f) }, Color(0xFFAFDCEB), style = Stroke(80f)); drawLine(Color.White, Offset(size.width * .2f, 0f), Offset(size.width * .2f, size.height), 12f); drawLine(Color.White, Offset(size.width * .7f, 0f), Offset(size.width * .7f, size.height), 12f); drawLine(Color.White, Offset(0f, size.height * .7f), Offset(size.width, size.height * .7f), 12f) } }
