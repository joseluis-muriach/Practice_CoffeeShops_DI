package com.example.practice_coffeeshops_di.CoverCoffeeShops

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun createStars(
    modifier: Modifier = Modifier,
    stars: Int = 5 //Creamos 5 estrellas
) {
    //Esta variable es para que la estrella pase a true o a false (todas empiezan en false)
    var starStates by remember { mutableStateOf(List(stars) { false } ) }

    //Esto se ejecuta para cuando hagamos click en una estrella
    val onStarClick: (Int) -> Unit = { starIndex ->
        //Si clicamos sobre la estrella numero 3 la 1, 2 y 3 se iluminaran, y así con todo
        starStates = starStates.mapIndexed { index, _ ->
            index <= starIndex
        }
    }

    Row(
        modifier = modifier //Para cambiar las propiedades
    ) {
        //Iteramos sobre la lista de estado de las estrellas junto con su indice(index) y estado(isFilled)
        starStates.forEachIndexed { index, isFilled ->
            //Creamos un icono de estrella sin rellenar (sin marcar)
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                //Si esta llena se pone en rojo, sino estará en blanco
                tint = if (isFilled) Color.Yellow else Color.White,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable { onStarClick(index) }
            )
        }
    }
}