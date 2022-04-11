package com.goranssonappdev.numberguessinggame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.goranssonappdev.numberguessinggame.ui.theme.NumberGuessingGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var randomNumber = rememberSaveable {
                mutableStateOf(randomNumber())
            }

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
                        

                    }

                }

            }
        }
    }
}
