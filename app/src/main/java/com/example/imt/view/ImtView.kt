package com.example.imt.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imt.navigation.Screen

@Composable
fun ImtView(
    navController: NavController
){
    val height = remember { mutableStateOf<String>("") }
    val weight = remember { mutableStateOf<String>("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = height.value,
            onValueChange = {
                height.value = it
            },
            label = {
                Text(
                    text = "Рост"
                )
            }
        )
        Text(
            text = height.value
        )
        TextField(
            value = weight.value,
            onValueChange = {
                weight.value = it
            },
            label = {
                Text(
                    text = "Вес"
                )
            }
        )
        Text(
            text = weight.value
        )
        Button(
            modifier = Modifier.wrapContentWidth(),
            onClick = {
                navController.navigate(route = Screen.InfoScreen.route)
            }
        ) {
            Text(
                text = "бупс дупси"
            )
        }
    }
}