package com.kotlin.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult::class], version = 1)
abstract class ConversionDB : RoomDatabase() {
    abstract val conversionDAO: ConversionDAO

//    companion object {
//        @Volatile
//        private var conversionDB: ConversionDB? = null

//        fun getInstance(context: Context): ConversionDB {
//            synchronized(this) {
//                var instance = conversionDB
//                if (instance == null) {
//                    instance =
//                        Room.databaseBuilder(context, ConversionDB::class.java, "conversion_db")
//                            .build()
//                }
//                return instance
//            }
//        }
//    }
}