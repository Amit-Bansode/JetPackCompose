package com.kotlin.unitconverterapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun TopScreen(list: List<Conversions>) {
    val selectedConversions: MutableState<Conversions?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    ConversionMenu(list) {
        selectedConversions.value = it
    }

    selectedConversions.value?.let {
        Log.d("TAG", "TopScreen: $inputText")
        InputBlock(it, inputText) { calculate ->
            Log.d("TAG", "TopScreen: $calculate")
        }
    }
}