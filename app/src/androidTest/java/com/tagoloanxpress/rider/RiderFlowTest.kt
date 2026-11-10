package com.tagoloanxpress.rider

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.tagoloanxpress.rider.model.*
import com.tagoloanxpress.rider.ui.dashboard.RiderDashboardScreen
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RiderFlowTest {
    @get:Rule val compose = createComposeRule()

    private fun store(initial: RiderState = RiderState()): RiderStore {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        return RiderStore(context, "rider_ui_instrumentation_test").also { store -> store.update { initial } }
    }

    @Test fun acceptingRequestOpensActiveWithoutNestedScrollCrash() {
        val store = store()
        compose.setContent { MaterialTheme { RiderDashboardScreen(store) {} } }
        compose.onNodeWithText("VIEW REQUEST DETAILS").performScrollTo().performClick()
        compose.onNodeWithText("ACCEPT PASUGO REQUEST").performScrollTo().performClick()
        compose.onNodeWithText("YES, ACCEPT REQUEST").performClick()
        compose.onNodeWithText("Active Pasugo #TGX-8921").assertExists()
        compose.onNodeWithText("MARK AS ARRIVED AT STORE").performScrollTo().performClick()
        compose.onNodeWithText("CONTINUE TO RECEIPT").assertExists()
        compose.runOnIdle { assertEquals(DeliveryStage.BUYING, store.state.stage) }
    }

    @Test fun cancellingLogoutPreservesActiveDelivery() {
        val store = store(RiderState(stage = DeliveryStage.TO_STORE))
        compose.setContent { MaterialTheme { RiderDashboardScreen(store) {} } }
        compose.onNodeWithContentDescription("Open rider profile").performClick()
        compose.onNodeWithText("LOG OUT OF RIDER ACCOUNT").performScrollTo().performClick()
        compose.onNodeWithText("Cancel").performClick()
        compose.runOnIdle { assertEquals(DeliveryStage.TO_STORE, store.state.stage) }
    }
}
