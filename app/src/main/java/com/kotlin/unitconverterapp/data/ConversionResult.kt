package com.kotlin.unitconverterapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("result_id")
    val id : Int,
    @ColumnInfo("result_message1")
    val message1 : String,
    @ColumnInfo("result_message2")
    val message2 : String,
)
