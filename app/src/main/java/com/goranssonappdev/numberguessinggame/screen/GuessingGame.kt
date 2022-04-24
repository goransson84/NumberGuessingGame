package com.goranssonappdev.numberguessinggame.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goranssonappdev.numberguessinggame.components.UserGuess

@Composable
fun GuessingGame(guessedNumbers: Int, addGuessedNumber: (Int) -> Int) {

    Column(modifier = Modifier.background(color = Color.Red)) {
        TopAppBar() {

        }
        Row {
            InfoGuessingView(modifier = Modifier
                .weight(1f)
                .fillMaxSize())

            UserGuess(guessingNumbers = 100, onNumberClicked = {}, modifier = Modifier
                .background(Color.Green)
                .width(100.dp))
        }

    }
}

@Composable
fun InfoGuessingView(modifier: Modifier = Modifier) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Guessed number", fontSize = 28.sp)

    }
}


@Preview(showBackground = true)
@Composable
fun GuessingGamePreview() {
    GuessingGame(guessedNumber = {})
}