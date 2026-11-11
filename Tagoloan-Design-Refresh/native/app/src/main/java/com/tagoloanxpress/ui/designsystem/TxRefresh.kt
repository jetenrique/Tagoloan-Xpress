package com.tagoloanxpress.ui.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tagoloanxpress.R

/** Tokens from the visible customer/rider frames reviewed 2026-11-11. */
object TxRefresh {
    val Background = Color(0xFFFBF9F1)
    val Surface = Color.White
    val Ink = Color(0xFF18181F)
    val Muted = Color(0xFF6B6B73)
    val Placeholder = Color(0xFFA3A3AB)
    val Border = Color(0xFFECE8DF)
    val Amber = Color(0xFFFEBC20)
    val AmberTint = Color(0xFFFFF7E0)
    val AmberText = Color(0xFF6B4E00)
    val Green = Color(0xFF1E9E5A)
    val GreenTint = Color(0xFFE5F5ED)
    val Red = Color(0xFFFF3030)
    val RedTint = Color(0xFFFFEDEE)
    val Neutral = Color(0xFFF3F1EA)
    val PagePadding = 16.dp
    val AuthPadding = 24.dp
    val CardShape = RoundedCornerShape(16.dp)
    val ButtonShape = RoundedCornerShape(14.dp)
    val FieldShape = RoundedCornerShape(12.dp)
    val Jakarta = FontFamily(
        Font(R.font.tx_jakarta_regular, FontWeight.Normal),
        Font(R.font.tx_jakarta_medium, FontWeight.Medium),
        Font(R.font.tx_jakarta_semibold, FontWeight.SemiBold),
        Font(R.font.tx_jakarta_bold, FontWeight.Bold),
    )

    private fun style(size: Int, weight: FontWeight = FontWeight.Normal) = TextStyle(
        fontFamily = Jakarta, fontWeight = weight, fontSize = size.sp,
        lineHeight = (size * 1.35f).sp, letterSpacing = 0.sp,
    )
    val Typography = androidx.compose.material3.Typography(
        displayLarge = style(40, FontWeight.Bold),
        displayMedium = style(36, FontWeight.Bold),
        displaySmall = style(32, FontWeight.Bold),
        headlineLarge = style(28, FontWeight.Bold),
        headlineMedium = style(24, FontWeight.Bold),
        headlineSmall = style(22, FontWeight.Bold),
        titleLarge = style(20, FontWeight.Bold),
        titleMedium = style(16, FontWeight.SemiBold),
        titleSmall = style(15, FontWeight.SemiBold),
        bodyLarge = style(15), bodyMedium = style(14), bodySmall = style(12),
        labelLarge = style(15, FontWeight.SemiBold),
        labelMedium = style(13, FontWeight.Medium),
        labelSmall = style(11, FontWeight.Medium),
    )
    val Colors = lightColorScheme(
        primary = Amber, onPrimary = Ink,
        secondary = AmberText, onSecondary = Color.White,
        primaryContainer = AmberTint, onPrimaryContainer = AmberText,
        background = Background, onBackground = Ink,
        surface = Surface, onSurface = Ink, onSurfaceVariant = Muted,
        surfaceVariant = Neutral, outline = Border, outlineVariant = Border,
        error = Red, onError = Color.White,
        errorContainer = RedTint, onErrorContainer = Red,
    )
}

/** Install once around the existing app content, keeping its navigation/state. */
@Composable
fun TxRefreshTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = TxRefresh.Colors, typography = TxRefresh.Typography) {
        CompositionLocalProvider(LocalContentColor provides TxRefresh.Ink, content = content)
    }
}

/** Plain content. The destination or dashboard owns scrolling, never both. */
@Composable
fun TxRefreshCard(
    modifier: Modifier = Modifier,
    color: Color = TxRefresh.Surface,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier.fillMaxWidth().clip(TxRefresh.CardShape)
            .background(color).border(1.dp, TxRefresh.Border, TxRefresh.CardShape)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp), content = content,
    )
}

@Composable
fun TxRefreshButton(
    text: String, onClick: () -> Unit, modifier: Modifier = Modifier,
    enabled: Boolean = true, secondary: Boolean = false,
    dark: Boolean = false, loading: Boolean = false,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
) {
    val container = if (secondary) Color.White else if (dark) TxRefresh.Ink else TxRefresh.Amber
    val foreground = if (dark && !secondary) Color.White else TxRefresh.Ink
    Button(
        onClick = onClick, enabled = enabled && !loading,
        modifier = modifier.fillMaxWidth().heightIn(min = 50.dp),
        shape = TxRefresh.ButtonShape,
        border = if (secondary) androidx.compose.foundation.BorderStroke(1.dp, TxRefresh.Border) else null,
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = container, contentColor = foreground),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 13.dp),
    ) {
        if (loading) CircularProgressIndicator(Modifier.size(20.dp), color = foreground, strokeWidth = 2.dp)
        else Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            leading?.invoke()
            Text(text, style = MaterialTheme.typography.labelLarge, textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f, fill = false))
            trailing?.invoke()
        }
    }
}

