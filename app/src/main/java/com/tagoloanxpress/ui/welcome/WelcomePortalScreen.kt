package com.tagoloanxpress.ui.welcome

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TwoWheeler
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BrandAmber = Color(0xFFFFBD1F)
private val InkBlack = Color(0xFF1A1A1A)
private val SurfaceWhite = Color.White
private val MutedText = Color(0xFF525252)

@Composable
fun WelcomePortalScreen(
    onCustomerClick: () -> Unit,
    onRiderClick: () -> Unit,
    onAdminClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.fillMaxSize().background(BrandAmber).statusBarsPadding(),
    ) {
        Column(
            Modifier.fillMaxWidth().weight(.46f).padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedHeroTitle("TAGOLOAN")
            OutlinedHeroTitle("XPRESS")
            Spacer(Modifier.height(10.dp))
            Text(
                "What do you need, and where should we get it?",
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = InkBlack, textAlign = TextAlign.Center),
            )
            Spacer(Modifier.height(24.dp))
            Box(
                Modifier.size(100.dp).clip(CircleShape).background(Color(0xFFF6B000))
                    .border(2.dp, InkBlack, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Canvas(Modifier.size(32.dp)) {
                    val stroke = 2.5.dp.toPx()
                    drawLine(InkBlack, Offset.Zero, Offset(size.width, size.height), stroke, StrokeCap.Round)
                    drawLine(InkBlack, Offset(size.width, 0f), Offset(0f, size.height), stroke, StrokeCap.Round)
                }
            }
        }
        val sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
        Column(
            Modifier.fillMaxWidth().weight(.54f).clip(sheetShape).background(SurfaceWhite, sheetShape)
                .border(2.dp, InkBlack, sheetShape).navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 28.dp),
        ) {
            Text(
                "Welcome! Select your portal to\ncontinue:",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black, color = InkBlack, lineHeight = 25.sp),
            )
            Spacer(Modifier.height(6.dp))
            Box(Modifier.width(42.dp).height(4.dp).background(BrandAmber, RoundedCornerShape(2.dp)))
            Spacer(Modifier.height(22.dp))
            PortalSelectionCard(
                "I AM A CUSTOMER", "Request errands, groceries, items & deliveries",
                Icons.Outlined.ShoppingBag, BrandAmber, SurfaceWhite, onCustomerClick,
            )
            Spacer(Modifier.height(16.dp))
            PortalSelectionCard(
                "I AM A RIDER", "Accept and fulfill Pasugo requests in Tagoloan",
                Icons.Filled.TwoWheeler, SurfaceWhite, Color(0xFFFFF6DC), onRiderClick,
            )
            Spacer(Modifier.weight(1f))
            Row(
                Modifier.align(Alignment.CenterHorizontally).clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onAdminClick).padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("🔑 ", fontSize = 13.sp)
                Text(
                    "Admin Portal Access",
                    style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = InkBlack, textDecoration = TextDecoration.Underline),
                )
            }
        }
    }
}

@Composable
private fun OutlinedHeroTitle(text: String) {
    Box(contentAlignment = Alignment.Center) {
        val style = TextStyle(
            fontSize = 40.sp, fontWeight = FontWeight.Black, fontStyle = FontStyle.Italic,
            letterSpacing = 2.sp,
        )
        Text(text, Modifier.offset(2.dp, 2.dp), style = style.copy(color = InkBlack))
        Text(text, style = style.copy(color = BrandAmber, drawStyle = Stroke(width = 6f)))
        Text(text, style = style.copy(color = InkBlack, drawStyle = Stroke(width = 3f)))
    }
}

@Composable
private fun PortalSelectionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    cardColor: Color,
    iconBoxColor: Color,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(16.dp)
    Box(
        Modifier.fillMaxWidth().padding(bottom = 4.dp).portalBottomShadow(InkBlack, 4.dp, 16.dp)
            .clip(shape).background(cardColor, shape).border(2.dp, InkBlack, shape)
            .clickable(onClick = onClick).padding(horizontal = 16.dp, vertical = 18.dp),
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)).background(iconBoxColor)
                    .border(2.dp, InkBlack, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(icon, null, tint = InkBlack, modifier = Modifier.size(24.dp))
            }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(title, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Black, color = InkBlack, letterSpacing = .3.sp))
                Spacer(Modifier.height(3.dp))
                Text(
                    subtitle, maxLines = 1, overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium, color = MutedText),
                )
            }
        }
    }
}

private fun Modifier.portalBottomShadow(color: Color, yOffset: Dp, corner: Dp) = drawBehind {
    drawRoundRect(color, Offset(0f, yOffset.toPx()), size, CornerRadius(corner.toPx()))
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
private fun WelcomePortalScreenPreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = BrandAmber, background = BrandAmber)) {
        WelcomePortalScreen({}, {}, {})
    }
}
