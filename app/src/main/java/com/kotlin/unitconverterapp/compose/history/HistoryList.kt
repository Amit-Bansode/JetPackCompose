package com.kotlin.unitconverterapp.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.kotlin.unitconverterapp.data.ConversionResult


@Composable
fun HistoryList(
    list: State<List<ConversionResult>>, modifier: Modifier = Modifier,
    onCloseTask: (ConversionResult) -> Unit
) {
    LazyColumn {
        items(list.value, key = { item -> item.id }) { item ->
            HistoryItem(item.message1, item.message2, onClose = { onCloseTask(item) })
        }
    }
}