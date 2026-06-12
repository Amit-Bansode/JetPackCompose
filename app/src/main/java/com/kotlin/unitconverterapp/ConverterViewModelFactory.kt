package com.kotlin.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.unitconverterapp.data.ConversionRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(private val repository: ConversionRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ConversionViewModel(repository) as T
}