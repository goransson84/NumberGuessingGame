package com.goranssonappdev.numberguessinggame.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserGuess(
    modifier: Modifier = Modifier,
    guessingNumbers: Int,
    onNumberClicked:(Int) -> Unit
) {

    LazyColumn(modifier = modifier) {
        items(guessingNumbers + 1)
        {
            Card(modifier = Modifier
                .padding(5.dp)
                .fillMaxSize()
                .clickable { },
                elevation = 10.dp
            ) {
                Text(text = "$it", fontSize = 28.sp, textAlign = TextAlign.Center)
            }
        }
    }
}