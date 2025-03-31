package com.github.iscle.wooboxforhyperos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.github.iscle.wooboxforhyperos.ui.WooBoxApp
import com.github.iscle.wooboxforhyperos.ui.theme.WooBoxForHyperOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WooBoxForHyperOSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    WooBoxApp()
                }
            }
        }
    }
}
