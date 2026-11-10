package com.tagoloanxpress.rider.ui.shared

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import com.tagoloanxpress.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.IOException
import java.util.UUID

val TxInk = Color(0xFF18181F)
val TxAmber = Color(0xFFFEBC20)
val TxCream = Color(0xFFFFFDF5)
val TxGreen = Color(0xFF2E7D32)

/** Standalone screen: bounded viewport with exactly one vertical scroller. */
@Composable
fun RiderPage(title: String, onBack: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    BackHandler(onBack = onBack)
    Column(Modifier.fillMaxSize().background(TxCream).safeDrawingPadding().imePadding()) {
        Row(Modifier.fillMaxWidth().heightIn(min = 60.dp).padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { TxAsset(R.drawable.rider_back, "Back") }
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = TxInk, modifier = Modifier.weight(1f))
        }
        HorizontalDivider(color = TxInk, thickness = 2.dp)
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp), content = content)
    }
}

@Composable fun TxPanel(color: Color = Color.White, content: @Composable ColumnScope.() -> Unit) {
    Column(Modifier.fillMaxWidth().background(color, RoundedCornerShape(16.dp)).border(2.dp, TxInk, RoundedCornerShape(16.dp)).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp), content = content)
}

@Composable fun TxTitle(text: String) { Text(text, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, color = TxInk) }
@Composable fun TxText(text: String) { Text(text, fontSize = 13.sp, lineHeight = 19.sp, color = TxInk) }
@Composable fun TxCaption(text: String) { Text(text, fontSize = 11.sp, color = Color(0xFF555555)) }
@Composable fun TxButton(text: String, enabled: Boolean = true, white: Boolean = false, onClick: () -> Unit) {
    Button(onClick = onClick, enabled = enabled, modifier = Modifier.fillMaxWidth().heightIn(min = 50.dp).border(2.dp, if (enabled) TxInk else Color.Gray, RoundedCornerShape(14.dp)), shape = RoundedCornerShape(14.dp), colors = ButtonDefaults.buttonColors(containerColor = if (white) Color.White else TxAmber, contentColor = TxInk)) {
        Text(text, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
    }
}
@Composable fun TxRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(label, Modifier.weight(1f), fontSize = 12.sp, color = TxInk)
        Text(value, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = TxInk)
    }
}
@Composable fun TxAsset(@DrawableRes id: Int, description: String? = null, width: Float = 20f, height: Float = width) {
    Image(painterResource(id), description, Modifier.size(width.dp, height.dp))
}

data class ImagePreview(val loading: Boolean = false, val bitmap: Bitmap? = null, val source: String = "")

@Composable fun rememberImagePreview(uri: String): ImagePreview {
    val context = LocalContext.current
    return produceState(ImagePreview(loading = uri.isNotEmpty(), source = uri), uri) {
        value = ImagePreview(loading = uri.isNotEmpty(), source = uri)
        value = ImagePreview(source = uri, bitmap = if (uri.isEmpty()) null else withContext(Dispatchers.IO) { decodeImage(context, uri) })
    }.value.let { if (it.source == uri) it else ImagePreview(loading = uri.isNotEmpty(), source = uri) }
}

@Composable fun LocalPhoto(uri: String, height: Int = 180) {
    val preview = rememberImagePreview(uri)
    val bitmap = preview.bitmap
    if (bitmap != null) Image(bitmap.asImageBitmap(), "Selected photo", Modifier.fillMaxWidth().height(height.dp), contentScale = ContentScale.Fit)
    else TxCaption(if (preview.loading) "Loading photo…" else if (uri.isBlank()) "No photo selected" else "Photo unavailable. Select it again.")
}

/** User-driven picker/camera only. Cancellation never relaunches the picker. */
@Composable
fun PhotoSelector(label: String, uri: String, onSelected: (String) -> Unit, camera: Boolean = true) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var pendingCameraUri by rememberSaveable { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var importing by remember { mutableStateOf(false) }
    val onImage: (Uri) -> Unit = { source ->
        importing = true
        scope.launch {
            val copied = withContext(Dispatchers.IO) { importImage(context, source) }
            importing = false
            if (copied != null) { error = null; onSelected(copied) }
            else error = "Choose a readable image smaller than 15 MB."
        }
    }
    val picker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { selected -> if (selected != null) onImage(selected) }
    val capture = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        val captured = pendingCameraUri
        pendingCameraUri = ""
        if (success && captured.isNotEmpty()) onImage(Uri.parse(captured))
    }
    TxTitle(label)
    LocalPhoto(uri)
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(enabled = !importing, onClick = { picker.launch(arrayOf("image/*")) }, modifier = Modifier.weight(1f)) { Text(if (uri.isEmpty()) "Upload File" else "Replace Photo") }
        if (camera) Button(enabled = !importing, onClick = {
            try {
                val folder = File(context.filesDir, "rider_media").apply { mkdirs() }
                val file = File.createTempFile("capture_", ".jpg", folder)
                val target = FileProvider.getUriForFile(context, "${context.packageName}.rider.files", file)
                pendingCameraUri = target.toString()
                capture.launch(target)
            } catch (_: Exception) { pendingCameraUri = ""; error = "No camera app is available. Use Upload File instead." }
        }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = TxAmber, contentColor = TxInk)) { Text("Camera") }
    }
    if (importing) LinearProgressIndicator(Modifier.fillMaxWidth())
    error?.let { Text(it, color = MaterialTheme.colorScheme.error, fontSize = 12.sp) }
}

fun decodeImage(context: Context, value: String): Bitmap? = try {
    val uri = Uri.parse(value)
    val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    context.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it, null, bounds) }
    if (bounds.outWidth <= 0 || bounds.outHeight <= 0) null else {
        var sample = 1
        while (bounds.outWidth / sample > 1200 || bounds.outHeight / sample > 1200) sample *= 2
        context.contentResolver.openInputStream(uri)?.use { BitmapFactory.decodeStream(it, null, BitmapFactory.Options().apply { inSampleSize = sample }) }
    }
} catch (_: IOException) { null } catch (_: SecurityException) { null } catch (_: IllegalArgumentException) { null }

private fun importImage(context: Context, source: Uri): String? {
    val folder = File(context.filesDir, "rider_media").apply { mkdirs() }
    val target = File(folder, "${UUID.randomUUID()}.image")
    return try {
        context.contentResolver.openInputStream(source)?.use { input ->
            target.outputStream().use { output ->
                val buffer = ByteArray(8192)
                var count = 0L
                while (true) {
                    val read = input.read(buffer)
                    if (read == -1) break
                    count += read
                    if (count > 15 * 1024 * 1024) throw IOException("Image too large")
                    output.write(buffer, 0, read)
                }
            }
        } ?: throw IOException("No readable stream")
        val uri = Uri.fromFile(target).toString()
        if (decodeImage(context, uri) == null) throw IOException("Invalid image")
        uri
    } catch (_: IOException) { target.delete(); null } catch (_: SecurityException) { target.delete(); null }
}
