package com.example.adivinaapp.view

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.adivinaapp.R

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Adivina el número per Iago Fariñas",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,)
        Spacer(Modifier.size(10.dp))
        Image(
            painter = painterResource(R.drawable.ic_game),
            contentDescription = "App logo",
            modifier = Modifier.size(80.dp)
        )
        Spacer(Modifier.size(10.dp))
        Button(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            onClick = {
                navController.navigate("game")
            }
        ) { Text("Iniciar partida") }
    }
}