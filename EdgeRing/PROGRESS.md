# PROGRESS

## Status
- Zip number / milestone: 1 - M00 (project foundation and CI)
- Date/time of this checkpoint: 2026-10-08
- Build status: NOT RUN (sandbox cannot reach Gradle or Google Maven; command to run: `./gradlew assembleDebug lint test`)
- Tests: 0/0 (M00 has no logic to test), lint: not run
- Known issues: none known; nothing has been compiled yet, so expect possible first-CI fixes
- CI status: NOT RUN
- Verified here: all XML files pass `xmllint`; Gradle wrapper jar and scripts fetched from the official gradle/gradle repo (tag v8.10.2)
- Verified by CI: nothing yet
- Not verified: Gradle sync, Kotlin/Compose compile, AGP/Kotlin/BOM version compatibility, lint, APK install
- Unverified assumptions: AGP 8.7.3 + Gradle 8.10.2 + Kotlin 2.0.21 + Compose BOM 2024.10.01 work together; ubuntu-latest runner has Android platform 35 (or can auto-download it); `kotlin { compilerOptions { jvmTarget } }` accepted by this plugin set

## Done (checked off, with file paths)
- [x] Gradle project, wrapper, version catalog - `settings.gradle.kts`, `build.gradle.kts`, `gradle/`
- [x] Flavours play/sideload, R8 rules (no signing config on purpose) - `app/build.gradle.kts`, `app/proguard-rules.pro`
- [x] Empty settings shell + theme + icon - `app/src/main/java/com/example/edgering/`, `app/src/main/res/`
- [x] CI workflow - `.github/workflows/build.yml`
(all written, none compiled: see Status)

## In progress / partially done
- [ ] M00 exit criterion "builds in CI" - needs the person to push this zip to GitHub, run the workflow, paste any error log

## Next steps (ordered, each small enough for one session)
1. Fix any CI failures from M00 (first thing next session).
2. M01 overlay + trigger spike (foreground service, TYPE_APPLICATION_OVERLAY edge window, touch tracking, ring, hit-test unit tests, panic/remove-overlay path, overlay permission screen).
3. M02 data layer (Room, DataStore, backup JSON model).

## Decisions and conventions
- App name EdgeRing; package `com.example.edgering` (placeholder, change before release; sideload flavour adds `.sideload`)
- minSdk 26, targetSdk/compileSdk 35, JDK 17, Kotlin 2.0.21, AGP 8.7.3, Gradle 8.10.2, Compose BOM 2024.10.01
- UI: Jetpack Compose + Material3 (dynamic colour on Android 12+); window theme via framework Material theme (no AppCompat)
- Architecture to come: Room (M02), DataStore (M02), coroutines/Flow; no AsyncTask/Handler timers
- Clean-room: never copy code, strings, layouts, icons or DB format from the reference app; no paywall bypass
- Releases are unsigned in-repo; keystores never committed
- `allWarningsAsErrors` left off until CI shows the real warning list

## Feature checklist (mirrors section 2 of the prompt)
- [ ] 2.1 Triggers  - [ ] 2.2 Overlay/gesture  - [ ] 2.3 Zones  - [ ] 2.4 Shortcuts grid  - [ ] 2.5 Folders
- [ ] 2.6 Action shortcuts  - [ ] 2.7 Other launch types  - [ ] 2.8 Apps index A-Z  - [ ] 2.9 Small-hand mode
- [ ] 2.10 Appearance/theming  - [ ] 2.11 Behaviour/background  - [ ] 2.12 Onboarding/permissions
- [ ] 2.13 Backup/restore  - [ ] 2.14 Monetisation  - [ ] 2.15 i18n/misc  - [ ] 2.16 File-system folders
(all: not started)

## Open questions / UNKNOWN items still to verify
- Section 8 of the prompt (folder hover/nesting, hotspot and lock-orientation actions, icon-pack format, free-tier limits, haptic patterns, etc.) - none touched yet
- Final package id and branding (placeholder in use)
- Monetisation model and free-tier limits (decide before M14)

## How to build and test
- `./gradlew assembleDebug lint test` (JDK 17, Android SDK platform 35)
- Install: `./gradlew installPlayDebug` or `installSideloadDebug` with a device/emulator attached
- CI: push to GitHub; workflow `build` uploads `apks` and `reports` artifacts
