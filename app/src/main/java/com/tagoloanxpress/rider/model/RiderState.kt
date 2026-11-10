package com.tagoloanxpress.rider.model

import java.math.BigDecimal
import java.util.Locale

enum class DeliveryStage { AVAILABLE, DECLINED, TO_STORE, BUYING, DELIVERING, AT_CUSTOMER, COMPLETED }
enum class Approval { APPROVED, PENDING }

data class CompletedTrip(
    val id: String,
    val productCost: Long,
    val fee: Long,
    val receipt: String,
    val handover: String,
    val completedAt: Long,
) { val total: Long get() = productCost + fee }

/** Device-local UI demo. No authentication, payment transfer, or server approval. */
data class RiderState(
    val name: String = "Juan Dela Cruz",
    val mobile: String = "0917 123 4567",
    val username: String = "juan.demo",
    val plate: String = "ABC 1234",
    val vehicle: String = "Motorcycle",
    val photo: String = "",
    val documents: List<String> = listOf("", "", ""),
    val approval: Approval = Approval.APPROVED,
    val profileReady: Boolean = true,
    val accepting: Boolean = true,
    val stage: DeliveryStage = DeliveryStage.AVAILABLE,
    val draftCost: String = "",
    val receipt: String = "",
    val confirmedCost: Long = 0,
    val handover: String = "",
    val receiptHandedOver: Boolean = false,
    val cashCollected: Boolean = false,
    val trips: List<CompletedTrip> = emptyList(),
    val messages: List<String> = emptyList(),
    val notificationsRead: Boolean = false,
) {
    val busy: Boolean get() = stage in setOf(DeliveryStage.TO_STORE, DeliveryStage.BUYING, DeliveryStage.DELIVERING, DeliveryStage.AT_CUSTOMER)
    val available: Boolean get() = approval == Approval.APPROVED && profileReady && accepting && stage == DeliveryStage.AVAILABLE
    val total: Long get() = confirmedCost + FEE
    val earnings: Long get() = trips.sumOf { it.fee }
    val canComplete: Boolean get() = stage == DeliveryStage.AT_CUSTOMER && confirmedCost > 0 && receipt.isNotBlank() && handover.isNotBlank() && receiptHandedOver && cashCollected

    fun accept(): RiderState = if (available) copy(stage = DeliveryStage.TO_STORE) else this
    fun arriveAtStore(): RiderState = if (stage == DeliveryStage.TO_STORE) copy(stage = DeliveryStage.BUYING) else this
    fun startDelivery(cost: Long): RiderState = if (stage == DeliveryStage.BUYING && cost in 1..99999999L && receipt.isNotBlank()) copy(confirmedCost = cost, stage = DeliveryStage.DELIVERING) else this
    fun arriveAtCustomer(): RiderState = if (stage == DeliveryStage.DELIVERING) copy(stage = DeliveryStage.AT_CUSTOMER) else this
    fun complete(now: Long): RiderState {
        if (!canComplete || trips.any { it.id == REQUEST_ID }) return this
        return copy(
            stage = DeliveryStage.COMPLETED, accepting = true,
            trips = listOf(CompletedTrip(REQUEST_ID, confirmedCost, FEE, receipt, handover, now)) + trips,
        )
    }
    companion object {
        const val FEE = 6000L
        const val REQUEST_ID = "TGX-8921"
    }
}

fun parseRiderCentavos(input: String): Long? {
    val value = input.trim()
    if (!Regex("""\d{1,6}(\.\d{1,2})?""").matches(value)) return null
    return try { BigDecimal(value).movePointRight(2).longValueExact().takeIf { it in 1..99999999L } }
    catch (_: ArithmeticException) { null } catch (_: NumberFormatException) { null }
}

fun riderMoney(cents: Long): String = "₱" + String.format(Locale.US, "%,d.%02d", cents / 100, cents % 100)
