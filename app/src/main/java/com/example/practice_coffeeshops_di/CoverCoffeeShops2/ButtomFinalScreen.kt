package com.example.practice_coffeeshops_di.CoverCoffeeShops2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun buttomFinalScreen(buttonVisible: MutableState<Boolean>) {
    //Aquí cremaos el boton. lo creamos en una box pero se puede crear en otra cosa
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (!buttonVisible.value) {
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(16.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFD57669)),
            ) {
                Text(
                    text = "Add new comment",
                    color = Color.White
                )
            }
        }
    }
}

