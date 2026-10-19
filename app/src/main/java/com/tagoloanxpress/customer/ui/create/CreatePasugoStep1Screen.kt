package com.tagoloanxpress.customer.ui.create

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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.LocalPharmacy
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Subject
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* -------------------------------------------------------------------------- */
/*  UI State (Holds the typed data)                                           */
/* -------------------------------------------------------------------------- */

data class CreatePasugoStep1UiState(
    val selectedCategory: String = "Food",
    val itemName: String = "",
    val quantity: Int = 1,
    val instructions: String = "",
    val budget: String = "",
    val selectedPayment: String = "Cash on Delivery"
)

/* -------------------------------------------------------------------------- */
/*  Design Tokens                                                             */
/* -------------------------------------------------------------------------- */

private val BrandAmber = Color(0xFFFFBD1F)
private val InkBlack = Color(0xFF1A1A1A)
private val CreamBg = Color(0xFFFAF6EC)
private val SurfaceWhite = Color(0xFFFFFFFF)
private val MutedText = Color(0xFF666666)
private val NoticeBg = Color(0xFFEBE6DA)

/* -------------------------------------------------------------------------- */
/*  Main Screen                                                               */
/* -------------------------------------------------------------------------- */

@Composable
fun CreatePasugoStep1Screen(
    state: CreatePasugoStep1UiState,
    onCategorySelect: (String) -> Unit,
    onItemNameChange: (String) -> Unit,
    onQuantityChange: (Int) -> Unit,
    onInstructionsChange: (String) -> Unit,
    onBudgetChange: (String) -> Unit,
    onPaymentSelect: (String) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CreamBg)
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
    ) {
        TopBar(onBackClick = onBackClick)

        // Progress Bar
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "STEP 1 OF 4",
                    modifier = Modifier.background(BrandAmber, RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp),
                    style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Black),
                )
                Spacer(Modifier.width(8.dp))
                Text("Item Details", style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Black))
            }
            Text("25%", style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Black))
        }
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).height(6.dp).background(Color(0xFFE0DCD3), RoundedCornerShape(3.dp))) {
            Box(modifier = Modifier.fillMaxWidth(0.25f).height(6.dp).background(BrandAmber, RoundedCornerShape(3.dp)))
        }

        Spacer(Modifier.height(20.dp))

        // Scrollable Form Area (Remember: Click and drag up to scroll in emulator)
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
        ) {
            Text("What do you need?", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Black))
            Text("Select errand category to customize rider instructions.", style = TextStyle(fontSize = 13.sp, color = MutedText))

            Spacer(Modifier.height(16.dp))
            CategoryGrid(selectedCategory = state.selectedCategory, onSelect = onCategorySelect)

            Spacer(Modifier.height(20.dp))

            // Item Name Input
            InteractiveTextFieldCard(
                title = "ITEM / PRODUCT NAME",
                value = state.itemName,
                onValueChange = onItemNameChange,
                placeholder = "e.g., Minute Burger",
                leadingIcon = Icons.Filled.Storefront,
                keyboardType = KeyboardType.Text
            )

            Spacer(Modifier.height(16.dp))

            // Quantity Stepper
            Column(modifier = Modifier.fillMaxWidth().background(SurfaceWhite, RoundedCornerShape(12.dp)).padding(16.dp)) {
                Text("QUANTITY", style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Black, color = MutedText))
                Text("Number of items / packs", style = TextStyle(fontSize = 12.sp, color = MutedText))
                Spacer(Modifier.height(12.dp))
                Row(
                    modifier = Modifier.background(CreamBg, RoundedCornerShape(8.dp)).border(1.dp, Color(0xFFD6D1C4), RoundedCornerShape(8.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(modifier = Modifier.size(40.dp).clickable { if (state.quantity > 1) onQuantityChange(state.quantity - 1) }, contentAlignment = Alignment.Center) { Text("—", fontWeight = FontWeight.Bold, fontSize = 18.sp) }
                    Text("${state.quantity}", modifier = Modifier.padding(horizontal = 16.dp), style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Black))
                    Box(modifier = Modifier.size(40.dp).clickable { onQuantityChange(state.quantity + 1) }, contentAlignment = Alignment.Center) { Text("+", fontWeight = FontWeight.Bold, fontSize = 18.sp) }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Instructions Input
            InteractiveTextFieldCard(
                title = "INSTRUCTIONS / DESCRIPTION",
                value = state.instructions,
                onValueChange = onInstructionsChange,
                placeholder = "e.g., No onions, please.",
                keyboardType = KeyboardType.Text,
                actionText = "Optional",
                footer = {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 12.dp)) {
                        Icon(Icons.Filled.Info, contentDescription = null, tint = MutedText, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Be specific about flavor, size, or preferred alternate branch.", style = TextStyle(fontSize = 11.sp, color = MutedText))
                    }
                }
            )

            Spacer(Modifier.height(16.dp))

            // Budget Input
            InteractiveTextFieldCard(
                title = "ESTIMATED BUDGET / PRODUCT AMOUNT",
                value = state.budget,
                onValueChange = onBudgetChange,
                placeholder = "200",
                leadingText = "₱",
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                footer = {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 12.dp).background(NoticeBg, RoundedCornerShape(8.dp)).padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(Icons.Filled.Receipt, contentDescription = null, tint = Color(0xFF8B6B22), modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Rider will advance-purchase the item and present the physical store receipt upon delivery.", style = TextStyle(fontSize = 11.sp, color = MutedText, lineHeight = 14.sp))
                    }
                }
            )

            Spacer(Modifier.height(16.dp))
            Text("PAYMENT METHOD", style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Black, color = MutedText))
            Text("Choose how you will pay the rider", style = TextStyle(fontSize = 12.sp, color = MutedText))
            Spacer(Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                PaymentOptionCard("Cash on Delivery", "Pay cash to rider upon drop-off", Icons.Filled.Payments, state.selectedPayment == "Cash on Delivery", Modifier.weight(1f)) { onPaymentSelect("Cash on Delivery") }
                PaymentOptionCard("GCash", "Scan rider QR or send to GCash number", Icons.Outlined.AccountBalanceWallet, state.selectedPayment == "GCash", Modifier.weight(1f)) { onPaymentSelect("GCash") }
            }

            Spacer(Modifier.height(32.dp))
        }

        // Bottom Action Bar
        Box(modifier = Modifier.fillMaxWidth().background(CreamBg).padding(20.dp)) {
            val isFormValid = state.itemName.isNotBlank() && state.budget.isNotBlank()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (isFormValid) BrandAmber else BrandAmber.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .clickable(enabled = isFormValid, onClick = onNextClick)
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("CONTINUE TO PICKUP LOCATION", style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Black, color = InkBlack))
                    Spacer(Modifier.width(8.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

/* -------------------------------------------------------------------------- */
/*  Private Interactive Components                                            */
/* -------------------------------------------------------------------------- */

@Composable
private fun TopBar(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", modifier = Modifier.size(28.dp).clickable(onClick = onBackClick))
        Spacer(Modifier.width(16.dp))
        Text("Create Pasugo (1/4)", modifier = Modifier.weight(1f), style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Black))
        Box(modifier = Modifier.size(36.dp).background(Color(0xFF6E5000), CircleShape), contentAlignment = Alignment.Center) {
            Icon(Icons.Filled.Person, contentDescription = null, tint = SurfaceWhite, modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
private fun InteractiveTextFieldCard(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    leadingText: String? = null,
    actionText: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    footer: @Composable (() -> Unit)? = null
) {
    Column(modifier = Modifier.fillMaxWidth().background(SurfaceWhite, RoundedCornerShape(12.dp)).padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(title, style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Black, color = MutedText))
            if (actionText != null) Text(actionText, style = TextStyle(fontSize = 12.sp, color = MutedText))
        }
        Spacer(Modifier.height(12.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold, color = InkBlack),
            cursorBrush = SolidColor(InkBlack),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            decorationBox = { innerTextField ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (leadingIcon != null) {
                        Icon(leadingIcon, contentDescription = null, tint = Color(0xFF8B6B22), modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                    }
                    if (leadingText != null) {
                        Box(modifier = Modifier.size(30.dp).background(BrandAmber, RoundedCornerShape(6.dp)), contentAlignment = Alignment.Center) {
                            Text(leadingText, fontWeight = FontWeight.Black)
                        }
                        Spacer(Modifier.width(12.dp))
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = TextStyle(fontSize = 16.sp, color = Color(0xFFBDBDBD)))
                        }
                        innerTextField()
                    }
                }
            }
        )
        footer?.invoke()
    }
}

