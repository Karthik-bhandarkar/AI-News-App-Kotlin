// =============================================================================
//  NewsFlowApplication.kt — Custom Application Class
//  Package : com.karthik.newsflow.backend.config
//  Version : 0.2.0  |  Added: Day 2
// =============================================================================
//
//  PURPOSE:
//  Android creates this class BEFORE any Activity, Service, or Receiver.
//  Use it for one-time global initialisation that must run at app startup.
//
//  REGISTERED IN:
//  AndroidManifest.xml → android:name=".backend.config.NewsFlowApplication"
//
//  CONNECTIONS:
//  → AndroidManifest.xml (Day 1)      — registers this as the Application class
//  → Constants.kt (Day 2)             — same package; used for key-presence check
//  → GeminiClient.kt (Day 11)         — will be initialised here
//  → NewsDatabase.kt (Day 14)         — will be initialised here
//
package com.karthik.newsflow.backend.config

import android.app.Application
import android.util.Log

class NewsFlowApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Log API key presence on startup (debug builds only)
        if (isDebugBuild()) {
            Log.d(APP_LOG_TAG, "NewsFlowApplication started")
            Log.d(APP_LOG_TAG, "News API key present: ${Constants.API_KEY.isNotEmpty()}")
            Log.d(APP_LOG_TAG, "Gemini API key present: ${Constants.GEMINI_API_KEY.isNotEmpty()}")
        }

        setupExceptionHandler()

        // TODO Day 11: initGeminiClient()
        // TODO Day 14: initDatabase()
    }

    /**
     * Returns true if this is a debug build.
     * Reads from the generated BuildConfig class using reflection.
     */
    private fun isDebugBuild(): Boolean {
        return try {
            val cls = Class.forName("${packageName}.BuildConfig")
            cls.getField("DEBUG").getBoolean(null)
        } catch (e: Exception) {
            true // Default to debug if unknown
        }
    }

    /**
     * Logs uncaught exceptions before handing off to the system crash dialog.
     * In production, replace with Firebase Crashlytics or similar.
     */
    private fun setupExceptionHandler() {
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e(APP_LOG_TAG, "UNCAUGHT EXCEPTION on thread: ${thread.name}", throwable)
            defaultHandler?.uncaughtException(thread, throwable)
        }
    }

    companion object {
        /** Logcat tag — filter by this in Android Studio to see app-level logs */
        const val APP_LOG_TAG = "NewsFlow"
    }
}
