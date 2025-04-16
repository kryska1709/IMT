package com.example.imt.viewModel

import android.icu.text.DecimalFormat
import androidx.lifecycle.ViewModel
class ImtViewModel() : ViewModel(){
    fun counting(
        height: Double,
        weight: Double
    ) : String{
        val result = weight/((height/100)*(height/100))
        return when {
            result < 18.5 -> "${result.doubleToString()} это недовес!!!"
            result >= 18.5 && result <= 24.9 -> "${result.doubleToString()} это норма)))"
            result >=25 -> "${toDoublblbl(result)} это перевес!!! "
            else -> "вы АнОмАлИя?!"
        }
    }
}
fun Double.doubleToString():String{
    val format = DecimalFormat("#.00")
    return format.format(this)
}
fun toDoublblbl(tutu: Double):String{
    val format = DecimalFormat("#.00")
    return format.format(tutu)
}