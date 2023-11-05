package com.example.practice_coffeeshops_di.CoverCoffeeShops

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coverCoffe(navController: NavController) {
    //Creamos el Scaffold para la Top App Bar
    Scaffold(
        topBar = { scaffoldTopBar() }
    ) {
        //Creo una variable por que si lo metia directamente no me funcionaba
        val allItemsShops = getAllItemsShops()
        //Creo la Lazy con su espacio y que calcule automaticamente la Top App Bar
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ) {
            items(allItemsShops) { allItemsCard -> //Así se llamaran todas las cards
                createCard(
                    pictureTitleName = allItemsCard,
                    navController = navController
                )
            }
        }
    }
}