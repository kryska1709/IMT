package com.example.imt.navigation

sealed class Screen (val route:String){
    data object ImtScreen : Screen(route = "imt_screen")
    data object InfoScreen : Screen(route = "info_screen")
}