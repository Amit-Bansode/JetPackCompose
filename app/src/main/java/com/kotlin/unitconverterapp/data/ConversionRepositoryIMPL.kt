package com.kotlin.unitconverterapp.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConversionRepositoryIMPL @Inject constructor(private val dao: ConversionDAO) :
    ConversionRepository {
    override fun getAllResults(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }

    override suspend fun deleteResult(conversionResult: ConversionResult) {
        dao.deleteResult(conversionResult)
    }

    override suspend fun deleteAllResult() {
        dao.deleteAll()
    }

    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }
}