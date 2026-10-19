package com.tagoloanxpress.ui.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* ----------------------------- Tokens ----------------------------- */

object TxColors {
    val Amber = Color(0xFFFFBD1F)
    val AmberTint = Color(0xFFFFF1C7)
    val AmberText = Color(0xFFD99A00)
    val AmberDark = Color(0xFF7A5A00)
    val Ink = Color(0xFF1A1A1A)
    val Cream = Color(0xFFFFFDF5)
    val Surface = Color(0xFFFFFFFF)
    val SurfaceMuted = Color(0xFFF0EEE6)
    val NoticeBackground = Color(0xFFFFF4D6)
    val Muted = Color(0xFF6B6B6B)
    val Placeholder = Color(0xFF9E9E9E)
    val Success = Color(0xFF2E7D32)
    val SuccessContainer = Color(0xFFE6F4EA)
    val Error = Color(0xFFD32F2F)
    val ErrorContainer = Color(0xFFFDECEA)
}

object TxDimens {
    val Border = 2.dp
    val ShadowSmall = 3.dp
    val ShadowButton = 4.dp
    val CornerControl = 14.dp
    val CornerCard = 16.dp
}

/* ------------------------------ Theme ------------------------------ */

private val TxColorScheme = lightColorScheme(
    primary = TxColors.Amber,
    onPrimary = TxColors.Ink,
    background = TxColors.Cream,
    onBackground = TxColors.Ink,
    surface = TxColors.Surface,
    onSurface = TxColors.Ink,
    error = TxColors.Error,
    errorContainer = TxColors.ErrorContainer,
    onErrorContainer = TxColors.Error,
)

@Composable
fun TagoloanTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = TxColorScheme, content = content)
}

/* ----------------------------- Modifiers ---------------------------- */

/** Solid, un-blurred rounded rect offset down-right behind the composable. */
fun Modifier.hardShadow(
    color: Color = TxColors.Ink,
    offset: Dp = TxDimens.ShadowSmall,
    corner: Dp = TxDimens.CornerControl,
): Modifier = this.drawBehind {
    drawRoundRect(
        color = color,
        topLeft = Offset(offset.toPx(), offset.toPx()),
        size = size,
        cornerRadius = CornerRadius(corner.toPx()),
    )
}

/* ---------------------------- Components ---------------------------- */

@Composable
fun TxButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = TxColors.Amber,
    contentColor: Color = TxColors.Ink,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leadingEmoji: String? = null,
    trailingIcon: ImageVector? = null,
) {
    val shape = RoundedCornerShape(TxDimens.CornerControl)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = TxDimens.ShadowButton, bottom = TxDimens.ShadowButton)
            .height(54.dp)
            .hardShadow(offset = TxDimens.ShadowButton)
            .clip(shape)
            .background(if (enabled || isLoading) containerColor else containerColor.copy(alpha = 0.55f))
            .border(TxDimens.Border, TxColors.Ink, shape)
            .clickable(enabled = enabled && !isLoading, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = contentColor,
                strokeWidth = 3.dp,
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                if (leadingEmoji != null) Text(leadingEmoji, style = TextStyle(fontSize = 14.sp))
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = contentColor,
                        letterSpacing = 0.3.sp,
                    ),
                )
                if (trailingIcon != null) {
                    Icon(trailingIcon, contentDescription = null, tint = contentColor, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

@Composable
fun TxIconButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    containerColor: Color = TxColors.Cream,
) {
    Box(
        modifier = modifier
            .size(44.dp)
            .hardShadow(corner = 22.dp)
            .clip(shape)
            .background(containerColor)
            .border(TxDimens.Border, TxColors.Ink, shape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(icon, contentDescription, tint = TxColors.Ink, modifier = Modifier.size(22.dp))
    }
}

/** Label row (with optional right-aligned accessory) above a thick-outlined input. */
@Composable
fun TxTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    labelAccessory: (@Composable () -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    trailingContent: (@Composable () -> Unit)? = null,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = label,
                style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, color = TxColors.Ink),
            )
            labelAccessory?.invoke()
        }
        val shape = RoundedCornerShape(TxDimens.CornerControl)
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TxColors.Ink),
            cursorBrush = SolidColor(TxColors.Ink),
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            keyboardActions = keyboardActions,
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { inner ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .hardShadow()
                        .background(TxColors.Surface, shape)
                        .border(TxDimens.Border, TxColors.Ink, shape)
                        .padding(horizontal = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(leadingIcon, contentDescription = null, tint = TxColors.Ink, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(12.dp))
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = TextStyle(fontSize = 16.sp, color = TxColors.Placeholder))
                        }
                        inner()
                    }
                    trailingContent?.invoke()
                }
            },
        )
    }
}

/** Amber info/notice box (e.g. "New rider accounts require Admin verification"). */
@Composable
fun TxNotice(
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color = TxColors.NoticeBackground,
    borderColor: Color = TxColors.Amber,
) {
    val shape = RoundedCornerShape(TxDimens.CornerControl)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(containerColor, shape)
            .border(TxDimens.Border, borderColor, shape)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Box(
            modifier = Modifier
                .size(26.dp)
                .background(borderColor, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(Icons.Filled.Info, contentDescription = null, tint = TxColors.Ink, modifier = Modifier.size(16.dp))
        }
        Text(
            text = text,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TxColors.Ink, lineHeight = 17.sp),
        )
    }
}
