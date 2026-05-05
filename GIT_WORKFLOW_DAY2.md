# Day 2 — Git Workflow Guide
# NewsFlow | Version 0.2.0
# =============================================================================
#
#  Follow these steps IN ORDER in your terminal from the project root.
#
#  BEFORE YOU START: Make sure Day 1 is fully committed and pushed.
#  Run: git log --oneline   — you should see the Day 1 merge commit at the top.
#
# =============================================================================


# =============================================================================
#  STEP 1 — Fix the Day 1 gap: push missing files that weren't on GitHub yet
#
#  Your GitHub repo currently has: .gitignore, README.md, build.gradle,
#  local.properties.template — but is missing the app/ module entirely.
#  We fix that first before branching for Day 2.
# =============================================================================

# Make sure you're on main and up to date
git checkout main
git pull origin main

# ⚠️  REMOVE the accidental mnt/ folder that was committed to your repo.
# This folder is Claude's workspace — it should never be in your project.
# Run this from your project root:
git rm -r --cached mnt/
git commit -m "chore: remove accidental mnt/ workspace folder from repo"
git push origin main

# Now add all the Day 1 files that were generated but not yet pushed
# (settings.gradle, CHANGELOG.md, app/build.gradle, AndroidManifest.xml,
#  MainActivity.kt, strings.xml, themes.xml, proguard-rules.pro, etc.)
git add .
git status
# Verify only real project files are staged — nothing from mnt/

git commit -m "chore: add missing Day 1 app module files

- app/build.gradle with all 14-day dependencies and API key injection
- app/src/main/AndroidManifest.xml with INTERNET permission
- app/src/main/java/.../MainActivity.kt with Compose placeholder
- app/src/main/res/values/strings.xml
- app/src/main/res/values/themes.xml
- app/proguard-rules.pro with Retrofit, Room, Gemini rules
- settings.gradle with project name and module declaration
- CHANGELOG.md with Day 1 entry
- .github/PULL_REQUEST_TEMPLATE.md
- local.properties.example (safe template, no real keys)
- GIT_WORKFLOW_DAY1.md

Version: 0.1.0 (backfill)"

git push origin main


# =============================================================================
#  STEP 2 — Create the Day 2 Feature Branch
# =============================================================================

git checkout -b feature/day-2-constants-and-application-class


# =============================================================================
#  STEP 3 — Add the Day 2 Files
#
#  Copy these two files into your project at the exact paths shown:
#
#  app/src/main/java/com/karthik/newsflow/backend/config/Constants.kt
#  app/src/main/java/com/karthik/newsflow/backend/config/NewsFlowApplication.kt
#
#  Also copy the updated:
#  README.md        (Day 2 status row now shows ✅)
#  CHANGELOG.md     (Day 2 entry added)
# =============================================================================

git add .
git status

# Expected new files:
#   new file:   app/src/main/java/com/karthik/newsflow/backend/config/Constants.kt
#   new file:   app/src/main/java/com/karthik/newsflow/backend/config/NewsFlowApplication.kt
#   modified:   README.md
#   modified:   CHANGELOG.md


# =============================================================================
#  STEP 4 — Commit
# =============================================================================

git commit -m "feat(config): add Constants.kt and NewsFlowApplication

Constants.kt:
- NEWS API base URL, endpoint paths, default parameters
- All 7 category constants for Day 13 chip filter
- Gemini model name and summarization prompt template
- Room database name and version constants
- UI constants: search debounce delay, max AI chars

NewsFlowApplication.kt:
- Registered as Application class in AndroidManifest.xml
- Debug-only logging with API key presence check
- Global uncaught exception handler for crash visibility
- Placeholder stubs for Day 11 (Gemini) and Day 14 (Room)

Resolves: Day 2 milestone
Version: 0.2.0"


# =============================================================================
#  STEP 5 — Push Feature Branch
# =============================================================================

git push origin feature/day-2-constants-and-application-class


# =============================================================================
#  STEP 6 — Merge to Main
# =============================================================================

git checkout main
git merge --no-ff feature/day-2-constants-and-application-class \
  -m "Merge feature/day-2-constants-and-application-class into main

Day 2 complete: Constants.kt and NewsFlowApplication.kt added.
All app-wide constants centralised. Application class registered.
Version: 0.2.0"

git push origin main


# =============================================================================
#  STEP 7 — Tag the Version
# =============================================================================

git tag -a v0.2.0 -m "v0.2.0 — Day 2: Constants and Application class"
git push origin v0.2.0


# =============================================================================
#  STEP 8 — Verify
#  After pushing, open your GitHub repo in a browser and confirm:
#  ✅ app/src/main/java/com/karthik/newsflow/backend/config/ folder exists
#  ✅ Constants.kt and NewsFlowApplication.kt are visible
#  ✅ No mnt/ folder in the repo root
#  ✅ CHANGELOG.md shows v0.2.0 entry
# =============================================================================
