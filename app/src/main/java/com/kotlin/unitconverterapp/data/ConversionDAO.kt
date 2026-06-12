package com.kotlin.unitconverterapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversionDAO {
    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("Delete from RESULT_TABLE")
    suspend fun deleteAll()

    @Query("Select * from RESULT_TABLE")
    fun getResults(): Flow<List<ConversionResult>>
}