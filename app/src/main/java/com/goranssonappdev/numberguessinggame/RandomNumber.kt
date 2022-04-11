package com.goranssonappdev.numberguessinggame

import kotlin.random.Random

fun randomNumber(first: Int = 0, second: Int = 100): Int {
    return Random.nextInt(first, second)
}