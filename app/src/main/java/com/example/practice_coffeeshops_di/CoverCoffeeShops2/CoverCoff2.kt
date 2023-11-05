package com.example.practice_coffeeshops_di.CoverCoffeeShops2

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.practice_coffeeshops_di.CoverCoffeeShops.scaffoldTopBar
import com.example.practice_coffeeshops_di.ui.theme.FontTitle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun coverCoff2(navController1: String, navController: NavController) {
    //Esto te permite acceder a los argumentos de navegación asociados con la entrada actual.
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    //Coge el nombre cuando nosotros clicamos en la imagen, sino clicamos, no pasa el nombre
    val nameCoffe = navBackStackEntry?.arguments?.getString("cafeName") ?: ""

    //Esta cvariable es para cuando hagas scroll te ponga el buttom
    val listState = rememberLazyStaggeredGridState()

    val buttonVisible = remember { mutableStateOf(true) }

    //Creamos el Scaffold para la Top App Bar
    Scaffold(
        topBar = { scaffoldTopBar() }
    ) {
        Column( //Creamos la columna para coger la superficie
            verticalArrangement = Arrangement.Center,
            //Importante por que sino no sale, ya que esta debajo de la pantalla
            modifier = Modifier.padding(top = it.calculateTopPadding())
        ){
            Row( //Esta es la row donde va el titulo que cogemos de la otra clase
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = nameCoffe,
                    fontSize = 33.sp,
                    fontFamily = FontTitle,
                    modifier =Modifier.padding(10.dp)
                )
            }
            //Aquí ya pasamos los comentartios de la lista de items
            LazyVerticalStaggeredGrid(
                //Para qwue salgand e dos en dos
                columns = StaggeredGridCells.Fixed(2),
                state = listState,
                content = {
                    items(getCommentsCoff()) {commentsItem ->
                       itemComment(
                           commentsCoffe = commentsItem)
                    }
                }
            )
            //Cuando haces el scroll para que sepa si tiene que poner el boton o no
            val scrollOffset = listState.firstVisibleItemScrollOffset

            //Si esta arriba no lo muestra
            if (scrollOffset > 0 && buttonVisible.value) {
                buttonVisible.value = false
                //Si estamos en el centro o bajo si que lo pone
            } else if (scrollOffset == 0 && !buttonVisible.value) {
                buttonVisible.value = true
            }
        }
        buttomFinalScreen(buttonVisible)
    }
}