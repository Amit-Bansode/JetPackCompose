package com.kotlin.unitconverterapp.sideeffect

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun ProduceState() {

    loader()
}

@Composable
fun loader() {

    val rotateBy by produceState(initialValue = 0) {
        while (true) {
            delay(100.milliseconds)
            value = (value + 30) % 360
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.Center,
        content = {
            Column() {
                Image(
                    imageVector = Icons.Default.Refresh, contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(rotateBy.toFloat())
                )

                Text("Loading..")
            }
        }
    )
}