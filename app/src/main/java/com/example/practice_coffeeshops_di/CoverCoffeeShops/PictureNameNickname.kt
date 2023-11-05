package com.example.practice_coffeeshops_di.CoverCoffeeShops

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.example.practice_coffeeshops_di.R

data class PictureTitleName (
    @DrawableRes var photoCoff: Int,
    var nameCoff: String,
    var nickname: String
)

@Composable
fun getAllItemsShops(): List <PictureTitleName> {
    return listOf(
        PictureTitleName(
            R.drawable.imagees,
            "Atico Caffe Greco",
            "St. Italy, Rome"
        ),

        PictureTitleName(
            R.drawable.imagees1,
            "Coffee Room",
            "St. Germany, Berlin"
        ),

        PictureTitleName(
            R.drawable.imagees2,
            "Coffe Ibiza",
            "St. Colon, Madrid"
        ),

        PictureTitleName(
            R.drawable.imagees3,
            "Pudding Coffe shop",
            "St. Diagonal Barcelona"
        ),

        PictureTitleName(
            R.drawable.imagees4,
            "LÉxpress",
            "St. Picadilly Circus, London"
        ),

        PictureTitleName(
            R.drawable.imagees5,
            "Coffe Corner",
            "St. Angel Guimera, Valencia"
        ),

        PictureTitleName(
            R.drawable.imagees6,
            "Sweet Cup",
            "St. Kinkerstraat, Amsterdam"
        ),
    )
}