// =============================================================================
//  MainActivity.kt — Application Entry Point
//  Package : com.karthik.newsflow
//  Version : 0.1.0  |  Added: Day 1
// =============================================================================
//
//  PURPOSE:
//  The single Activity that Android launches when the user taps the app icon.
//  Uses the single-activity pattern — Compose Navigation (Day 10) manages screens.
//
//  EVOLUTION:
//  → Day 1  : Shows a placeholder text (proves the app boots)
//  → Day 8  : Wrapped in NewsFlowTheme { }
//  → Day 10 : setContent will call NavGraph() to handle all screens
//
//  CONNECTIONS:
//  → AndroidManifest.xml (Day 1)  — declares this as LAUNCHER activity
//  → NewsFlowApplication (Day 2)  — runs BEFORE this class
//  → NavGraph.kt (Day 10)         — will replace the placeholder below
//  → Theme.kt (Day 8)             — will wrap content in NewsFlowTheme { }
//
package com.karthik.newsflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // TODO Day 10: Replace with NewsFlowTheme { NavGraph() }
            NewsFlowPlaceholder()
        }
    }
}

@Composable
fun NewsFlowPlaceholder() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "NewsFlow — Day 2 ✓\nProject scaffold is working.")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsFlowPlaceholderPreview() {
    NewsFlowPlaceholder()
}
