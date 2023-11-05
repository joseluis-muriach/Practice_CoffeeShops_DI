package com.example.practice_coffeeshops_di.CoverCoffeeShops2

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


data class CommentsCoffe(
    var comment: String
)

fun getCommentsCoff(): List<CommentsCoffe> {
    return listOf(
        CommentsCoffe("Servicio algo flojo, aún así lo recomiendo"),
        CommentsCoffe("Céntrica y acogedora. Volveremos seguro"),
        CommentsCoffe("La ambientacion muy buena, pero en la planta de arriba un poco escasa."),
        CommentsCoffe(
            "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos.\n" +
                    "El personal muy amable, nos permitieron ver todo el establecimiento.\n"
        ),
        CommentsCoffe("Muy bueno"),
        CommentsCoffe("Excelente. Destacable la extensa carta de cafés."),
        CommentsCoffe("Buen ambiente y buen servicio. Lo recomiendo."),
        CommentsCoffe("En días festivos demasiado tiempo de espera."),
        CommentsCoffe("Los camareros/as no dan abasto."),
        CommentsCoffe("No lo recomiendo."),
        CommentsCoffe("No volveré."),
        CommentsCoffe("Repetiremos."),
        CommentsCoffe("Gran selección de tartas y cafés."),
        CommentsCoffe(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal." + "\n" +
                    "Puntos negativos: el servicio es muy lento y los precios son un poco elevados.",),
        CommentsCoffe("Todo lo que he probado en la cafetería está riquísimo, dulce o salado.")
    )
}

@Composable
//Esto lo creamos para meter nuestra lista de comentarios en las cards
fun itemComment(commentsCoffe: CommentsCoffe) {
    Card(
        Modifier
            .fillMaxHeight()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color(0xFFF3C5BF)) //El color de la card
    ) {
        Text(
            text = commentsCoffe.comment,
            modifier = Modifier.padding(10.dp)
        )
    }
}
