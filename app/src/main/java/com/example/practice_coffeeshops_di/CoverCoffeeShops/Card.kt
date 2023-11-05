package com.example.practice_coffeeshops_di.CoverCoffeeShops

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practice_coffeeshops_di.ui.theme.FontTitle

@SuppressLint("InvalidColorHexValue")
@Composable
fun createCard(pictureTitleName: PictureTitleName, navController: NavController) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                /*Esto coge el nombre de la card (cuando clique) y se lo lleva al MAIN
                el cual, este se lo llevara a la portada2*/
                   navController.navigate("coverCoff2/${pictureTitleName.nameCoff}")
            },
        colors = CardDefaults.cardColors(Color(0xFFF3C5BF)) //El color de la card
    ) {

        //Para la imagen
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp),
            painter = painterResource(id = pictureTitleName.photoCoff),
            contentDescription = "Solo la imagen",
            contentScale = ContentScale.Crop
        )

       //Para el titulo
        Row(
            Modifier.fillMaxWidth()
        ) {
            Text(
                text = pictureTitleName.nameCoff,
                fontSize = 25.sp,
                modifier = Modifier.padding(10.dp),
                fontFamily = FontTitle
            )
        }

        //Para las estrellas
        Row(
            Modifier.fillMaxWidth()
        ) {
            createStars()
        }

        //Para el nickname
        Row(
            Modifier.fillMaxWidth()
        ) {
            Text(
                text = pictureTitleName.nickname,
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
            )
        }
        //Creamos el divider
        Divider()
        
        //El botón sin el area, por eso es TextButton
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "RESERVE"
            )
        }
    }
}