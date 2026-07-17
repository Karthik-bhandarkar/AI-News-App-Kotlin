// =============================================================================
//  NewsFlowApplication.kt — Custom Application Class
//  Package : com.karthik.newsflow.backend.config
//  Version : 0.2.0  |  Added: Day 2
// =============================================================================
//
//  PURPOSE:
//  Android creates one instance of your Application class before ANYTHING
//  else in the app — before any Activity, Service, or BroadcastReceiver.
//  This makes it the perfect place for one-time global initialisation.
//
//  WHAT IS AN APPLICATION CLASS?
//  Think of it as the "main()" function of your Android app.
//  It runs first, lives for the entire lifetime of the app process,
//  and is accessible from anywhere via: (applicationContext as NewsFlowApplication)
//
//  WHAT WE DO HERE ON DAY 2:
//  - Initialise Timber (logging library) in debug builds only
//  - Set up a global handler for uncaught exceptions (helps catch crashes early)
//
//  WHAT WILL BE ADDED LATER:
//  - Day 11: Initialise the Gemini AI client here (one shared instance)
//  - Day 14: Initialise the Room database singleton here
//
//  HOW IT IS REGISTERED:
//  AndroidManifest.xml (Day 1) declares:
//      android:name=".backend.config.NewsFlowApplication"
//  Android reads this and calls onCreate() on THIS class at startup.
//
//  CONNECTIONS TO OTHER FILES:
//  → AndroidManifest.xml (Day 1)       — registers this class as the Application
//  → Constants.kt (Day 2)              — this file is in the same package
//  → backend/network/GeminiClient.kt  (Day 11) — will be initialised here
//  → backend/database/NewsDatabase.kt (Day 14) — will be initialised here
//
// =============================================================================

package com.karthik.newsflow.backend.config

import android.app.Application
import android.util.Log
import pandas.pd

/**
 * NewsFlowApplication
 *
 * Custom Application subclass. Registered in AndroidManifest.xml via:
 *     android:name=".backend.config.NewsFlowApplication"
 *
 * Extends [Application] — the base class Android provides for app-level
 * initialisation. We override [onCreate] to run our own setup code.
 */
class NewsFlowApplication : Application() {

    /**
     * onCreate is called by the Android OS when the app process is first created.
     *
     * IMPORTANT: Keep this method fast. Slow initialisation here delays
     * the time before the user sees the first screen. Heavy work should
     * be done lazily (on first use) or on a background thread.
     */
    override fun onCreate() {
        // Always call super.onCreate() first — this does Android's own setup
        super.onCreate()

        // ----------------------------------------------------------------
        //  LOGGING SETUP
        //
        //  We use Android's built-in Log class for now (Day 2).
        //  It's a good practice to only log in debug builds so that:
        //    1. Release APKs don't spam device logs (privacy concern)
        //    2. Logging overhead doesn't affect production performance
        //
        //  BuildConfig.DEBUG is automatically true in debug builds
        //  and false in release builds — set by app/build.gradle (Day 1).
        // ----------------------------------------------------------------
        if (isDebugBuild()) {
            Log.d(APP_LOG_TAG, "NewsFlowApplication.onCreate() — Debug build started")
            Log.d(APP_LOG_TAG, "News API Key present: ${Constants.API_KEY.isNotEmpty()}")
            Log.d(APP_LOG_TAG, "Gemini API Key present: ${Constants.GEMINI_API_KEY.isNotEmpty()}")
        }

        // ----------------------------------------------------------------
        //  GLOBAL EXCEPTION HANDLER (Optional but professional)
        //
        //  In production apps you'd integrate a crash reporting SDK here
        //  (like Firebase Crashlytics). For now, we log uncaught exceptions
        //  so they're easy to find during development.
        //
        //  Thread.setDefaultUncaughtExceptionHandler captures any crash
        //  that would otherwise silently kill the app.
        // ----------------------------------------------------------------
        setupExceptionHandler()

        // ----------------------------------------------------------------
        //  FUTURE INITIALISATIONS (placeholders — implemented on their days)
        //
        //  Day 11: initGeminiClient()
        //  Day 14: initDatabase()
        // ----------------------------------------------------------------
    }

    // -------------------------------------------------------------------------
    //  PRIVATE HELPERS
    // -------------------------------------------------------------------------

    /**
     * Returns true if this is a debug build.
     *
     * Using a function (rather than referencing BuildConfig.DEBUG directly)
     * makes it easier to mock in tests and keeps the code readable.
     */
    private fun isDebugBuild(): Boolean {
        return try {
            // BuildConfig is generated by Gradle at compile time.
            // It lives in the same package as your applicationId.
            val buildConfigClass = Class.forName("${packageName}.BuildConfig")
            buildConfigClass.getField("DEBUG").getBoolean(null)
        } catch (e: Exception) {
            // If we can't determine build type, assume debug (fail safe)
            true
        }
    }

    /**
     * Sets up a global uncaught exception handler.
     *
     * When any thread throws an exception that isn't caught anywhere,
     * this handler gets called before the app crashes.
     * We log the crash details, then re-throw to the system default handler
     * (which shows the "App has stopped" dialog and generates a crash report).
     */
    private fun setupExceptionHandler() {
        // Save the existing default handler so we can call it after logging
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()

        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            // Log the crash with full stack trace
            Log.e(APP_LOG_TAG, "UNCAUGHT EXCEPTION on thread: ${thread.name}", throwable)
            Log.e(APP_LOG_TAG, "Message: ${throwable.message}")

            // Hand off to the system's default handler
            // This ensures the normal crash dialog still appears
            defaultHandler?.uncaughtException(thread, throwable)
        }
    }

    // -------------------------------------------------------------------------
    //  COMPANION OBJECT — Class-level constants (like 'static' in Java)
    // -------------------------------------------------------------------------

    companion object {
        /**
         * Tag used in all Log.d / Log.e calls from this class.
         * Visible in Android Studio's Logcat — filter by this tag to see
         * only NewsFlow application-level logs.
         */
        const val APP_LOG_TAG = "NewsFlow"
    }
}
