package com.goranssonappdev.numberguessinggame.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goranssonappdev.numberguessinggame.R

@Composable
fun GuessingGame(guessedNumber: Set<Int>, guess: (Int) -> Int) {

    Column(modifier = Modifier
        .background(color = Color.Red)
        .padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            }
        )

        Row {
            InfoGuessingView(modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
                guessedNumber = guessedNumber)


            LazyColumn() {
                items(100 + 1) { number ->
                    numbersRow(guessingNumbers = number,
                        onNumberClicked = { guess(number) },
                        modifier = Modifier
                            .background(Color.Green)
                            .width(100.dp))
                }
            }
        }

    }
}

@Composable
fun InfoGuessingView(modifier: Modifier = Modifier, guessedNumber: Set<Int>) {
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "$guessedNumber", fontSize = 28.sp)
    }
}

@Composable
fun numbersRow(
    modifier: Modifier = Modifier,
    guessingNumbers: Int,
    onNumberClicked: (Int) -> Unit,
) {

    Card(modifier = modifier
        .padding(5.dp)
        .fillMaxSize()
        .clickable {
            onNumberClicked(guessingNumbers)

        },
        //backgroundColor = if ("$guessingNumbers".toInt() in guessedNumbers) Color.Red else Color.LightGray,
        elevation = 10.dp
    ) {
        Text(text = "$guessingNumbers", fontSize = 28.sp, textAlign = TextAlign.Center)
    }
}


@Preview(showBackground = true)
@Composable
fun GuessingGamePreview() {
    //GuessingGame()
}