// =============================================================================
//  Constants.kt — App-Wide Constant Values
//  Package : com.karthik.newsflow.backend.config
//  Version : 0.2.0  |  Added: Day 2
// =============================================================================
//
//  PURPOSE:
//  A single place to store every constant value the app needs.
//  Instead of scattering "magic strings" across many files, we define them
//  once here and import them wherever needed.
//
//  WHY THIS MATTERS:
//  If the News API changes its base URL tomorrow, you update ONE line here
//  instead of hunting through 10 files. This is called the DRY principle
//  (Don't Repeat Yourself) — a core rule of clean code.
//
//  HOW API KEYS ARE READ SAFELY:
//  We never write the actual key as a plain string here.
//  The key lives in local.properties (which is gitignored).
//  app/build.gradle (Day 1) reads local.properties at compile time and
//  injects the key into a generated class called BuildConfig.
//  We then read it here via BuildConfig.NEWS_API_KEY.
//
//  CONNECTIONS TO OTHER FILES:
//  → app/build.gradle (Day 1)         — injects BuildConfig.NEWS_API_KEY
//  → backend/network/RetrofitInstance.kt (Day 4) — reads BASE_URL, API_KEY
//  → backend/network/NewsApiService.kt  (Day 4)  — reads ENDPOINTS
//  → backend/network/GeminiClient.kt   (Day 11) — reads GEMINI_API_KEY
//
// =============================================================================

package com.karthik.newsflow.backend.config

import com.karthik.newsflow.BuildConfig

/**
 * Constants
 *
 * An object (Kotlin singleton) holding every constant the app needs.
 *
 * 'object' in Kotlin means there is exactly ONE instance of this class
 * in the entire app — like a static class in Java. You access values as:
 *     Constants.BASE_URL
 *     Constants.API_KEY
 */
object Constants {

    // -------------------------------------------------------------------------
    //  NEWS API — Base URL and Key
    //
    //  The News API docs: https://newsapi.org/docs
    //  All endpoints start with this base URL.
    //  Example full URL: https://newsapi.org/v2/top-headlines?country=us
    // -------------------------------------------------------------------------

    /**
     * The root URL for all News API HTTP requests.
     * Retrofit (Day 4) uses this as the starting point for every endpoint.
     * The trailing slash is REQUIRED by Retrofit.
     */
    const val BASE_URL = "https://newsapi.org/v2/"

    /**
     * The News API key, read securely from BuildConfig.
     * BuildConfig.NEWS_API_KEY is populated by app/build.gradle at compile time
     * from local.properties — the actual key is NEVER stored in source code.
     *
     * If this is empty (""), you forgot to add NEWS_API_KEY to local.properties.
     */
    val API_KEY: String = BuildConfig.NEWS_API_KEY

    // -------------------------------------------------------------------------
    //  NEWS API — Endpoint Paths
    //
    //  These are appended to BASE_URL by Retrofit to form the full URL.
    //  They mirror the paths in backend/network/NewsApiService.kt (Day 4).
    //
    //  TOP_HEADLINES  → fetches today's top news for a given country
    //  SEARCH_NEWS    → searches all articles by keyword
    // -------------------------------------------------------------------------

    /** Endpoint for fetching top headlines. Full URL example:
     *  https://newsapi.org/v2/top-headlines?country=us&apiKey=xxx */
    const val ENDPOINT_TOP_HEADLINES = "top-headlines"

    /** Endpoint for keyword-based news search. Full URL example:
     *  https://newsapi.org/v2/everything?q=bitcoin&apiKey=xxx */
    const val ENDPOINT_EVERYTHING = "everything"

    // -------------------------------------------------------------------------
    //  NEWS API — Default Query Parameters
    //
    //  These are the default values sent with every request.
    //  Users can override them later (e.g., by selecting a category in Day 13).
    // -------------------------------------------------------------------------

