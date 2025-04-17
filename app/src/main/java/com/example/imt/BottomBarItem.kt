package com.example.imt

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class BottomBarItem(
    val route: String,
    val icon: Painter,
    val color: Color
)
