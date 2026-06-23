package com.kotlin.unitconverterapp.sideeffect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun DerivedStateOf() {
    val tableOf by remember { mutableIntStateOf(5) }
    val index = produceState(1) {
        repeat(9) {
            delay(1000.milliseconds)
            value += 1
        }
    }

    val message = derivedStateOf {
        "$tableOf * ${index.value} = ${tableOf * index.value}"
    }

    Box(
        modifier = Modifier.statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message.value)
    }
}

