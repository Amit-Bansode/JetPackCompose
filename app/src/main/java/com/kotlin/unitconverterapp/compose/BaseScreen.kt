package com.kotlin.unitconverterapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlin.unitconverterapp.ConversionViewModel
import com.kotlin.unitconverterapp.ConverterViewModelFactory
import com.kotlin.unitconverterapp.compose.converter.TopScreen
import com.kotlin.unitconverterapp.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    conversionViewModel: ConversionViewModel = viewModel(factory = factory)
) {

    val list = conversionViewModel.getConversions()
    val historyList = conversionViewModel.resultList.collectAsState(emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding()
    ) {
        TopScreen(list) { t1, t2 ->
            conversionViewModel.addResult(t1, t2)
        }
        Spacer(modifier.padding(20.dp))
        HistoryScreen(
            historyList, modifier,
            onCloseTask = {
                conversionViewModel.deleteResult(it)
            },
            onClearAll = {
                conversionViewModel.clearAll()
            })
    }
}