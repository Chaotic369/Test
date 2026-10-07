package com.example.edgering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.edgering.ui.settings.SettingsScreen
import com.example.edgering.ui.theme.EdgeRingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdgeRingTheme {
                SettingsScreen(versionName = BuildConfig.VERSION_NAME)
            }
        }
    }
}
