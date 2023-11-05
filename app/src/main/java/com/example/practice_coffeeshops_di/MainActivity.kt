package com.example.practice_coffeeshops_di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practice_coffeeshops_di.CoverCoffeeShops.coverCoffe
import com.example.practice_coffeeshops_di.CoverCoffeeShops2.coverCoff2
import com.example.practice_coffeeshops_di.ui.theme.Practice_CoffeeShops_DITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_CoffeeShops_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Se crea la variable ya que es necesaria para hacer la navegabilidad
                    val navController  = rememberNavController()

                    //Esto para dercirle cual es la primera pantalla que saldra en la App
                    NavHost(navController = navController, startDestination = "CoverCoffee"){
                        //Mismo nombre que arriba    y  el nombre de la función
                        composable("CoverCoffee") {coverCoffe(navController = navController)}
                        //Este es el segundo destino
                        composable(
                            route = "CoverCoff2/{cafeName}",
                            arguments = listOf(navArgument("cafeName") { type = NavType.StringType} )
                        ) { backStackEntry ->
                            //Aquí le pasamos la variable que recoge el nombre de la card
                            coverCoff2 (
                                backStackEntry.arguments?.getString("cafeName") ?: "", navController)
                        }
                    }
                }
            }
        }
    }
}
