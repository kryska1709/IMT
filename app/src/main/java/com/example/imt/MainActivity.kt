package com.example.imt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.imt.navigation.NavigationGraph
import com.example.imt.navigation.Screen
import com.example.imt.ui.theme.BotBar
import com.example.imt.ui.theme.IMTTheme
import com.example.imt.viewModel.ImtViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val imtViewModel = viewModel<ImtViewModel>()
            IMTTheme {
                val items = listOf<BottomBarItem>(
                    BottomBarItem(Screen.ImtScreen.route, painterResource(R.drawable.calculating), Color.Magenta),
                    BottomBarItem(Screen.InfoScreen.route, painterResource(R.drawable.inform_icon_icons_com_67949), Color.Magenta)
                )
                val selectedItemIndex = remember { mutableStateOf<Int>(0) }
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar(
                            containerColor = BotBar
                        ) {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    modifier = Modifier.background(Color.Transparent),
                                    selected = selectedItemIndex.value == index,
                                    onClick = {
                                        selectedItemIndex.value = index
                                        navController.navigate(item.route)
                                    },
                                    colors = NavigationBarItemColors(selectedIndicatorColor = Color.Transparent, selectedIconColor = item.color, disabledIconColor = Color.White, selectedTextColor = Color.Transparent, unselectedIconColor = Color.White, unselectedTextColor = Color.Transparent, disabledTextColor = Color.Transparent) ,
                                    icon = {
                                        Icon(
                                            item.icon,
                                            contentDescription = null,
                                            modifier = Modifier.size(40.dp)
                                                .background(Color.Transparent)
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(
                       modifier =  Modifier.padding(innerPadding)
                    ){
                        NavigationGraph(navController,imtViewModel)
                    }
                }
            }
        }
    }
}