@Composable
private fun CategoryGrid(selectedCategory: String, onSelect: (String) -> Unit) {
    Column {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CategoryOptionCard("Food", "Meals & snacks", Icons.Outlined.Fastfood, selectedCategory == "Food", Modifier.weight(1f)) { onSelect("Food") }
            CategoryOptionCard("Groceries", "Market run", Icons.Outlined.ShoppingCart, selectedCategory == "Groceries", Modifier.weight(1f)) { onSelect("Groceries") }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CategoryOptionCard("Essentials", "Meds & care", Icons.Outlined.LocalPharmacy, selectedCategory == "Essentials", Modifier.weight(1f)) { onSelect("Essentials") }
            CategoryOptionCard("Supplies", "Books & print", Icons.Outlined.Subject, selectedCategory == "Supplies", Modifier.weight(1f)) { onSelect("Supplies") }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CategoryOptionCard("Parcel", "Package drop", Icons.Outlined.Inventory2, selectedCategory == "Parcel", Modifier.weight(1f)) { onSelect("Parcel") }
            CategoryOptionCard("Other", "Custom errand", Icons.Outlined.MoreHoriz, selectedCategory == "Other", Modifier.weight(1f)) { onSelect("Other") }
        }
    }
}

@Composable
private fun CategoryOptionCard(title: String, subtitle: String, icon: ImageVector, isSelected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    val bg = if (isSelected) BrandAmber else SurfaceWhite
    Box(
        modifier = modifier.clip(RoundedCornerShape(12.dp)).background(bg).clickable(onClick = onClick).padding(12.dp),
    ) {
        if (isSelected) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = InkBlack, modifier = Modifier.align(Alignment.TopEnd).size(18.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(36.dp).background(if (isSelected) SurfaceWhite else CreamBg, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = null, tint = InkBlack, modifier = Modifier.size(20.dp))
            }
            Spacer(Modifier.width(10.dp))
            Column {
                Text(title, style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = InkBlack))
                Text(subtitle, style = TextStyle(fontSize = 11.sp, color = MutedText))
            }
        }
    }
}

@Composable
private fun PaymentOptionCard(title: String, subtitle: String, icon: ImageVector, isSelected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    val bg = if (isSelected) BrandAmber else SurfaceWhite
    Box(
        modifier = modifier.clip(RoundedCornerShape(12.dp)).background(bg).clickable(onClick = onClick).padding(14.dp),
    ) {
        if (isSelected) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = InkBlack, modifier = Modifier.align(Alignment.TopEnd).size(18.dp))
        }
        Column {
            Box(modifier = Modifier.size(32.dp).background(if (isSelected) SurfaceWhite else CreamBg, RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                Icon(icon, contentDescription = null, tint = InkBlack, modifier = Modifier.size(18.dp))
            }
            Spacer(Modifier.height(12.dp))
            Text(title, style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold, color = InkBlack))
            Text(subtitle, style = TextStyle(fontSize = 11.sp, color = MutedText, lineHeight = 14.sp))
        }
    }
}