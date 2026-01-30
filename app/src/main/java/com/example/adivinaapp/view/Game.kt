package com.example.adivinaapp.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.adivinaapp.ui.theme.Color1
import com.example.adivinaapp.ui.theme.Color2
import com.example.adivinaapp.viewmodels.GameViewModel
import java.util.logging.Logger
import kotlin.math.log
import kotlin.random.Random


@Composable
fun GameScreen(viewModel: GameViewModel, navController: NavController) {

    // LOGGER, REMOVE
    val logger: Logger = Logger.getLogger("logger")

    var textInput by remember { mutableStateOf("") }

    val progressLine: Float by animateFloatAsState((viewModel.attemptsRemaining.toFloat() / 10))

    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(viewModel.numberText, fontSize = 50.sp)
        LinearProgressIndicator(
            progress = { progressLine },
            modifier = Modifier.fillMaxWidth().height(10.dp),
            color = Color.Red,
            trackColor = Color.LightGray,
            strokeCap = StrokeCap.Square
        )
        OutlinedTextField(
            value = textInput, onValueChange = { textInput = it },
            label = { Text(text = "Introdueix un número (1-10)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
        )
        Button(
            onClick = {
                viewModel.checkIfNumberIsCorrect(textInput)
            }
        ) { Text("Comprovar") }
        Text(
            text = viewModel.failedText,
            color = Color.Red,
        )
        Text(
            text = viewModel.finalText,
            color = Color.Green
        )
        Text(
            text = viewModel.finalFailText,
            color = Color.Red
        )
        Text(
            text = viewModel.wrongNumbers
        )
        Row {
            Button(
                onClick = {
                    viewModel.getNewRandNumber()
                },
                colors = ButtonColors(
                    Color1,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.White,
                )
            ) {
                Text("Torna a jugar")
            }
            Button(
                onClick = {
                    navController.navigate("menu")
                },
                colors = ButtonColors(
                    Color2,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.White,
                )
            ) {
                Text("Menú principal")
            }
        }

    }
}

fun getNewNumber(): Int {
    val random: Random = Random
    return random.nextInt(1, 11)
}


fun resetGame() {

}