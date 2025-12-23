package com.example.laliga2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.laliga2022.ui.navigation.NavGraph
import com.example.laliga2022.ui.theme.LaLiga2022Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaLiga2022Theme {
                NavGraph()
            }
        }
    }
}
