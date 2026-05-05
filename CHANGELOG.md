# Changelog

All notable changes to **NewsFlow** are documented here.

This project follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)
and [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

Format: `## [version] — YYYY-MM-DD`
Types : `Added` | `Changed` | `Fixed` | `Removed` | `Security`

---

## [0.1.0] — Day 1 — Project Scaffold

### Added
- Initial Android project created with Android Studio
- `app/build.gradle` configured with all required dependencies:
  - Jetpack Compose BOM 2024.02.00
  - Retrofit 2.9.0 + OkHttp 4.12.0
  - Kotlin Coroutines 1.7.3
  - Google Generative AI (Gemini) 0.2.2
  - Room 2.6.1
  - Coil 2.5.0 (image loading)
  - Navigation Compose 2.7.7
- Root `build.gradle` with AGP 8.2.2 and Kotlin 1.9.22
- `settings.gradle` with project name declared
- `AndroidManifest.xml` with INTERNET permission and application class registered
- `MainActivity.kt` — entry point, empty Compose scaffold
- `.gitignore` — protects API keys and build artifacts
- `CHANGELOG.md` — this file
- `README.md` — project overview and setup instructions
- `.github/PULL_REQUEST_TEMPLATE.md` — standardised PR checklist
- `local.properties.example` — safe template showing required keys

### Notes
- App compiles and launches to a blank screen — intentional at this stage
- All dependency versions pinned for reproducible builds

---

## [0.2.0] — Day 2 — Constants and Application Class

### Added
- `backend/config/Constants.kt` — single source of truth for all constant values:
  - News API base URL, endpoint paths, default query parameters
  - All 7 news category strings (used in Day 13 chip filter)
  - Gemini AI model name and summary prompt template
  - Room database name and version (used in Day 14)
  - UI constants: search debounce delay, max AI article characters
- `backend/config/NewsFlowApplication.kt` — custom Application subclass:
  - Registered in AndroidManifest.xml `android:name` attribute
  - Debug-only logging showing API key presence on startup
  - Global uncaught exception handler for crash visibility
  - Placeholder comments for Day 11 (Gemini) and Day 14 (Room) init

### Notes
- All API keys accessed via `BuildConfig.*` — never hardcoded
- Application class is intentionally lightweight (fast startup)

---

<!-- Future entries will be added here as development progresses -->
<!-- Example:
## [0.2.0] — Day 2 — Constants and Application Class
### Added
- `Constants.kt` — API base URL and endpoint constants
- `NewsFlowApplication.kt` — Application subclass for global init
-->
