package com.example.imt.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imt.viewModel.ImtViewModel

@Composable
fun ImtView(
    navController: NavController,
    imtViewModel: ImtViewModel
){
    val height = remember { mutableStateOf<String>("") }
    val weight = remember { mutableStateOf<String>("") }
    val result = remember { mutableStateOf<String>("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
            .imePadding(),
        verticalArrangement = Arrangement.spacedBy (18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
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
        TextField(
            modifier = Modifier.fillMaxWidth(),
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
        Button(
            modifier = Modifier.wrapContentWidth(),
            onClick = {
                result.value = imtViewModel.counting(height.value.toDouble() ,weight.value.toDouble())
            }
        ) {
            Text(
                text = "бупс дупси"
            )
        }
        Text(
            text = result.value,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    }
}