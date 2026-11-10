package com.tagoloanxpress.rider.model

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.json.JSONArray
import org.json.JSONObject

class RiderStore(context: Context, preferencesName: String = "rider_ui_demo_v1") {
    private val prefs = context.applicationContext.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    var state by mutableStateOf(read())
        private set

    fun update(transform: (RiderState) -> RiderState) {
        val next = transform(state)
        if (next == state) return
        state = next
        val s = JSONObject().apply {
            put("name", next.name); put("mobile", next.mobile); put("username", next.username)
            put("plate", next.plate); put("vehicle", next.vehicle); put("photo", next.photo)
            put("documents", JSONArray(next.documents)); put("approval", next.approval.name)
            put("profileReady", next.profileReady); put("accepting", next.accepting)
            put("stage", next.stage.name); put("draftCost", next.draftCost); put("receipt", next.receipt)
            put("confirmedCost", next.confirmedCost); put("handover", next.handover)
            put("receiptHandedOver", next.receiptHandedOver); put("cashCollected", next.cashCollected)
            put("messages", JSONArray(next.messages)); put("notificationsRead", next.notificationsRead)
            put("trips", JSONArray().apply { next.trips.forEach { t -> put(JSONObject().apply {
                put("id", t.id); put("productCost", t.productCost); put("fee", t.fee)
                put("receipt", t.receipt); put("handover", t.handover); put("completedAt", t.completedAt)
            }) } })
        }
        prefs.edit().putString("state", s.toString()).apply()
    }

    private fun read(): RiderState {
        val raw = prefs.getString("state", null) ?: return RiderState()
        return try {
            val j = JSONObject(raw)
            fun strings(key: String): List<String> = j.optJSONArray(key)?.let { a -> (0 until a.length()).map { a.getString(it) } } ?: emptyList()
            RiderState(
                name = j.getString("name"), mobile = j.getString("mobile"), username = j.getString("username"),
                plate = j.getString("plate"), vehicle = j.getString("vehicle"), photo = j.optString("photo"),
                documents = strings("documents").let { if (it.size == 3) it else listOf("", "", "") },
                approval = Approval.valueOf(j.getString("approval")), profileReady = j.getBoolean("profileReady"),
                accepting = j.getBoolean("accepting"), stage = DeliveryStage.valueOf(j.getString("stage")),
                draftCost = j.optString("draftCost"), receipt = j.optString("receipt"), confirmedCost = j.optLong("confirmedCost"),
                handover = j.optString("handover"), receiptHandedOver = j.optBoolean("receiptHandedOver"),
                cashCollected = j.optBoolean("cashCollected"), messages = strings("messages"), notificationsRead = j.optBoolean("notificationsRead"),
                trips = j.optJSONArray("trips")?.let { a -> (0 until a.length()).map { i -> a.getJSONObject(i).let { t ->
                    CompletedTrip(t.getString("id"), t.getLong("productCost"), t.getLong("fee"), t.getString("receipt"), t.getString("handover"), t.getLong("completedAt"))
                } } } ?: emptyList(),
            )
        } catch (_: Exception) { RiderState() }
    }
}
