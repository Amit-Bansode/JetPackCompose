package com.kotlin.unitconverterapp

data class Conversions(
    val id: Int,
    val description: String,
    val convertFrom: String,
    val convertTo: String,
    val multiplyFactor: Double,
)
