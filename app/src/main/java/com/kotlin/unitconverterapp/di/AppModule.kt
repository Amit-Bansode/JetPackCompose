package com.kotlin.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.kotlin.unitconverterapp.data.ConversionDB
import com.kotlin.unitconverterapp.data.ConversionRepository
import com.kotlin.unitconverterapp.data.ConversionRepositoryIMPL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDB(context: Application): ConversionDB {
        return Room.databaseBuilder(context, ConversionDB::class.java, "conversion_db").build()
    }

    @Provides
    @Singleton
    fun provideConversionRepository(db: ConversionDB): ConversionRepository {
        return ConversionRepositoryIMPL(db.conversionDAO)
    }
}