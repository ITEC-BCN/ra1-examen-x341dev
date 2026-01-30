package com.example.adivinaapp.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.adivinaapp.view.getNewNumber
import java.lang.Exception
import kotlin.random.Random


class GameViewModel(application: Application): AndroidViewModel(application) {
    private var correctNumber by mutableIntStateOf(getNewNumber())

    private var listOfGuesses: List<String> = emptyList()

    private var numberGuessed: Boolean = false
    var attemptsRemaining by mutableIntStateOf(10)
    var failedGuess by mutableStateOf(false)
    var failedText by mutableStateOf("")
    var numberText by mutableStateOf("?")
    var finalText by mutableStateOf("")
    var finalFailText by mutableStateOf("")
    var wrongNumbers by mutableStateOf("")

    fun checkIfNumberIsCorrect(input: String) {
        try {
            if (input.toInt() == correctNumber) {
                numberGuessed = true
                gameFinished()
                return
            }
        } catch (_: Exception) { }
        failedGuess = true
        setFailedText()
        attemptsRemaining -= 1
        listOfGuesses += input
        if (attemptsRemaining == 0) {
            numberGuessed = false
            gameFinished()
        }

    }

    fun setFailedText() {
        failedText = if (failedGuess)
            "No s'ha introduit un número correcte"
        else
            ""
    }

    fun getNewRandNumber() {
        correctNumber = Random.nextInt(1, 11);
        attemptsRemaining = 10
        failedText = ""
        finalText = ""
        finalFailText = ""
        numberText = "?"
        wrongNumbers = ""
        listOfGuesses = emptyList()
    }

    fun gameFinished() {
        if (numberGuessed) {
            finalText = "Enhorabona! Hes encertat el número $correctNumber en ${11 - attemptsRemaining}. \n Puntuació: ${attemptsRemaining * 10}"
        } else {
            finalFailText ="Has perdut! El número era $correctNumber"
        }
        numberText = correctNumber.toString()
        wrongNumbers = "Números erronis: "
        listOfGuesses.forEach { guess -> wrongNumbers += " $guess" }
    }
}