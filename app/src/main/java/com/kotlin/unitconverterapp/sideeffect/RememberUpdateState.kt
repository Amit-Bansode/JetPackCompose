package com.kotlin.unitconverterapp.sideeffect

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun RememberUpdateState() {
    var counter by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        counter = 10
    }
    Counter(counter = counter)
}

@Composable
fun Counter(modifier: Modifier = Modifier, counter: Int) {
    val state = rememberUpdatedState(counter)
    Box(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Gray)
    ) {
        Text(
            text = counter.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black,
            modifier = modifier.fillMaxWidth()
        )
    }

    LaunchedEffect(Unit) {
        delay(5000.milliseconds)
        Log.d("TAG", "Counter: ${state.value}")
    }
}