package com.kotlin.unitconverterapp.sideeffect

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import kotlinx.coroutines.launch


@Composable
fun SideEffect(
    modifier: Modifier = Modifier, context: Context = LocalContext.current
) {
    var total by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }
    var round by remember { mutableStateOf(1) }

    val snackbarHostState = remember { SnackbarHostState() }

    val scope = rememberCoroutineScope()
    //side effect. making toast is not in the scope of composition. wo its get called every time recomposition happens
    // this needs to be handled by LaunchedEffect
//    LaunchedEffect(key1 = round) {
//        snackbarHostState.showSnackbar(
//            "Please start counting: Round$round",
//            "Dismiss",
//            duration = SnackbarDuration.Short
//        )
//    }

    Scaffold(
        snackbarHost = {
            androidx.compose.material3.SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
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
                        color = Color.DarkGray, fontSize = 30.sp, fontWeight = FontWeight.Bold
                    ),
                    label = { Text(text = "New count") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )

                Button(
                    modifier = modifier.fillMaxWidth(), onClick = {
                        val value = input.toDoubleOrNull() ?: 0.0
                        total += value
                        if (total > 300) {
                            input = ""
                            total = 0.0
                            round += 1

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "Please start counting: Round$round",
                                    "Dismiss",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }

                    }) {
                    Text(
                        text = "Count", fontSize = 30.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }


}