package com.kotlin.unitconverterapp.sideeffect

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SideEffect(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    var total by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }
    var round by remember { mutableStateOf(1) }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = round) {
        snackbarHostState.showSnackbar("Round $round")
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(50.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "Total is ${total.toString()}",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.DarkGray
            )

            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                placeholder = { Text("Enter value here") },
                value = input,
                onValueChange = {
                    input = it
                },
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                label = { Text(text = "New count") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("clicked button : Round $round")

                    }

                    val value = input.toDoubleOrNull() ?: 0.0
                    total += value
                    if (total > 300) {
                        round += 1
                        total = 0.0
                        input = ""
                    }
                }
            ) {
                Text(
                    text = "Count",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}