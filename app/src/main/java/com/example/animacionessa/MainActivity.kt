package com.example.animacionessa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.animacionessa.navigation.Navigation
import com.example.animacionessa.ui.theme.AnimacionesSATheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimacionesSATheme {
                Navigation()

            }
        }
    }
}