@Composable
fun TxRefreshField(
    label: String, value: String, onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier, placeholder: String = "", enabled: Boolean = true,
    error: String? = null, optional: Boolean = false, singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    transformation: VisualTransformation = VisualTransformation.None,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
) {
    val interaction = remember { MutableInteractionSource() }
    val focused by interaction.collectIsFocusedAsState()
    Column(modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(label, Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
            if (optional) Text("Optional", color = TxRefresh.Placeholder, style = MaterialTheme.typography.bodySmall)
        }
        BasicTextField(
            value = value, onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().semantics { contentDescription = label },
            enabled = enabled, singleLine = singleLine,
            minLines = if (singleLine) 1 else 3,
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = TxRefresh.Ink),
            cursorBrush = SolidColor(TxRefresh.Ink),
            keyboardOptions = keyboardOptions, visualTransformation = transformation,
            interactionSource = interaction,
            decorationBox = { inner ->
                Row(Modifier.fillMaxWidth().heightIn(min = if (singleLine) 48.dp else 80.dp)
                    .background(Color.White, TxRefresh.FieldShape)
                    .border(1.dp, if (error != null) TxRefresh.Red else if (focused) TxRefresh.Amber else TxRefresh.Border, TxRefresh.FieldShape)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    leading?.invoke()
                    Box(Modifier.weight(1f)) {
                        if (value.isEmpty()) Text(placeholder, color = TxRefresh.Placeholder, style = MaterialTheme.typography.bodyLarge)
                        inner()
                    }
                    trailing?.invoke()
                }
            },
        )
        if (error != null) Text(error, color = TxRefresh.Red, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun TxRefreshBadge(text: String, color: Color = TxRefresh.AmberTint, ink: Color = TxRefresh.AmberText) {
    Text(text, Modifier.background(color, CircleShape).padding(horizontal = 10.dp, vertical = 4.dp),
        color = ink, style = MaterialTheme.typography.bodySmall)
}

@Composable
fun TxRefreshMoneyRow(label: String, value: String, total: Boolean = false) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(label, Modifier.weight(1f), color = if (total) TxRefresh.Ink else TxRefresh.Muted,
            style = if (total) MaterialTheme.typography.titleSmall else MaterialTheme.typography.bodyMedium)
        Text(value, style = if (total) MaterialTheme.typography.titleLarge else MaterialTheme.typography.titleSmall)
    }
}

@Composable
fun TxRefreshSteps(labels: List<String>, current: Int) {
    require(labels.isNotEmpty() && current in labels.indices)
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            labels.forEachIndexed { index, _ ->
                Box(Modifier.weight(1f).height(4.dp).background(
                    if (index <= current) TxRefresh.Amber else TxRefresh.Border, CircleShape))
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            labels.forEachIndexed { index, label ->
                Text(label, Modifier.weight(1f),
                    color = if (index == current) TxRefresh.Ink else TxRefresh.Muted,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = if (index == current) FontWeight.SemiBold else FontWeight.Normal)
            }
        }
    }
}

/** The caller passes exact downloaded Figma assets, with each asset's slot size. */
@Composable
fun TxRefreshAsset(@DrawableRes id: Int, width: Float, height: Float = width, description: String? = null) {
    Image(painterResource(id), description, Modifier.size(width.dp, height.dp))
}

data class TxRefreshNavItem(val label: String, @DrawableRes val asset: Int, val width: Float, val height: Float)

/** Inset handling belongs to the enclosing destination; do not duplicate it. */
@Composable
fun TxRefreshBottomBar(items: List<TxRefreshNavItem>, selected: String, onSelect: (String) -> Unit) {
    Surface(color = Color.White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp), shadowElevation = 2.dp) {
        Row(Modifier.fillMaxWidth().heightIn(min = 64.dp).padding(horizontal = 4.dp)) {
            items.forEach { item ->
                val active = item.label == selected
                Column(
                    Modifier.weight(1f).heightIn(min = 64.dp)
                        .clickable(role = Role.Tab, onClick = { onSelect(item.label) })
                        .semantics { contentDescription = item.label; this.selected = active },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Box(Modifier.size(40.dp, 28.dp).background(if (active) TxRefresh.Amber else Color.Transparent, CircleShape), Alignment.Center) {
                        TxRefreshAsset(item.asset, item.width, item.height)
                    }
                    Spacer(Modifier.height(2.dp))
                    Text(item.label, style = MaterialTheme.typography.labelSmall,
                        color = if (active) TxRefresh.Ink else TxRefresh.Muted)
                }
            }
        }
    }
}
