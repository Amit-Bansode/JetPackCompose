package com.kotlin.unitconverterapp.compose.converter

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kotlin.unitconverterapp.data.Conversions
import java.text.DecimalFormat

@Composable
fun TopScreen(
    selectedConversions: MutableState<Conversions?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    list: List<Conversions>, result: (String, String) -> Unit
) {
    var isSaved by remember { mutableStateOf(false) }

    ConversionMenu(list) { it ->
        selectedConversions.value = it
        typedValue.value = "0.0"
        isSaved = true
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
        if (isSaved) {
            result(message1, message2)
            isSaved = false
        }
        ResultBlock(message1, message2)
    }
}