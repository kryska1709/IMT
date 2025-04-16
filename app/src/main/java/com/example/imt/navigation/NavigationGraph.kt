package com.example.imt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imt.view.ImtView
import com.example.imt.view.InfoImtView
import com.example.imt.viewModel.ImtViewModel

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    imtViewModel: ImtViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ImtScreen.route
    ){
        composable(
            route = Screen.ImtScreen.route
        ){
            ImtView(
                navController = navHostController,
                imtViewModel
            )
        }

        composable(
            route = Screen.InfoScreen.route
        ){
            InfoImtView()
        }
    }
}