    /** Default country code for top headlines.
     *  "us" = United States. Other options: "in", "gb", "au", etc.
     *  Full list: https://newsapi.org/docs/endpoints/top-headlines */
    const val DEFAULT_COUNTRY = "us"

    /** Default number of articles to fetch per page.
     *  News API free tier maximum is 100, but 20 is a good balance for UX. */
    const val DEFAULT_PAGE_SIZE = 20

    /** Default page number for pagination. Starts at 1 (not 0). */
    const val DEFAULT_PAGE = 1

    // -------------------------------------------------------------------------
    //  NEWS API — Available Category Values
    //
    //  Used in Day 13 (frontend/components/CategoryChips.kt) to filter news.
    //  These are the exact string values the News API accepts.
    // -------------------------------------------------------------------------

    const val CATEGORY_BUSINESS     = "business"
    const val CATEGORY_ENTERTAINMENT = "entertainment"
    const val CATEGORY_HEALTH       = "health"
    const val CATEGORY_SCIENCE      = "science"
    const val CATEGORY_SPORTS       = "sports"
    const val CATEGORY_TECHNOLOGY   = "technology"
    const val CATEGORY_GENERAL      = "general"

    /** All categories as an ordered list — used to build the chip row in Day 13 */
    val ALL_CATEGORIES = listOf(
        CATEGORY_GENERAL,
        CATEGORY_TECHNOLOGY,
        CATEGORY_BUSINESS,
        CATEGORY_SPORTS,
        CATEGORY_ENTERTAINMENT,
        CATEGORY_HEALTH,
        CATEGORY_SCIENCE
    )

    // -------------------------------------------------------------------------
    //  GOOGLE GEMINI AI
    //
    //  Used in Day 11 (backend/network/GeminiClient.kt).
    //  The model name must exactly match one of Google's published model IDs.
    // -------------------------------------------------------------------------

    /**
     * The Gemini API key, read securely from BuildConfig.
     * Injected at compile time from local.properties via app/build.gradle.
     */
    val GEMINI_API_KEY: String = BuildConfig.GEMINI_API_KEY

    /**
     * The Gemini model to use for article summarization.
     * "gemini-pro" is the text-only model — suitable for our use case.
     * "gemini-pro-vision" supports images but we don't need that here.
     */
    const val GEMINI_MODEL = "gemini-pro"

    /**
     * The prompt template sent to Gemini along with each article text.
     * %s is a placeholder replaced at runtime with the actual article content.
     * Used in backend/data/repository/SummaryRepository.kt (Day 11).
     */
    const val GEMINI_SUMMARY_PROMPT =
        "You are a news summarizer. Read the following article and provide a " +
        "concise, neutral summary in 3-4 sentences. Focus on the key facts. " +
        "Do not add opinions or information not present in the article.\n\n" +
        "Article:\n%s"

    // -------------------------------------------------------------------------
    //  ROOM DATABASE
    //
    //  Used in Day 14 (backend/database/NewsDatabase.kt).
    // -------------------------------------------------------------------------

    /** The name of the local SQLite database file on the device. */
    const val DATABASE_NAME = "newsflow_database"

    /** Current schema version. Increment this when you change a table structure.
     *  Room uses this to know when to run a migration. */
    const val DATABASE_VERSION = 1

    // -------------------------------------------------------------------------
    //  UI / UX CONSTANTS
    //
    //  Used across frontend/ files (Days 8–13) to keep spacing and timing
    //  consistent without hardcoding numbers everywhere.
    // -------------------------------------------------------------------------

    /** Debounce delay for search input in milliseconds.
     *  We wait this long after the user stops typing before firing the API call.
     *  Used in frontend/components/SearchBar.kt (Day 13). */
    const val SEARCH_DEBOUNCE_MS = 500L

    /** Maximum number of characters from an article to send to Gemini.
     *  Avoids exceeding the model's context window and keeps costs low.
     *  Used in backend/data/repository/SummaryRepository.kt (Day 11). */
    const val MAX_ARTICLE_CHARS_FOR_AI = 3000
}
