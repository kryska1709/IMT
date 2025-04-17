package com.example.imt.viewModel

import android.icu.text.DecimalFormat
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.imt.model.BodyType

class ImtViewModel() : ViewModel(){
    var result = mutableStateOf<Double?>(null)
    fun counting(
        height: Double,
        weight: Double
    ) : BodyType?{
        result.value = weight/((height/100)*(height/100))
        return result.value?.let {
            when {
                it < 18.5 -> BodyType.UNDERWEIGHT
                it >= 18.5 && it <= 24.9 -> BodyType.NORMAL
                it >= 25 -> BodyType.OVERWEIGHT
                else -> BodyType.ANOMALY
            }
        }
    }
}
fun Double.doubleToString():String{
    val format = DecimalFormat("#.00")
    return format.format(this)
}
