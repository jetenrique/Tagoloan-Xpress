# Tagoloan Express — customer and rider design refresh

Reviewed against Figma file EUvp0N9RXBWgczCV92ok3f on 2026-11-11.
Code baseline: jetenrique/Tagoloan-Xpress commit
65204066b7018747bed7ded6468ac9ead7e3394a ("final rider ui").

## What this handoff contains

- `native/`: Kotlin presentation code for the refreshed design system, shared
  login presentation, both login destinations, and customer Home. Also includes
  local Android PNG resources and four static font weights.
- `references/node_ID.tsx`: high fidelity reference code from the visible Figma
  screen. It is a visual specification, not Android code. Do not install React
  or Tailwind. The remainder of the Android screen layouts must be implemented
  by adapting these references to existing Kotlin screens and state.
- `references/node_ID.png`: the corresponding Figma target screenshot for each
  of 38 frames. Screenshots are reference-only, never application backgrounds.
- `SCREEN_MAP.json`: exact screen-to-source mapping and implementation notes.
- `ASSET_MAP.json`: 197 downloaded assets mapped to their node, source constant,
  original dimensions, local original, and local Android resource.
- `assets/`: original SVGs/PNGs downloaded from Figma; preserve these originals.
- `LICENSES/`: Plus Jakarta Sans Open Font License.
- `BASELINE_FILES.json`: SHA-256 hashes of original Kotlin/build files so you
  can identify newer local changes before merging presentation code.

This is an implementation handoff. Only the Kotlin files under `native/` are
supplied as Android source; the remaining screens still need to be adapted.
No Android build, emulator test, or rendered app comparison has passed here.
The configured Gradle 9.5.0 download fails with Network is unreachable in the
preparation environment. Do not claim the extracted handoff completes the app.

## Perform the update in the user's existing Android project

1. Read the project's AGENTS.md and inspect git status. Preserve newer local
   changes. Never reset, clean, force checkout, or overwrite unrelated work.
   Do not apply the previous rider update again; its behavior is already in
   the baseline. This handoff does not require a backend migration.
2. Read SCREEN_MAP.json and the reference code/screenshot for the screen being
   edited. Work through both customer and rider flows in one coordinated pass.
   Use the 38 current screen-level references, not old hidden Figma layouts or
   generic bottom-nav frames. Do not read all TSX files into context at once.
3. Copy the four `res/font/*.ttf` files and needed `drawable-nodpi/txf_*.png`
   files into `app/src/main/res`. Keep the font license with the project.
   All 197 original Figma assets are provided locally; downloading URLs is
   unnecessary. No temporary Figma URL may appear in runtime source.
4. Integrate TxRefresh.kt and TxRefreshLogin.kt. Merge the three supplied
   destination replacements after inspecting their existing signatures and
   newer local changes. Keep API compatibility and wire all existing callbacks.
   In MainActivity's setContent, wrap TagoloanApp() with TxRefreshTheme.
   Replace any nested TagoloanTheme/TagoloanXpressTheme that overrides it, or
   make those wrappers delegate to TxRefreshTheme. Retain unrelated activity
   setup. Avoid dynamic color or an unrequested dark palette.
5. Complete the other screen layouts from the per-screen references, reusing
   TxRefreshCard, Button, Field, Badge, Steps, MoneyRow and BottomBar where
   suitable. Extend the existing TxComponents.kt and rider/shared/RiderUi.kt
   to delegate to the refreshed primitives without duplicating state.
   Changing a palette alone is insufficient: reorder and restructure layouts
   to match each frame. Review every screen on SCREEN_MAP.json before stopping.
6. Preserve all state transitions, record persistence, photo import/camera
   behavior and customer callbacks. Only change state/navigation when needed
   to connect a visible control; never create new data silently to match a
   sample screenshot. New customer chat/notification UI can be device-local
   demos, labeled accordingly; do not impersonate real messages or approvals.
7. Build, run tests, exercise both complete flows and compare screenshots.
   Report unfinished screens, failures and unrun checks explicitly.

## Visual rules from the revised frames

- Background #FBF9F1; white surfaces; ink #18181F; muted #6B6B73;
  placeholder #A3A3AB; hairline border #ECE8DF; primary amber #FEBC20;
  pale amber #FFF7E0; amber text #6B4E00; success green #1E9E5A.
- Most cards: 16dp corners, 1dp neutral border, 16dp padding, no hard shadow.
  Customer Home hero: 20dp corners and 20dp padding.
- Buttons: 14dp corners, about 50dp tall, sentence case, semibold 15sp.
  Primary amber/ink; customer hero CTA ink/white; outlined buttons white
  with a 1dp neutral border. Do not retain thick black button outlines.
