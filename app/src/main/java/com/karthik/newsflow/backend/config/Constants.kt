// =============================================================================
//  Constants.kt — App-Wide Constant Values
//  Package : com.karthik.newsflow.backend.config
//  Version : 0.2.0  |  Added: Day 2
// =============================================================================
//
//  PURPOSE:
//  Single source of truth for every constant value in the app.
//  Instead of scattering "magic strings" across files, define once, use everywhere.
//
//  CONNECTIONS:
//  → app/build.gradle (Day 1)                  injects BuildConfig.NEWS_API_KEY
//  → backend/network/RetrofitInstance.kt (Day 4) reads BASE_URL, API_KEY
//  → backend/network/NewsApiService.kt (Day 4)   reads ENDPOINT_* constants
//  → backend/network/GeminiClient.kt (Day 11)    reads GEMINI_* constants
//  → frontend/components/CategoryChips.kt (Day 13) uses ALL_CATEGORIES list
//  → backend/database/NewsDatabase.kt (Day 14)  reads DATABASE_NAME, VERSION
//
package com.karthik.newsflow.backend.config

import com.karthik.newsflow.BuildConfig

object Constants {

    // ── News API ──────────────────────────────────────────────────────────────
    /** Root URL for all News API calls. Trailing slash required by Retrofit. */
    const val BASE_URL = "https://newsapi.org/v2/"

    /** API key read from BuildConfig, injected at compile time from local.properties */
    val API_KEY: String = BuildConfig.NEWS_API_KEY

    /** Endpoint: today's top headlines  →  GET /v2/top-headlines */
    const val ENDPOINT_TOP_HEADLINES = "top-headlines"

    /** Endpoint: keyword search          →  GET /v2/everything */
    const val ENDPOINT_EVERYTHING = "everything"

    // ── Default Query Parameters ─────────────────────────────────────────────
    /** Default country for top headlines. "us" = United States. */
    const val DEFAULT_COUNTRY = "us"

    /** Articles per page. Free tier max = 100; 20 is good for UX. */
    const val DEFAULT_PAGE_SIZE = 20

    /** Starting page for pagination (1-indexed). */
    const val DEFAULT_PAGE = 1

    // ── News Categories (used Day 13 — CategoryChips.kt) ─────────────────────
    const val CATEGORY_BUSINESS      = "business"
    const val CATEGORY_ENTERTAINMENT = "entertainment"
    const val CATEGORY_HEALTH        = "health"
    const val CATEGORY_SCIENCE       = "science"
    const val CATEGORY_SPORTS        = "sports"
    const val CATEGORY_TECHNOLOGY    = "technology"
    const val CATEGORY_GENERAL       = "general"

    /** Ordered list used to build the horizontal chip row in Day 13. */
    val ALL_CATEGORIES = listOf(
        CATEGORY_GENERAL, CATEGORY_TECHNOLOGY, CATEGORY_BUSINESS,
        CATEGORY_SPORTS, CATEGORY_ENTERTAINMENT, CATEGORY_HEALTH, CATEGORY_SCIENCE
    )

    // ── Google Gemini AI (used Day 11 — GeminiClient.kt) ─────────────────────
    /** Gemini API key from BuildConfig. Populated from local.properties. */
    val GEMINI_API_KEY: String = BuildConfig.GEMINI_API_KEY

    /** Gemini text-only model. "gemini-pro-vision" would support images. */
    const val GEMINI_MODEL = "gemini-pro"

    /**
     * Prompt template for article summarization.
     * %s is replaced with the article text at runtime in SummaryRepository.kt (Day 11).
     */
    const val GEMINI_SUMMARY_PROMPT =
        "You are a news summarizer. Read the following article and provide a " +
        "concise, neutral summary in 3-4 sentences. Focus on the key facts. " +
        "Do not add opinions or information not present in the article.\n\nArticle:\n%s"

    // ── Room Database (used Day 14) ───────────────────────────────────────────
    /** Name of the SQLite database file stored on the device. */
    const val DATABASE_NAME = "newsflow_database"

    /** Increment this when you change any Room table structure. */
    const val DATABASE_VERSION = 1

    // ── UI / UX Constants ─────────────────────────────────────────────────────
    /**
     * Milliseconds to wait after user stops typing before firing search API call.
     * Used in frontend/components/SearchBar.kt (Day 13).
     */
    const val SEARCH_DEBOUNCE_MS = 500L

    /**
     * Max characters from an article sent to Gemini for summarization.
     * Prevents exceeding the model's context window.
     * Used in backend/data/repository/SummaryRepository.kt (Day 11).
     */
    const val MAX_ARTICLE_CHARS_FOR_AI = 3000
}
