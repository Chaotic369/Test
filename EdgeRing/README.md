# EdgeRing

An original gesture-driven edge launcher for Android: touch a thin edge strip, keep the finger down,
drag across a ring overlay to a shortcut, release to launch. Built clean-room in Kotlin; no code,
assets, names or icons are taken from any other launcher.

- Package id: `com.example.edgering` (placeholder: change before any public release)
- Min SDK 26, target/compile SDK 35, Kotlin + Jetpack Compose
- Flavours: `play` (Play-safe, SAF only) and `sideload` (may declare broader permissions)

## Build and test
```
./gradlew assembleDebug lint test
```
Requires JDK 17 and the Android SDK (platform 35). CI does this on every push
(`.github/workflows/build.yml`) and uploads APKs and reports as artifacts.

## Status
See `PROGRESS.md` (current milestone, checklist, next steps) and `CHANGELOG.md`.
