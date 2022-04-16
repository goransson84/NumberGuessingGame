package com.goranssonappdev.numberguessinggame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
                mutableStateOf(mutableSetOf<Int>(10,11,2,22))
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
                            Text(
                                text = "1F",
                                style = MaterialTheme.typography.caption
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(color = Color.LightGray)
                        ) {
                            LazyColumn {
                                items(1000 + 1) {
                                    Card(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(5.dp)
                                        //.background(if ("$it".toInt() !in guestNumbers.value) Color.Green else Color.Red)
                                        .clickable {
                                            guestNumbers.value.add("$it".toInt())
                                            Log.d("Tag", "${guestNumbers.value}")
                                        },
                                        elevation = 10.dp,
                                        backgroundColor = if ("$it".toInt() in guestNumbers.value) Color.Red else Color.LightGray
                                    ) {
                                        Text(text = "$it", fontSize = 28.sp, textAlign = TextAlign.Center)

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

