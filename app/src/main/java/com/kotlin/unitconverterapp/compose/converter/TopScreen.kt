package com.kotlin.unitconverterapp.compose.converter

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kotlin.unitconverterapp.data.Conversions
import java.text.DecimalFormat

@Composable
fun TopScreen(list: List<Conversions>, result: (String, String) -> Unit) {
    val selectedConversions: MutableState<Conversions?> = remember { mutableStateOf(null) }
    val inputText: MutableState<String> = remember { mutableStateOf("") }
    val typedValue = remember { mutableStateOf("0.0") }
    ConversionMenu(list) {
        selectedConversions.value = it
        typedValue.value = "0.0"
    }

    selectedConversions.value?.let {
        Log.d("TAG", "TopScreen: $inputText")
        InputBlock(it, inputText) { calculate ->
            typedValue.value = calculate
        }
    }

    if (typedValue.value != "0.0") {
        val input: Double = typedValue.value.toDouble()
        val multiplayBy: Double = selectedConversions.value?.multiplyFactor!!.toDouble()
        val result = input * multiplayBy
        Log.d("TAG", "TopScreen: result $result")


        val roundingOf = DecimalFormat("#.####")
        val roundedOffResult = roundingOf.format(result)
        Log.d("TAG", "TopScreen: roundedOffResult $roundedOffResult")

        val message1 =
            "${typedValue.value + " "} ${selectedConversions.value!!.convertFrom}" + "is equal to"
        val message2 = roundedOffResult + " " + selectedConversions.value!!.convertTo
        result(message1, message2)
        ResultBlock(message1, message2)
    }
}