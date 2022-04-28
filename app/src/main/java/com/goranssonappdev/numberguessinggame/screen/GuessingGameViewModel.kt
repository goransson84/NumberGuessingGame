package com.goranssonappdev.numberguessinggame.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GuessingGameViewModel : ViewModel() {

    private var guessedNumber = mutableStateOf(setOf<Int>(1,3))

    fun guess(guess: Int) {
        guessedNumber.value += guess
        Log.d("TAG", "$guessedNumber")
    }

    fun getGuessedNumber(): Set<Int> {
        return guessedNumber.value
    }
}