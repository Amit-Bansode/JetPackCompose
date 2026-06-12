package com.kotlin.unitconverterapp

import android.os.Message
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.unitconverterapp.data.ConversionRepository
import com.kotlin.unitconverterapp.data.ConversionResult
import com.kotlin.unitconverterapp.data.Conversions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConversionViewModel(private val repository: ConversionRepository) : ViewModel() {
    fun getConversions() = listOf(
        Conversions(1, "Pounds to Kilogram", "lbs", "kg", 0.453592),
        Conversions(2, "Kilogram to Pounds", "kg", "lbs", 2.20462),
        Conversions(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversions(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversions(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversions(6, "Kilometers to Miles", "km", "mi", 0.621371)
    )

    val resultList = repository.getAllResults()

    fun addResult(message1: String, message2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionResult(0, message1, message2))
        }
    }

    fun deleteResult(conversionResult: ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResult(conversionResult)
        }
    }

    fun clearAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResult()
        }
    }
}