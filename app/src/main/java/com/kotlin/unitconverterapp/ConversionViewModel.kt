package com.kotlin.unitconverterapp

import androidx.lifecycle.ViewModel

class ConversionViewModel : ViewModel() {
    fun getConversions() = listOf(
        Conversions(1, "Pounds to Kilogram", "lbs", "kg", 0.453592),
        Conversions(2, "Kilogram to Pounds", "kg", "lbs", 2.20462),
        Conversions(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversions(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversions(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversions(6, "Kilometers to Miles", "km", "mi", 0.621371)
    )
}