package com.goranssonappdev.numberguessinggame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goranssonappdev.numberguessinggame.ui.theme.NumberGuessingGameTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var randomNumber = rememberSaveable {
                mutableStateOf(randomNumber())
            }
//            var guestNumbers = rememberSaveable {
//                mutableStateListOf()
//            }

            NumberGuessingGameTheme {
                Scaffold() {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = randomNumber.value.toString(), fontSize = 50.sp)
                        Button(onClick = {
                            randomNumber.value = randomNumber()
                            Log.d("Tag", randomNumber.toString())
                        }
                        ) {
                            Text(text = "Random Number")
                        }
                        LazyListNumber()


                    }

                }
            }
        }
    }
}


@Composable
fun LazyListNumber() {
    LazyColumn {
        items(100) {
            Text(text = "$it",
                fontSize = 28.sp,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.Green)
                    .clickable(
                        enabled = true,
                        role = Role.Button
                    ) {
                        Log.d("Tag", "$it")
                    }
            )
        }
    }
}
