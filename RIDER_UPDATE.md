# Tagoloan Xpress rider UI update

Prepared against GitHub commit `b8de1bd` on 10 November 2026. This is a local rider prototype, not a backend implementation. Existing customer screens and Gradle versions are preserved.

## Included flows

- Login → dashboard; registration → pending review → explicit demo approval → login → profile photo setup.
- Available request → details → acceptance → store arrival → receipt and actual cost → delivery → customer arrival → handover proof and confirmations → completion.
- History filters, trip receipts, receipt/handover image previews, profile photo, vehicle and document editing.
- Local chat, quick rider updates, notification previews, and user-controlled native SMS composer/dialer.
- One state model for delivery status, confirmed costs, completed trips and earnings. Records survive app restarts and sign-out.

## Applying the download with Copilot

Extract `Tagoloan-Rider-Update.zip` into a temporary folder. Copy that extracted folder into your Android Studio project, then paste:

```text
Read Tagoloan-Rider-Update/APPLY_WITH_COPILOT.md and apply the supplied
rider-ui-update.patch to this project. The implementation is already written;
do not regenerate the screens. Check that the patch applies before changing
files. Preserve any newer local work and stop to report conflicts if needed.
Then run :app:assembleDebug and :app:testDebugUnitTest. With the emulator
connected, run the two RiderFlowTest instrumentation tests. Report actual
results separately for compilation, unit tests, and emulator tests.
```

Do not replace the entire `app` folder with a partial folder. The patch contains all source, resource, manifest, and test changes.

## Verification on your Mac

From the project root:

```sh
bash gradlew :app:assembleDebug :app:testDebugUnitTest
bash gradlew :app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.tagoloanxpress.rider.RiderFlowTest
```

The instrumentation tests use a separate preferences file and do not reset your normal demo records.

Manual checks:

1. Enter any nonempty rider login. No actual credentials are verified.
2. Accept the sample request. Verify BUSY status and removal from Available Requests.
3. Mark store arrival. Enter `195.00`, select/capture a receipt image, and check `₱255.00` total.
4. Cancel a photo picker and verify the previous selection remains. Back/reopen must retain the draft.
5. Start delivery. Receipt viewing must now be read-only; the confirmed product cost must not change.
6. Mark customer arrival. Completion must remain disabled until a readable handover photo and both receipt/payment confirmations are present.
7. Complete once. History must contain one trip with `₱195.00` product cost, `₱60.00` earnings, and `₱255.00` cash collected. No duplicate fee should be added.
8. Restart the app, log in again and verify that history remains. Cancel a sign-out dialog during a delivery and verify no draft is cleared.
9. Check Today/This Week filters, trip photos, profile/vehicle edits, notification actions, local chat and keyboard scrolling.
10. Test registration separately: all three document photos and valid fields are required. Pending applicants cannot access requests. Only the labeled demo approval control advances the preview.

The app supports one local demo rider profile. Submitting a new application replaces that local demo profile. Finish testing the delivery/history flow before testing registration.

## Design and runtime limits

Screens follow the supplied Figma references. History/trip-log Figma frames are flattened reference images, so their content is rebuilt as native interactive UI. Android device sizes and fonts still require visual comparison on the emulator; pixel-perfect fidelity is not asserted.

The map remains a route placeholder. No live GPS, authentication, password changes, admin approvals, document uploads, payment transfers, FCM delivery, encrypted messaging, or automatic connection failover is implemented. Chat messages are saved locally. SMS/call controls open another app and require a recipient number chosen by you; they do not send or place calls automatically.

Real admin approval must replace the demo approval control before production. Photo attachments are app-private local copies. Clear app data/uninstall removes these local records.

## Verification performed here

- Eight executable JUnit delivery-state tests passed: stage ordering, approval/offline restrictions, valid receipt amounts, required completion evidence, idempotent completion and fee-only earnings.
- Kotlin/Compose source compilation was checked separately against downloaded Android/Compose libraries. This is supplemental verification, not an Android APK build.
- Drawable references, new image files and XML were checked for missing/invalid resources.
- The standard Gradle Android build is blocked in this environment by Gradle/toolchain/plugin dependency resolution. No APK or emulator-runtime success is claimed. Two Compose instrumentation regression tests are supplied for the previously observed nested-scroll crash and cancelled sign-out behavior; they still need to run on your emulator.
