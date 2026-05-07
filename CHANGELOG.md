# Changelog

All notable changes to **NewsFlow** are documented here.
Format: `## [version] — Day N — Description`

---

## [0.2.0] — Day 2 — Constants and Application Class

### Added
- `backend/config/Constants.kt` — single source of truth for all constants:
  - News API base URL, endpoints, default query parameters
  - All 7 news category strings (used in Day 13 chip filter)
  - Gemini AI model name and prompt template (used in Day 11)
  - Room database name and version constants (used in Day 14)
  - UI constants: search debounce delay, max AI chars
- `backend/config/NewsFlowApplication.kt` — custom Application subclass:
  - Registered in AndroidManifest.xml android:name attribute
  - Debug-only logging showing API key presence on startup
  - Global uncaught exception handler for crash visibility

---

## [0.1.0] — Day 1 — Project Scaffold

### Added
- `app/build.gradle` with all 14-day dependencies, API key injection via BuildConfig
- `build.gradle` (root) with AGP 8.2.2 and Kotlin 1.9.22
- `settings.gradle` with project name and module declaration
- `AndroidManifest.xml` with INTERNET permission, Application class registered
- `MainActivity.kt` — entry point, Compose placeholder screen
- `app/src/main/res/values/strings.xml` — all app string resources
- `app/src/main/res/values/themes.xml` — Material3 NoActionBar theme
- `app/proguard-rules.pro` — Retrofit, Room, Gemini, Coroutines keep rules
- `.gitignore` — protects API keys and build artifacts
- `local.properties.example` — safe key template
- `.github/PULL_REQUEST_TEMPLATE.md`