- Inputs: 12dp corners, white, 1dp border, roughly 48dp high for one line,
  15sp text; labels 13sp. Use the supplied compact field where possible;
  default Material OutlinedTextField has different height and padding.
- Plus Jakarta Sans, local static weights 400/500/600/700. Headings 20–24sp
  bold; sections 16sp semibold; supporting text 12–14sp. Remove old all-caps
  styling and widespread Black/ExtraBold weights from these redesigned views.
- Dashboard horizontal padding 16dp; login body 24dp. Respect screen-specific
  spacing in reference TSX. Use native Rows/Columns/Box, responsive widths,
  proper insets and scroll instead of copying absolute browser coordinates.
- Bottom navigation: use each screen's visible current nav. Customer Home
  has Home/Create/Active/History/Profile; rider has Home/Requests/Active/
  History/Profile. No destination may have a visually clickable dead tab.
- Keep one vertical scroller per bounded destination. Rider Active,
  Completion, History and Profile are plain content inside the dashboard's
  weight(1f).verticalScroll Column. Standalone details/receipt/auth own their
  scroll. Do not nest a vertical LazyColumn/verticalScroll inside a vertical
  scroller or use vertical weights/fillMaxHeight to simulate a viewport there.
- Figma includes fake status time/signal and system navigation gestures:
  let Android draw the real bars, and avoid rendering these twice. Account
  for this difference when comparing app screenshots to 390dp-wide frames.
- Assets have exact design slots; read ASSET_MAP and the reference callsite.
  Original SVGs were rendered at 4x into Android PNGs preserving proportions;
  use explicit dp width/height matching the callsite, not intrinsic 4x size.
  Never stretch photos or use emojis/material icons in place of supplied
  Figma assets. ContentScale.Crop is only for the photo slots that crop.

## State and behavior that MUST survive the visual update

RiderState and RiderStore already implement the delivery lifecycle and local
persistence. Reuse them; do not build a second independent state model.

- Accept only when approved, profile-ready, online and available. Acceptance
  enters TO_STORE, displays Busy, disables availability and removes the
  request from Home/Requests. It neither completes the trip nor adds earnings.
- Arrived at store enters BUYING; receipt screen preserves draft amount/photo
  on Back. Cancelled picker/camera keeps the old photo and never auto-reopens.
- Require a readable receipt image and a valid positive amount with at most
  two decimals; calculate in integer centavos. ₱195 + ₱60 = ₱255.
- Start delivery freezes confirmed cost and enters DELIVERING. View receipt
  is read-only after that. Never let a visual refresh change the billed cost.
- Arrived at customer enters AT_CUSTOMER. Completion requires readable
  receipt and handover photos, receipt handed over and cash collected checks.
  Record the trip exactly once. Add FEE (6000 centavos) to earnings, not COD
  or product reimbursement. Completed state restores availability.
- History, trip receipt, earnings, profile, confirmation and completion all
  read the same state. Keep saved photos and trips across restart/sign-out.
  Dismissing sign-out confirmation must not clear delivery state.
- Current Kotlin state exposes lifetime recorded fees, not a Today subtotal.
  If you display Today as in Figma, derive daily totals from completedAt using
  the device timezone; keep existing lifetime earnings intact. Do not show
  all-time totals under Today or change the stored state to fit the screenshot.
- Dynamic user name/photo/vehicle, trip counts and costs override Figma's
  example values. Do not seed 48 deliveries/₱2,880/328 completions/5-star
  reviews or extra trips as real records. Empty history needs an empty state.
- Figma example notification ₱65 is not a change to this request's ₱60 fee.
  Display notification examples as demos or derive their amounts from data.
- Trip sample says Maria Santos while current dispatch is Neil Dairo: bind
  actual customer data consistently. Do not copy the mismatch.
- GPS routes, ETA, signal state, approval, ledger sync, uploads and push/chat
  services are not live. Preserve local-demo truthfulness: a static map is
  Route preview, not real navigation; a trip is Saved on this device, not
  synced to a server. Preserve clearly labeled approval preview controls.
- Calls use ACTION_DIAL and SMS uses ACTION_SENDTO with smsto:; require user
  action in Android's dialer/composer. No background sending, CALL_PHONE,
  READ_SMS, SEND_SMS or broad storage permissions are needed.
- Lock-screen frames describe Android-owned notification presentation. Keep
  any in-app preview explicitly labeled as a preview. Do not replace the
  device lock screen or silently add push/GPS services for a visual task.

## Screen-specific layout changes

