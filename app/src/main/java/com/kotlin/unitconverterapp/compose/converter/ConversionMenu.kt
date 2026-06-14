package com.kotlin.unitconverterapp.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.kotlin.unitconverterapp.data.Conversions

@Composable
fun ConversionMenu(
    list: List<Conversions>,
    modifier: Modifier = Modifier,
    convert: (Conversions) -> Unit
) {
    var displayText by rememberSaveable() { mutableStateOf("Select conversion type") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }

    var icon = if (expanded)
        Icons.Filled.ArrowUpward
    else
        Icons.Filled.ArrowDownward
    Column() {
        OutlinedTextField(
            value = displayText,
            onValueChange = { displayText = it },
            textStyle = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Conversion Type") },
            trailingIcon = {
                Icon(
                    icon, "icon",
                    modifier = modifier.clickable {
                        expanded = !expanded
                    })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(
                    text = { Text(conversion.description) },
                    onClick = {
                        displayText = conversion.description
                        expanded = false
                        convert(conversion)
                    },
                )
            }
        }
    }
}