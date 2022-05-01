package com.goranssonappdev.numberguessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.goranssonappdev.numberguessinggame.screen.GuessingGame
import com.goranssonappdev.numberguessinggame.screen.GuessingGameViewModel
import com.goranssonappdev.numberguessinggame.ui.theme.NumberGuessingGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberGuessingGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    val guessingGameViewModel: GuessingGameViewModel by viewModels()

                    val guessedNumber = guessingGameViewModel.getGuessedNumber()

                    GuessingGame(guessedNumber = guessedNumber
                    ) { guessingGameViewModel.guess(it) }

                }
            }
        }
    }
}



