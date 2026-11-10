package com.tagoloanxpress.rider.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.tagoloanxpress.R
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.shared.*

@Composable
fun RiderApplicationScreen(store: RiderStore, onSubmitted: () -> Unit, onBack: () -> Unit) {
    var name by rememberSaveable { mutableStateOf("") }
    var mobile by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visible by rememberSaveable { mutableStateOf(false) }
    var doc0 by rememberSaveable { mutableStateOf("") }
    var doc1 by rememberSaveable { mutableStateOf("") }
    var doc2 by rememberSaveable { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val documents = listOf(doc0, doc1, doc2)
    RiderPage("Rider Application", onBack) {
        TxCaption("TAGOLOAN XPRESS Partner • STEP 1 OF 1")
        TxPanel {
            TxTitle("Create Rider Account")
            TxText("Fill in your personal credentials")
            OutlinedTextField(name, { name = it.take(80) }, Modifier.fillMaxWidth(), label = { Text("Full Name") }, singleLine = true)
            OutlinedTextField(mobile, { mobile = it.take(20) }, Modifier.fillMaxWidth(), label = { Text("Mobile Number • PH (+63)") }, singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))
            OutlinedTextField(username, { username = it.take(100) }, Modifier.fillMaxWidth(), label = { Text("Email / Username") }, singleLine = true)
            OutlinedTextField(password, { password = it.take(128) }, Modifier.fillMaxWidth(), label = { Text("Password") }, singleLine = true, visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), trailingIcon = {
                IconButton(onClick = { visible = !visible }) { Icon(androidx.compose.ui.res.painterResource(R.drawable.rider_eye), if (visible) "Hide password" else "Show password") }
            })
        }
        TxRow("REQUIRED DOCUMENTS", "${documents.count { it.isBlank() }} Pending")
        listOf("OR / CR Document", "Driver's License", "Other Requirements / Clearance").forEachIndexed { index, title ->
            TxPanel { PhotoSelector(title, documents[index], { uri -> when (index) { 0 -> doc0 = uri; 1 -> doc1 = uri; else -> doc2 = uri } }, camera = false) }
        }
        TxPanel(TxCream) { TxText("Registration does not automatically activate your rider account. Admin approval is required. This UI demo stores document photos locally and does not create a real account or save your password.") }
        if (error.isNotBlank()) Text(error, color = MaterialTheme.colorScheme.error)
        TxButton("SUBMIT APPLICATION") {
            val phone = mobile.replace(" ", "").replace("-", "")
            error = when {
                name.trim().length < 2 -> "Enter your full name."
                !Regex("""(09\d{9}|\+639\d{9})""").matches(phone) -> "Enter a valid Philippine mobile number."
                username.trim().length < 3 -> "Enter an email or username with at least 3 characters."
                password.length < 8 -> "Use at least 8 characters for the demo password."
                documents.any { it.isBlank() } -> "Select all three document photos."
                store.state.busy -> "Finish the active delivery before starting a new application."
                else -> ""
            }
            if (error.isEmpty()) {
                store.update { RiderState(name = name.trim(), mobile = phone, username = username.trim(), documents = documents, approval = Approval.PENDING, profileReady = false, accepting = false) }
                password = ""
                onSubmitted()
            }
        }
        TxButton("ALREADY A RIDER? SIGN IN", white = true, onClick = onBack)
    }
}

@Composable
fun RiderVerificationScreen(store: RiderStore, onApproved: () -> Unit, onLogout: () -> Unit) {
    var checked by rememberSaveable { mutableStateOf(false) }
    RiderPage("Application Status", onLogout) {
        TxPanel(TxCream) {
            TxAsset(R.drawable.fg_3_1701_imgsvg1)
            TxTitle("PENDING VERIFICATION")
            TxTitle("Application Under Review")
            TxText("You cannot view or accept Pasugo requests until full Admin approval is complete.")
            TxCaption("Design estimate: 24–48 hours. This demo has no live review service.")
        }
        TxPanel {
            TxTitle("APPROVAL PROGRESS")
            TxRow("✓ Account Registration", "Completed locally")
            TxRow("✓ Documents Submitted", "3 selected")
            TxPanel(TxAmber) { TxText("Admin Verification • PENDING"); TxCaption("OR/CR & Driver's License validation") }
            TxCaption("○ Interview & Orientation")
            TxCaption("○ Final Briefing & Admin Approval")
            TxRow("Applicant", store.state.name)
            TxCaption("Demo ID: TX-RDR-8924")
        }
        TxButton("CHECK STATUS AGAIN") { checked = true }
        if (checked) TxCaption("Still pending. A backend is needed to retrieve real approval updates.")
        TxButton("PREVIEW ADMIN APPROVAL (DEMO)", white = true) {
            store.update { it.copy(approval = Approval.APPROVED) }; onApproved()
        }
        TxCaption("The preview button only advances this local prototype; it is not admin verification.")
        TxButton("LOG OUT", white = true, onClick = onLogout)
    }
}

@Composable
fun RiderApprovedScreen(store: RiderStore, onLogin: () -> Unit) {
    RiderPage("Application Approved", onLogin) {
        TxAsset(R.drawable.fg_3_1809_imgsvg1, width = 48f)
        TxTitle("You Are Approved!")
        TxText("Approval preview for ${store.state.name}. No server approval was performed.")
        TxPanel(androidx.compose.ui.graphics.Color(0xFFE8F5E9)) {
            TxTitle("ACTIVE & ELIGIBLE")
            TxText("✓ Eligible to accept nearby Pasugo requests in Tagoloan")
            TxText("✓ Customer routing and earnings screens")
            TxText("✓ TAGOLOAN XPRESS Partner Rider profile")
        }
        TxPanel { TxRow("RIDER ACCOUNT", store.state.name); TxRow("RIDER ID", "TX-RDR-8924") }
        TxButton("PROCEED TO RIDER LOGIN", onClick = onLogin)
    }
}

@Composable
fun RiderProfileSetupScreen(store: RiderStore, onSaved: () -> Unit, onBack: () -> Unit) {
    var photo by rememberSaveable { mutableStateOf(store.state.photo) }
    val validPhoto = rememberImagePreview(photo).bitmap != null
    RiderPage("Setup Profile", onBack) {
        TxTitle("Add Profile Picture")
        TxText("Customers will use this photo to identify you upon pickup and delivery.")
        TxPanel { PhotoSelector("Rider photo", photo, { photo = it }) }
        TxPanel {
            TxTitle("PHOTO REQUIREMENTS")
            TxText("✓ Clear face view, without masks, tinted sunglasses, or heavy filters")
            TxText("✓ Well-lit environment with a neutral or plain background")
            TxText("✓ Professional appearance, wearing a shirt or delivery attire")
        }
        TxCaption("Your photo will be displayed on the customer's tracking card once connected to the backend.")
        TxButton("SAVE & CONTINUE TO DASHBOARD", enabled = validPhoto && store.state.approval == Approval.APPROVED) {
            store.update { it.copy(photo = photo, profileReady = true, accepting = true) }; onSaved()
        }
    }
}