Customer Home: simple greeting/name/avatar header; amber What do you need?
hero with dark Create Pasugo CTA; Services heading and four compact service
cards; white active-request card with Waiting badge and Track delivery CTA;
five functional bottom tabs. The supplied native version retains the existing
customer demo request and public callbacks; bind real shared data if present.

Create request: category tiles are Food/Groceries/Essentials/Supplies/Parcel/
Other in a 3x2 grid; preserve existing selection semantics and enum mappings.
Item, quantity, notes, budget, payment choice remain controlled inputs. Show
COD/GCash options without pretending that a payment gateway is connected.
Use slim 4-step progress and separate pickup/drop-off cards with map previews.
Review separates Item, Route, Cost. Confirmation is a white 24dp dialog over
the current review; Review again only dismisses the dialog.

Waiting: centered bike illustration and search status in a white card; request
summary below; cancel button at the bottom. Rider found is a distinct state
with green check, rider details, Track and Call. Keep demo progress explicit.
Tracking: map preview, ETA/progress card, rider card with Chat/Call and SMS
fallback, cost card. Completion: payment total, breakdown, rating stars,
feedback chips/text, Submit & go home, and help action wired to a clear route.

Rider Home: greeting/avatar header; white availability card FIRST; three
white stats SECOND; Available requests with count chip; one white request
card with food icon, neutral Food badge, cream route inset, delivery fee and
amber View request button. Remove old identity strip and large tip block from
the main Home layout. Preserve notification access in a sensible profile/
demo-menu route if the old Alerts header is removed. Avatar opens Profile.

Request details: white customer card, separate Item/Route cards, amber fee
card, Accept and outlined Decline. Acceptance dialog is 24dp white, centered
icon, request summary, Busy explanation and two working actions.
Active rider: local map preview, dark turn instruction preview, 3-step strip,
customer card with Chat/Call, cost card and Arrived at store CTA. Keep a
separate Arrived at customer CTA while delivering; do not complete the trip
just because a static screen depicts arrival.
Receipt: At the store header, step strip, item card, compact amount field,
savings text, receipt attachment card, white collect-from-customer breakdown,
Start delivery. Keep replace/upload/camera available when no image exists;
attached preview is driven by actual selected media, never the sample image.
Completion: Arrived header, progress strip, amber amount, real handover photo
card, two confirmation checks in white, Complete Pasugo. Both checks remain
interactive and are not prechecked to match the sample screenshot.

History: amber earnings summary and period chips; white trip cards with
cream route insets, actual item cost and earned fee, View trip receipt. Apply
period filters to timestamps without deleting records. Trip log shows real
amounts, attachments and Close. Customer history has All/Completed/Cancelled
filters and View receipt buttons; keep sample and real records distinguished.

Profiles: centered avatar/name/contact/status card, simple grouped menu rows,
outlined red Log out. Rider has 3 stats and vehicle/history/security rows.
Preserve profile-photo and vehicle editing paths. Use existing dynamic state,
not Figma's sample completion counts or approval badges on pending accounts.

Chat: white header and order strip, cream body, amber outgoing and white
incoming bubbles, timestamps, quick replies/updates, a pale SMS fallback row,
and bottom composer. Sending changes local demo messages only. SMS screenshot
is a reference for the native messaging app; launching its composer is the
working fallback. Any simulated SMS conversation remains explicitly a demo.

## Verification on the user's Mac

Run:
  bash gradlew :app:assembleDebug :app:testDebugUnitTest
If an emulator is connected:
  bash gradlew :app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.tagoloanxpress.rider.RiderFlowTest

Existing UI tests may match old labels. Preserve their behavioral assertions
and update obsolete text matchers or add stable testTags. Never delete tests
to make a redesign pass. Inspect Logcat after acceptance and scrolling.

Manually exercise customer portal -> login/register -> Home -> create Steps
1–4 -> confirmation -> waiting/found -> tracking -> rating/receipt -> history
and profile. Verify cancellation and all footer actions.

Exercise rider login/application/status/setup -> online/offline Home ->
request -> confirmation -> Active -> arrived at store -> receipt with 195.00
and a real image -> delivering total 255.00 -> arrived at customer -> handover
and both checks -> complete once -> History/trip -> Profile. Cancel pickers,
reopen read-only receipt, restart app and cancel sign-out to check persistence.

Compare every in-scope screen with its PNG at a matching content width,
accounting for actual Android system bars. Check icons, proportions, font,
spacing, keyboard visibility, small screens and scrolling, not just colors.
Provide a final per-screen completion list plus build/unit/emulator/visual
results separately. No runtime success claim without running the flow.
