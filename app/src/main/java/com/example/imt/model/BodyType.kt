package com.example.imt.model

import com.example.imt.R

enum class BodyType(
    val description: String,
    val image: Int
) {
    UNDERWEIGHT("Недовеееееееес",R.drawable.tungtungtungsaur),
    NORMAL("Нормасик",R.drawable.bomborito_bandito),
    OVERWEIGHT("перевееЕЕееЕес",R.drawable.burboloniloliloni),
    ANOMALY("АнОмАлИя",R.drawable.tralalero_tralala)
}