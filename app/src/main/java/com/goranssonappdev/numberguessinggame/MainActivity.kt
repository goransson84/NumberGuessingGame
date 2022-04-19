package com.goranssonappdev.numberguessinggame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goranssonappdev.numberguessinggame.ui.theme.NumberGuessingGameTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val guestNumbers = rememberSaveable {
                mutableStateOf(setOf<Int>())
            }

            val rightNumber = rememberSaveable {
                mutableStateOf(randomNumber())
            }

            val numberOfGuesses = rememberSaveable {
                mutableStateOf("3")
            }

            val text = rememberSaveable {
                mutableStateOf("3")
            }


            NumberGuessingGameTheme {

                Scaffold(
                    topBar = {
                        TopAppBar {

                        }
                    }
                ) {
                    Row(modifier = Modifier.fillMaxSize()
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(4f)
                                .background(color = Color.LightGray)
                        ) {
                            Column(modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "${rightNumber.value}", fontSize = 28.sp)
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(color = Color.LightGray)
                        ) {
                            LazyColumn {
                                items(100 + 1) {
                                    Card(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(5.dp)
                                        .clickable {


                                            if (numberOfGuesses.value.toInt() == guestNumbers.value.size) {
                                                Log.d("Tag",
                                                    "${numberOfGuesses.value.toInt()} == ${guestNumbers.value.size}")
                                            } else {
                                                val guess = guestNumbers.value.toMutableSet()
                                                guess.add("$it".toInt())
                                                guestNumbers.value = guess.toSet()

                                                Log.d("Tag", "${guestNumbers.value}")
                                                if ("$it".toInt() == rightNumber.value) {
                                                    Log.d("Tag", "Right number guessed")
                                                }
                                            }


                                        },
                                        elevation = 10.dp,
                                        backgroundColor = if ("$it".toInt() in guestNumbers.value) Color.Red else Color.LightGray
                                    ) {
                                        Text(text = "$it",
                                            fontSize = 28.sp,
                                            textAlign = TextAlign.Center)

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}




