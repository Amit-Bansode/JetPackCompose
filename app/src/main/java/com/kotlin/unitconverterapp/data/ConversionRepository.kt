package com.kotlin.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

interface ConversionRepository {
    fun getAllResults(): Flow<List<ConversionResult>>
    suspend fun deleteResult(conversionResult: ConversionResult)
    suspend fun deleteAllResult()
    suspend fun insertResult(result: ConversionResult)
}