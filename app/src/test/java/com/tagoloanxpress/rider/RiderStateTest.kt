package com.tagoloanxpress.rider

import com.tagoloanxpress.rider.model.*
import org.junit.Assert.*
import org.junit.Test

class RiderStateTest {
    @Test fun pendingAndOfflineRidersCannotAccept() {
        val pending = RiderState(approval = Approval.PENDING)
        assertEquals(pending, pending.accept())
        val offline = RiderState(accepting = false)
        assertEquals(offline, offline.accept())
        val missingProfile = RiderState(profileReady = false)
        assertEquals(missingProfile, missingProfile.accept())
    }

    @Test fun deliveryStagesCannotBeSkipped() {
        val available = RiderState()
        assertEquals(available, available.arriveAtStore())
        assertEquals(available, available.startDelivery(19500))
        assertEquals(available, available.arriveAtCustomer())
        assertEquals(available, available.complete(100))
        val toStore = available.accept()
        assertTrue(toStore.busy)
        assertFalse(toStore.available)
        assertEquals(toStore, toStore.startDelivery(19500))
    }

    @Test fun receiptAndPositiveAmountAreRequired() {
        val buying = RiderState().accept().arriveAtStore()
        assertEquals(buying, buying.startDelivery(19500))
        val receipt = buying.copy(receipt = "file:///receipt.jpg")
        assertEquals(receipt, receipt.startDelivery(0))
        assertEquals(receipt, receipt.startDelivery(-1))
        assertEquals(receipt, receipt.startDelivery(100000000))
        assertEquals(DeliveryStage.DELIVERING, receipt.startDelivery(19500).stage)
    }

    @Test fun completionRequiresPhotoAndBothConfirmations() {
        val arrived = atCustomer()
        assertFalse(arrived.canComplete)
        assertEquals(arrived, arrived.complete(100))
        assertFalse(arrived.copy(handover = "photo").canComplete)
        assertFalse(arrived.copy(handover = "photo", receiptHandedOver = true).canComplete)
        assertTrue(arrived.copy(handover = "photo", receiptHandedOver = true, cashCollected = true).canComplete)
    }

    @Test fun completionRecordsFeeNotCashCollectionAndIsIdempotent() {
        val ready = atCustomer().copy(handover = "file:///proof.jpg", receiptHandedOver = true, cashCollected = true)
        val done = ready.complete(12345)
        assertEquals(DeliveryStage.COMPLETED, done.stage)
        assertFalse(done.busy)
        assertTrue(done.accepting)
        assertFalse(done.available)
        assertEquals(6000L, done.earnings)
        assertEquals(25500L, done.trips.single().total)
        assertEquals(19500L, done.trips.single().productCost)
        assertEquals("file:///proof.jpg", done.trips.single().handover)
        assertEquals(12345L, done.trips.single().completedAt)
        assertEquals(done, done.complete(99999))
        assertEquals(done, done.accept())
    }

    @Test fun confirmedCostCannotBeRestartedDuringDelivery() {
        val delivering = RiderState(stage = DeliveryStage.BUYING, receipt = "photo").startDelivery(19500)
        assertEquals(delivering, delivering.startDelivery(34000))
        assertEquals(19500L, delivering.confirmedCost)
    }

    @Test fun declinedRequestIsUnavailable() {
        val declined = RiderState(stage = DeliveryStage.DECLINED)
        assertFalse(declined.available)
        assertEquals(declined, declined.accept())
    }

    @Test fun moneyParsingRejectsRoundingAndInvalidValues() {
        assertEquals(19500L, parseRiderCentavos("195.00"))
        assertEquals(1L, parseRiderCentavos("0.01"))
        assertEquals(99999999L, parseRiderCentavos("999999.99"))
        listOf("", "0", "-1", "1.999", "NaN", "1e3", "1,000", "1000000", ".50").forEach { assertNull(it, parseRiderCentavos(it)) }
        assertEquals("₱255.00", riderMoney(25500))
    }

    private fun atCustomer(): RiderState = RiderState().accept().arriveAtStore().copy(receipt = "file:///receipt.jpg").startDelivery(19500).arriveAtCustomer()
}
